package com.ProjectName.generic.FileUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	private static final  String DefaultPath = "\\Users\\KAIF KHAN\\Desktop\\TestData\\CommonData.properties";

	
	
	

	public String getProperty(String key)  {
		String value = null;
	try {
		FileInputStream fIS = new FileInputStream(DefaultPath);
	       Properties prop = new Properties();
	       prop.load(fIS);
	       value = prop.getProperty(key);
	       fIS.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
       return value;
	}

	
	
	

	public void setProperty(String key,String value) {
	try {
		FileInputStream fIS = new FileInputStream(DefaultPath);
	       Properties prop = new Properties();
	       prop.load(fIS);
	       prop.setProperty(key, value);
	       FileOutputStream fos = new FileOutputStream(DefaultPath);
	       prop.store(fos, "Updated by PropertyFileUtil");
	       fos.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	       
	}
	




}
