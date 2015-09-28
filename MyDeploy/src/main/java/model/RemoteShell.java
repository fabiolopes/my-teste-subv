package model;

import dao.DeployDao;
import exceptions.RuntimeScriptException;
import gui.TelaInicio;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import services.BuildServices;
import util.PkgDeployConstants;

public class RemoteShell {

	private final Logger LOG = LoggerFactory.getLogger(RemoteShell.class);
	private String machine;
	private final String USER = "usersiebel";
	private final String PASS = "siebel2014";
	public static String omTxt;

	public RemoteShell(String machine) {
		this.machine = machine;
	}

	public RemoteShell() {
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public boolean executeCommand(Script command,
			final BuildServices buildServices, final TelaInicio telaInicio)
			throws Exception {
		// Cliente SSH
		machine = command.getServer();
		boolean rodou = false;
		final SSHClient ssh = new SSHClient();
		try {
			// Configura tipo de KeyVerifier
			setupKeyVerifier(ssh);
			// Conecta com a maquina remota
			ssh.connect(machine);
			// Autenticacao
			ssh.authPassword(USER, PASS);
			// Executa comando remoto
			rodou = executeCommandBySSH(ssh, command, buildServices, telaInicio);
		} finally {
			ssh.disconnect();
		}
		
		return rodou;
	}

	private boolean executeCommandBySSH(final SSHClient ssh, final Script command,
			final BuildServices buildServices, final TelaInicio telaInicio)
			throws RuntimeScriptException, Exception {
		final Session session = ssh.startSession();
		BufferedReader bf = null;
		boolean rodou = false;
		try {
			// Executa comando

			sendInfoToScreen(buildServices, telaInicio, command.getDescricao());
			final Command cmd = session.exec(command.getScript());
			bf = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
			String line;
			// Imprime saida, se exister
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
				buildServices.sendOutputToTela(telaInicio, line);
				// Se o comando for o cat, pega o omTxt
				if (command.getScript().contains(PkgDeployConstants.CMD_CAT_OM)) {
					omTxt = line;
				}

			}

			if (!command.getDescricao().contains("GUI")) {
				BufferedReader errorBF = new BufferedReader(
						new InputStreamReader(cmd.getErrorStream()));

				String errorMsg = "";
				String errorLine;
				while ((errorLine = errorBF.readLine()) != null) {
					errorMsg = errorMsg + errorLine + "\n";
				}

				if (!errorMsg.isEmpty()
						&& !command.getDescricao().contains("agents")) {
					sendInfoToScreen(buildServices, telaInicio, command.getDescricao() + ": KO");
					throw new RuntimeScriptException(errorMsg);
				}
			}
			if (command.getScript().contains("./deploy")) {
				DeployDao dao = new DeployDao(getMachine());
				String desc[] = command.getDescricao().split(" ");
				String pkg = desc[0];
				if (!dao.localizarDeploy(omTxt, pkg)) {
					sendInfoToScreen(buildServices, telaInicio, command.getDescricao() + ": KO");
					throw new RuntimeScriptException(
							"Erro ao executar deploy do " + pkg);
				}
			}

			// Aguarda
			cmd.join(1, TimeUnit.SECONDS);
			sendInfoToScreen(buildServices, telaInicio, command.getDescricao()
					+ ": OK");
			rodou = true;
		} finally {
			try {
				secureClose(bf);
				secureClose(session);
			} finally {

			}
		}
		return rodou;
	}

	private void setupKeyVerifier(final SSHClient ssh) {
		ssh.addHostKeyVerifier(new HostKeyVerifier() {
			public boolean verify(String arg0, int arg1, PublicKey arg2) {
				return true;// sem verificacao
			}
		});
	}

	private void secureClose(final Closeable resource) {
		try {
			if (resource != null) {
				resource.close();
			}
		} catch (IOException ex) {
			LOG.error("Erro ao fechar recurso", ex);
			System.out.println("Erro ao fechar");
		}
	}

	private void sendInfoToScreen(final BuildServices buildServices,
			final TelaInicio telaInicio, final String info) {
		buildServices.sendOutputToTela(telaInicio, info);
		buildServices.sendStatusCode(telaInicio, info);
	}

}
