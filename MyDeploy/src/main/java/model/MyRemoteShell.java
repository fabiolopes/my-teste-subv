package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.xfer.FileSystemFile;
import net.schmizz.sshj.xfer.scp.SCPDownloadClient;

public class MyRemoteShell {

    private final Logger LOG = LoggerFactory.getLogger(RemoteShell.class);
    private String machine;
    private final String USER = "usersiebel";
    private final String PASS = "siebel2014";

    public MyRemoteShell(String machine) {
        this.machine = machine;
    }

    public MyRemoteShell() {
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public void executeCommand() throws IOException {
        // Cliente SSH 
        final SSHClient ssh = new SSHClient();
        try {
            // Configura tipo de KeyVerifier 
            setupKeyVerifier(ssh);
            // Conecta com a maquina remota 
            ssh.connect(machine);
            // Autenticacao 
            ssh.authPassword(USER, PASS);
            // Executa comando remoto 
            downloadFile(ssh);
        } finally {
            ssh.disconnect();
        }
    }

    public void downloadFile(final SSHClient ssh) throws IOException{
    	SCPDownloadClient downCli = ssh.newSCPFileTransfer().newSCPDownloadClient();
    	String file = "/oradata/om/deploy_scripts/full_restart.sh";
    	File f = new File("C:/java");
    	downCli.copy(file, new FileSystemFile(f));
    	secureClose(ssh);
    }
    
    private void executeCommandBySSH(final SSHClient ssh, final Object command) throws ConnectionException, IOException, TransportException {
        final Session session = ssh.startSession();
        BufferedReader bf = null;
        try {
            // Executa comando 
        	Command cmd = null;
        	
        		cmd = session.exec((String)command);
        	
            bf = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
            String line;
            // Imprime saida, se exister 
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            // Aguarda 
            cmd.join(1, TimeUnit.SECONDS);
        } finally {
            secureClose(bf);
            secureClose(session);
        }
    }

    private void setupKeyVerifier(final SSHClient ssh) {
        ssh.addHostKeyVerifier(
                new HostKeyVerifier() {
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
