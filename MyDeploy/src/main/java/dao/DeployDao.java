package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexao;

public class DeployDao {

	private Connection conexao; 

    public DeployDao(String host) throws SQLException {     
    	this.conexao = Conexao.getConexao(host);
    }


   
    public boolean localizarDeploy(String pkg, String omTxt) throws SQLException {
        boolean existeDeploy = false;
    	String sql = "SELECT * FROM UTI_TRACK_DEPLOY WHERE UTD_FILE_NAME LIKE ? AND UTD_FILE_NAME LIKE ? AND UTD_RESULT='OK'";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%"+pkg+"%");
        stmt.setString(2, "%"+omTxt+"%");
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
        	existeDeploy = true;
        }
        rs.close();
        stmt.close();
        return existeDeploy;
    }

  
}
