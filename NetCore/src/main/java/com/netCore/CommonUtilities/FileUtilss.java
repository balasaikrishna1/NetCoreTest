package com.netCore.CommonUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author BALA SAI KRISHNA
 *
 */

public class FileUtilss {
	/**
	 * used to get data from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream("./testData/CommonData.properties");
		 Properties pObj = new Properties();
		 pObj.load(fis);
		 String value = pObj.getProperty(key);
	
	return value;
}
}
