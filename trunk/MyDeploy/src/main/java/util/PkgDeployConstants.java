package util;

public class PkgDeployConstants {
	
	public static final String TAR_NAME = "OM-*";
	//dados das máquinas{
	public static final String MACHINE_DEV1 = "10.43.1.84";
	public static final String MACHINE_DEV2 = "10.43.1.109";
	public static final String MACHINE_ST1 = "10.43.1.87";
	public static final String MACHINE_ST2 = "10.43.1.110";
	public static final String SSH_MACHINE_ST1 = "usersiebel@"+MACHINE_ST1;
	public static final String SSH_MACHINE_ST2 = "usersiebel@1"+MACHINE_ST2;
	//}
	//pastas{
	public static final String FOLDER_MAIN = "/oradata/om/";
	public static final String FOLDER_STABLE_BUILD_SCRIPTS = FOLDER_MAIN+"stable_build_scripts/";
	public static final String FOLDER_PKG_STABLE = FOLDER_MAIN+"stable_build_scripts/pkg/";
	public static final String FOLDER_PKG_ST = FOLDER_MAIN+"pkg/";
	public static final String FOLDER_DEPLOY_SCRIPTS_ST = FOLDER_MAIN+"deploy_scripts/";
	//}
	//scripts de geração de pacotes(Executá-los dentro de $FOLDER_STABLE_BUILD_SCRIPTS){
	public static final String SCRIPT_GET_CODE = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./get_code.sh;";
	public static final String SCRIPT_BUILD_JAVA = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./buildJava.sh;";
	public static final String SCRIPT_PKG_ALL_JAVA = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./pkgAllJava.sh;";
	public static final String SCRIPT_PKG_BPM = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./pkgBPM.sh;";
	//Passar como argumento "num_delta+;"
	public static final String SCRIPT_PKG_SQL_DELTA = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./pkgSQL_auto.sh ";
	public static final String SCRIPT_PKG_ALL = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./pkgAll.sh;";
	//Executar após usar o $SCRIPT_PKG_ALL
	public static final String SCRIPT_COMMIT_PKG_SVN = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";./caddsvn.sh pkg/"+TAR_NAME;
	//}
	//scripts de deploy(Executá-los dentro de $FOLDER_DEPLOY_SCRIPTS_ST){
	//está sem "./" pq é chamado direto via ssh
	public static final String SCRIPT_CREATE_PKG_FOLDER = "create_pkg_folder.sh;";
	public static final String SCRIPT_DEPLOY_EJB = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployEJBs.sh;";
	public static final String SCRIPT_DEPLOY_MOD = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployModules.sh;";
	public static final String SCRIPT_DEPLOY_GUI = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployGUI.sh;";
	public static final String SCRIPT_DEPLOY_BPM = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployBPM.sh;";
	public static final String SCRIPT_DEPLOY_WS = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployWS.sh;";
	public static final String SCRIPT_DEPLOY_AGE = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deployAgents.sh;";
	//Passar como argumento "num_delta+;"
	public static final String SCRIPT_DEPLOY_SQL = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./deploySQL.sh ";
	public static final String SCRIPT_FULL_RESTART = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";./full_restart.sh;";
	//}
	//Comandos para tranferência do TAR para a pasta pkg ST{
	public static final String CMD_ST1_CALL_CREATE_PKG_FOLDER = "ssh "+SSH_MACHINE_ST1+" sh "+FOLDER_DEPLOY_SCRIPTS_ST+SCRIPT_CREATE_PKG_FOLDER;
	public static final String CMD_ST2_CALL_CREATE_PKG_FOLDER = "ssh "+SSH_MACHINE_ST2+" sh "+FOLDER_DEPLOY_SCRIPTS_ST+SCRIPT_CREATE_PKG_FOLDER;
	public static final String CMD_ST1_CPY_TAR_TO_PKG = "scp pkg/"+TAR_NAME+" "+SSH_MACHINE_ST1+":"+FOLDER_PKG_ST+";";
	public static final String CMD_ST2_CPY_TAR_TO_PKG = "scp pkg/"+TAR_NAME+" "+SSH_MACHINE_ST2+":"+FOLDER_PKG_ST+";";
	public static final String CMD_ST1_UNTAR_OM_TAR = "ssh "+SSH_MACHINE_ST1+" tar -xvf "+FOLDER_DEPLOY_SCRIPTS_ST+TAR_NAME+";";
	//}

}
