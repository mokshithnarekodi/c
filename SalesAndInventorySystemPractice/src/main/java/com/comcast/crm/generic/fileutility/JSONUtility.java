package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJSONFile(String key) throws Throwable, ParseException {
		FileReader filR=new FileReader("./configAppdata/appcommondata.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(filR);
		JSONObject map=(JSONObject)obj;
		String data = (String) map.get(key);
		return data;
	}

}
