package com.ProjectName.generic.FileUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	private static final  String DefaultPath = "\\Users\\KAIF KHAN\\Desktop\\TestData\\CommonData.properties";

	
	
	

	public String getProperty(String key) throws IOException {
		FileInputStream fIS = new FileInputStream(DefaultPath);
       Properties prop = new Properties();
       prop.load(fIS);
       String value = prop.getProperty(key);
       fIS.close();
       return value;
	}

	
	
	

	public void setProperty(String key,String value) throws IOException {
		FileInputStream fIS = new FileInputStream(DefaultPath);
	       Properties prop = new Properties();
	       prop.load(fIS);
	       prop.setProperty(key, value);
	       FileOutputStream fos = new FileOutputStream(DefaultPath);
	       prop.store(fos, "Updated by PropertyFileUtil");
	       fos.close();
	       
	}
	




}
