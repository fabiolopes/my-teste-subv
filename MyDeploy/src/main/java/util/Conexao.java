package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection getConexao(String myHost) throws SQLException {
        try {

            String driver = "oracle.jdbc.driver.OracleDriver"; //Classe do driver JDBC
            String sid = "OMDBT1"; //Nome do Banco criado
            String portNumber = "1521";
            String host = myHost; //Maquina onde est� o banco
            String url = "jdbc: oracle:thin:@" + host + ":" + portNumber + ":" + sid;   //URL de conex�o
            String usuario = "sds_admin"; //Usu�rio do banco
            String senha = "sds_admin"; //Senha de conex�o

            Class.forName(driver); //Carrega o driver
            //Obt�m a conex�o com o banco
            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException e) {

            throw new SQLException(e.getMessage());
        }
    }
}
