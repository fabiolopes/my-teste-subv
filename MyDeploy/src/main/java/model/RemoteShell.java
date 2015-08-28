package model;

import exceptions.RuntimeScriptException;
import gui.TelaInicio;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import services.BuildServices;

public class RemoteShell {

	private final Logger LOG = LoggerFactory.getLogger(RemoteShell.class);
	private String machine;
	private final String USER = "usersiebel";
	private final String PASS = "siebel2014";

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

	public void executeCommand(final Script command,
			final BuildServices buildServices, final TelaInicio telaInicio)
			throws IOException, RuntimeScriptException {
		// Cliente SSH
		machine = command.getServer();
		final SSHClient ssh = new SSHClient();
		try {
			// Configura tipo de KeyVerifier
			setupKeyVerifier(ssh);
			// Conecta com a maquina remota
			ssh.connect(machine);
			// Autenticacao
			ssh.authPassword(USER, PASS);
			// Executa comando remoto
			executeCommandBySSH(ssh, command, buildServices, telaInicio);
		} finally {
			ssh.disconnect();
		}
	}

	private void executeCommandBySSH(final SSHClient ssh, final Script command,
			final BuildServices buildServices, final TelaInicio telaInicio)
			throws ConnectionException, IOException, TransportException,
			RuntimeScriptException {
		final Session session = ssh.startSession();
		BufferedReader bf = null;
		try {
			// Executa comando
			
			buildServices.sendOutputToTela(telaInicio, command.getDescricao());
			final Command cmd = session.exec(command.getScript());
			bf = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
			String line;
			// Imprime saida, se exister
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
				buildServices.sendOutputToTela(telaInicio, line);
			}

			BufferedReader errorBF = new BufferedReader(new InputStreamReader(
					cmd.getErrorStream()));

			String errorMsg = "";
			String errorLine;
			while ((errorLine = errorBF.readLine()) != null) {
				errorMsg = errorMsg + errorLine + "\n";
			}
			if (!errorMsg.isEmpty()) {
				buildServices.sendOutputToTela(telaInicio, command.getDescricao()+"KO");
				throw new RuntimeScriptException(errorMsg);
			}

			// Aguarda
			cmd.join(1, TimeUnit.SECONDS);
			buildServices.sendOutputToTela(telaInicio, command.getDescricao()+": OK");
		} finally {
			secureClose(bf);
			secureClose(session);
		}
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

}