package util;

import exceptions.RuntimeScriptException;
import exceptions.TransferFilesException;
import gui.TelaInicio;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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

	public static Document getXMLDocumentFromInputStream(InputStream content) {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = builderFactory.newDocumentBuilder();
			StringBuilder xmlString = new StringBuilder();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
		    String str = "";
		    while ((str = in.readLine()) != null) {
		        xmlString.append(str);
		    }
		    
	        return (Document) builder.parse(new ByteArrayInputStream(xmlString.toString().getBytes()));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		return null;
	}
}