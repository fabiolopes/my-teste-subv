package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.sharepoint.Feed;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import util.FileUtils;
import util.SetupUtil;

@SuppressWarnings("deprecation")
public class SharePointConnector {
	private char[] password;

	@SuppressWarnings({ "resource" })
	public Feed querySharePoint(String queryString) {
		String host = SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_host");
		String protocol = SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_protocol");
		String path = SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_path");
		int port = Integer.parseInt(SetupUtil.getValue(SetupUtil.ACCESS_SECTION, "sharepoint_port"));

		URI uri;
		try {
			uri = new URI(protocol, null, host, port, path, queryString, null);
			DefaultHttpClient httpClient = new DefaultHttpClient();

			HttpHost target = new HttpHost(host, port, protocol);

			HttpGet httpget = new HttpGet(uri.toASCIIString());
			NTCredentials creds = new NTCredentials("julio.cesar.barbosa", new String(password).toString(), "", "DIR");
			httpClient.getCredentialsProvider().setCredentials(new AuthScope(target), creds);
			httpget.addHeader(HttpHeaders.USER_AGENT, "Mozilla/4.0+(compatible;+MSIE+5.01;+Windows+NT+5.0");
			HttpResponse response;

			response = httpClient.execute(httpget);
			
			if (response.getEntity().getContent() !=null) {
				Document xmlDocument = FileUtils.getXMLDocumentFromInputStream(response.getEntity().getContent());

				JAXBContext jaxbContext = JAXBContext.newInstance(Feed.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				return (Feed) jaxbUnmarshaller.unmarshal(xmlDocument);
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
}
