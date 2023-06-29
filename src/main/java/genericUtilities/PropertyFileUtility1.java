package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility1 {
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
	//FileInputStream fis = new FileInputStream();
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
	
	// create object of properties file
	Properties prop = new Properties();
	
	// load properties file
	prop.load(fis);
	
	// fetch the properties from file
	String value=prop.getProperty(key);
	return value;
	}

}
