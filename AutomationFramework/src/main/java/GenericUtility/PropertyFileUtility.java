package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of method to read data from property file
 */
public class PropertyFileUtility {
	/**
	 * This method used to read data from property file provided key
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commanData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Value = prop.getProperty(Key);	
		return Value;
	}

}
