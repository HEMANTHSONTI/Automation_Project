package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	public static Properties getPropertyObject() throws IOException
	{
		FileInputStream fi = new FileInputStream("C:\\Users\\heman\\seleniumwork\\shareon_Cucumber\\configs\\Configuration.properties");
		Properties prop = new Properties();
		prop.load(fi);
		return prop;
	}
	
	public static String getsubscription_mail() throws IOException
	{
		return getPropertyObject().getProperty("subscription_mail");
		
	}
	
	public static String getemail() throws IOException
	{
		return getPropertyObject().getProperty("email");
	}
	
	public static String getpassword() throws IOException
	{
		return getPropertyObject().getProperty("password");
	}

}
