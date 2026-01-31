package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static Properties getProperties() {
		if (prop == null) {
			try {
				FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
				prop = new Properties();
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public static String get(String key) {
		String value = System.getProperty(key);
		if (value != null) {
			return value;
		}
		return getProperties().getProperty(key);
	}
}