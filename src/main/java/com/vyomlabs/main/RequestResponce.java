package com.vyomlabs.main;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vyomlabs.auto.Tickets;
import com.vyomlabs.bussiness.API_AI_Responce;
import com.vyomlabs.model.Json_Model;
import com.vyomlabs.model.Parameters;
import com.vyomlabs.model.Result;

@Path("ticket")
public class RequestResponce {
	String userName="";
	String pass="";
	String type="";
	String to="";
	String services="";
	String sla="";
	String subject="";
	String text="";
	
	@GET
	public Response GetMsg() throws IOException{
		return Response.status(200).entity("Welcome User ").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response odRequest(String outputJSON) throws IOException, InterruptedException
	{
		String result="";
		Json_Model apiAiResponse=null;
		API_AI_Responce response=null;
		Result rs=null;
		Parameters params=null;
		Tickets ticket=new Tickets();
		try{
		System.out.println("Request recieved");
		 response = new API_AI_Responce();
		System.out.println("responceBO : "+response.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
		 apiAiResponse = response.jsonToJava(outputJSON);
		System.out.println("apiAiResponse : " +apiAiResponse);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
		 rs=apiAiResponse.getResult();
		System.out.println("rs :"+rs.toString());
		
		}catch(Exception e){e.printStackTrace();
		}
		try{
		 params=rs.getParameters();
		userName=params.getUsername();
		pass=params.getPassword();
		type=params.getType();
		to=params.getTo();
		services=params.getService();
		sla=params.getSla();
		subject=params.getSubject();
		text=params.getText();
		result=ticket.apply(userName, pass, type, to,services,sla,subject,text);
		}
		catch(Exception e){
			e.printStackTrace();
		}
			

		return Response.status(200).entity(result).build();
	}

}
