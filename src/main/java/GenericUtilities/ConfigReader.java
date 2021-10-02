package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	public Properties read_Prop() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/vipan/eclipse-workspace/cucumberPracticeFreeCRMProject2021/src/test/"
					+ "resources/configProperties/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
