package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.ini4j.Ini;

public class SetupUtil {
	private static File SETUP_FILE; 
	
	static final String SETUP_FILE_PATH = "resource/setup.ini";
	public static final String ACCESS_SECTION = "access";
	public static final String SYSTEM_SECTION = "system";

	public static String getValue(String section, String key) {
    	Ini ini = getIniReader();
		return ini.get(section, key);
	}
	
	public static void setValue(String section, String key, String value) {
    	try {
    		Ini ini = getIniReader();
    		ini.put(section, key, value);
			ini.store(SETUP_FILE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Ini getIniReader() {
		SetupUtil setupUtil = new SetupUtil();
		Ini ini = new Ini();

		try {
			if (SETUP_FILE == null) {
				SETUP_FILE = new File(setupUtil.getClass().getClassLoader().getResource(SETUP_FILE_PATH).getFile());
			}
			ini.load(new FileReader(SETUP_FILE));
			return ini;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		try {
			String url = "https://adtkm1amr1.accenture.com/sites/br_TViomp/_vti_bin/ListData.svc/SDSDeltasControlList$filter=Phase eq '2.1.2'&$top=1&$orderby=Modified desc";
			URI uri = new URI(url);
			System.out.println(uri.getHost());
			System.out.println(uri.getPort());
			System.out.println(uri.getQuery());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
