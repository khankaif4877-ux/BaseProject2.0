package com.ProjectName.generic.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtil {
	private static final String DefaultPath = "\\Users\\KAIF KHAN\\Desktop\\TestData\\appCommmData.json";

	public String getDataFromJson(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(DefaultPath));
		JSONObject jObject= (JSONObject)object;
		String value = jObject.get(key).toString();
		return value;
		
	}
	
	
}
