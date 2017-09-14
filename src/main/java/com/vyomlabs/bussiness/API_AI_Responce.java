package com.vyomlabs.bussiness;

import org.codehaus.jackson.map.ObjectMapper;
import com.vyomlabs.model.Json_Model;

public class API_AI_Responce {
	public Json_Model jsonToJava(String json) {
		Json_Model apiAiResponse = null;
		try {
			System.out.println(json);
			ObjectMapper mapper= new ObjectMapper();
			apiAiResponse = mapper.readValue(json, Json_Model.class);
			System.out.println(apiAiResponse);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiAiResponse;
	}

}
