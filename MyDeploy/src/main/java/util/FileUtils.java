package util;

import exceptions.RuntimeScriptException;
import exceptions.TransferFilesException;
import gui.TelaInicio;

import java.io.File;

import services.BuildServices;

public class FileUtils {

	public static void createLocalPkgStructure(String fqaPkg,
			BuildServices buildServices, TelaInicio telaInicio)
			throws RuntimeScriptException, Exception {
		String nomeDiretorio = new String();
		nomeDiretorio = "C:/java/" + fqaPkg;
		createPkgFolder(nomeDiretorio, buildServices, telaInicio);
		createPkgFolder(nomeDiretorio + "/pkg", buildServices, telaInicio);
	}

	private static void createPkgFolder(String folder,
			BuildServices buildServices, TelaInicio telaInicio)
			throws TransferFilesException, Exception {
		if (!new File(folder).exists()) { // Verifica se o diretório
											// existe.
			(new File(folder)).mkdir(); // Cria o diretório
		}
		if (!new File(folder).exists()) {
			buildServices.sendOutputToTela(telaInicio,
					"Erro ao criar o diretório " + folder);
			throw new TransferFilesException("Diretório não foi criado");
		}
	}

	public static boolean isDiretorioVazio(String fqaPkg,
			BuildServices buildServices, TelaInicio telaInicio)
			throws TransferFilesException, Exception {
		String path = "C:/java/" + fqaPkg;
		File dir = new File(path);
		String[] children = dir.list();
		boolean temArquivo = false;
		if (children.length < 1) {
			// Diretorio nao existe ou nao eh um diretorio
			throw new TransferFilesException(
					"Os pacotes não foram transferidos corretamente");
		}else if(!move(path + "/pkg/OM.txt", path)){
			throw new TransferFilesException(
					"problemas para posicionar o arquivo OM.txt na raiz da pasta " + fqaPkg);
		} else {
			temArquivo = true;
		}
		return temArquivo;
	}

	public static boolean move(String fileName, String newPath) {

		// arquivo a ser movido
		File arquivo = new File(fileName);

		// diretorio de destino
		File dir = new File(newPath);

		// move o arquivo para o novo diretorio
		return arquivo.renameTo(new File(dir, arquivo.getName()));

	}
}
