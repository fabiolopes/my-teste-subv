package util;

public class PkgDeployConstants {
	
	public static final String TAR_NAME = "OM-*";
	//dados das m�quinas{
	public static final String MACHINE_DEV1 = "10.43.1.84";
	public static final String MACHINE_DEV2 = "10.43.1.109";
	public static final String MACHINE_ST1 = "10.43.1.87";
	public static final String MACHINE_ST2 = "10.43.1.110";
	public static final String MACHINE_USER = "usersiebel";
	public static final String SSH_MACHINE_ST1 = "usersiebel@"+MACHINE_ST1;
	public static final String SSH_MACHINE_ST2 = "usersiebel@"+MACHINE_ST2;
	//}
	//pastas{
	public static final String FOLDER_MAIN = "/oradata/om/";
	public static final String FOLDER_OFFICIAL_BUIL_SCRIPTS = FOLDER_MAIN+"official_build_scripts/";
	public static final String FOLDER_STABLE_BUILD_SCRIPTS = FOLDER_MAIN+"stable_build_scripts/";
	public static final String FOLDER_PKG_STABLE = FOLDER_MAIN+"stable_build_scripts/pkg/";
	public static final String FOLDER_PKG_ST = FOLDER_MAIN+"pkg/";
	public static final String FOLDER_PKG_ASST = FOLDER_MAIN+"pkg_asst/";
	public static final String FOLDER_DEPLOY_SCRIPTS_ST = FOLDER_MAIN+"deploy_scripts/";
	public static final String FOLDER_DEPLOY_ASST_SCRIPTS = FOLDER_MAIN+"deploy_asst_scripts/";
	//}
	
	//Comando de entrada nas pastas{
	public static final String CD_OFFICIAL_BUILD_SCRIPTS = "cd "+FOLDER_OFFICIAL_BUIL_SCRIPTS+";";
	public static final String CD_STABLE_BUILD_SCRIPTS = "cd "+FOLDER_STABLE_BUILD_SCRIPTS+";";
	public static final String CD_FOLDER_ST_DEPLOY_SCRIPTS = "cd "+FOLDER_DEPLOY_SCRIPTS_ST+";";
	public static final String CD_FOLDER_ASST_DEPLOY_SCRIPTS = "cd "+FOLDER_DEPLOY_ASST_SCRIPTS+";";
	//}
	
	//scripts de gera��o de pacotes(Execut�-los dentro de $FOLDER_STABLE_BUILD_SCRIPTS){
	public static final String SCRIPT_GET_CODE = "./get_code.sh;";
	public static final String SCRIPT_BUILD_JAVA = "./buildJava.sh;";
	public static final String SCRIPT_PKG_ALL_JAVA = "./pkgAllJava.sh;";
	public static final String SCRIPT_PKG_BPM = "./pkgBPM.sh;";
	//Passar como argumento "num_delta+;"
	public static final String SCRIPT_PKG_SQL_DELTA = "./pkgSQL_auto.sh ";
	public static final String SCRIPT_PKG_ALL = "./pkgAll.sh;";
	//Executar ap�s usar o $SCRIPT_PKG_ALL
	public static final String SCRIPT_COMMIT_PKG_SVN = "./caddsvn.sh pkg/"+TAR_NAME;
	public static final String SCRIPT_COPYLOCAL = CD_OFFICIAL_BUILD_SCRIPTS+"./copyLocal.sh .."+FOLDER_PKG_ASST+";";
	//}
	//scripts de deploy(Execut�-los dentro de $FOLDER_DEPLOY_SCRIPTS_ST){
	//est� sem "./" pq � chamado direto via ssh
	public static final String CMD_CAT_OM = "cat OM.txt;";
	public static final String SCRIPT_CREATE_PKG_FOLDER = "./create_pkg_folder.sh;";
	public static final String SCRIPT_DEPLOY_EJB = "./deployEJBs.sh;";
	public static final String SCRIPT_DEPLOY_MOD = "./deployModules.sh;";
	public static final String SCRIPT_DEPLOY_GUI = "./deployGUI.sh;";
	public static final String SCRIPT_DEPLOY_BPM = "./deployBPM.sh;";
	public static final String SCRIPT_DEPLOY_WS = "./deployWS.sh;";
	public static final String SCRIPT_DEPLOY_AGE = "./deployAgents.sh;";
	//Passar como argumento "num_delta+;"
	public static final String SCRIPT_DEPLOY_SQL = "./deploySQL.sh ";
	public static final String SCRIPT_DEPLOY_SQL_P212_1 = "./deploySQLp21.sh ";
	public static final String SCRIPT_DEPLOY_SQL_P212_2 = "./deploySQLp22.sh ";
	public static final String SCRIPT_FULL_RESTART = "./full_restart.sh;";
	public static final String SCRIPT_RESTART_AGENTS = "./full_restart.sh agents;";
	public static final String SCRIPT_RESTART_JBOSS = "./full_restart.sh jboss;";
	//}
	//Comandos para tranfer�ncia do TAR para a pasta pkg ST{
	public static final String CMD_ST1_CPY_TAR_TO_PKG = "scp "+FOLDER_STABLE_BUILD_SCRIPTS+"pkg/"+TAR_NAME+" "+SSH_MACHINE_ST1+":"+FOLDER_PKG_ST+";";
	public static final String CMD_ST2_CPY_TAR_TO_PKG = "scp "+FOLDER_STABLE_BUILD_SCRIPTS+"pkg/"+TAR_NAME+" "+SSH_MACHINE_ST2+":"+FOLDER_PKG_ST+";";
	public static final String CMD_ST1_UNTAR_OM_TAR = "ssh "+SSH_MACHINE_ST1+" tar -xvf "+FOLDER_PKG_ST+TAR_NAME+";";
	public static final String CMD_ST2_UNTAR_OM_TAR = "ssh "+SSH_MACHINE_ST2+" tar -xvf "+FOLDER_PKG_ST+TAR_NAME+";";
	public static final String CMD_ST1_PREPARE_PKG_FOLDER = CMD_ST1_CPY_TAR_TO_PKG+CMD_ST1_UNTAR_OM_TAR;
	public static final String CMD_ST2_PREPARE_PKG_FOLDER = CMD_ST2_CPY_TAR_TO_PKG+CMD_ST2_UNTAR_OM_TAR;
	//}

}
