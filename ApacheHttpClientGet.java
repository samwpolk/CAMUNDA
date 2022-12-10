package com.polk.java;

/**
* Sam Polk 
* 12/8/2020
* CAMUNDA assignment for Technical Support Engineer
* 
* Most the work is done here
* We execute a HTTP GET and store the HTTP response in JSONArray
* We use the JSONArry to build a JSONObect
* We then build a UserDTO List via the Gson.fromJson() method  using JASONObject and UserDTO class
* We used Apache HttpComponents to make the HTTP request and Google's Gson Java library to  to serialize Java objects to JSON and vice versa.
* 
* The output is very simple, a list of names from the HTTP GET response and we print the first name of the first record in the list
* 
* Written in:
* Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
* Version: 2022-09 (4.25.0)
* Build id: 20220908-1902
* 
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;


public class ApacheHttpClientGet {
	
	
	public UserDTO getRequest(String URL){
		
       String resOut; // String holding HTTP GET response from the buffer reader
       
	   Gson gson = new Gson(); //Google Gson is a simple Java-based library to serialize Java objects to JSON and vice versa
	   
	   JSONObject jObject = null; //JSONObject use to convert the HTTP response string to a List
	   
	   List<JSONObject> userList = new ArrayList<JSONObject>(); //JSONObject list
	  
	   UserDTO data = new UserDTO(); //UserDTO Object
	   
	   final String id ="id";
	   
	   final String email = "email";
	   
	   final String lname = "last_name";
	   
	   final String fname = "first_name";
	   
	   final String avatar = "avatar";
	   

	   
		try {

		    	HttpClient httpClient =  HttpClientBuilder.create().build();
	
			
		    	HttpGet getRequest = new HttpGet(URL);
		    	getRequest.addHeader("accept", "application/json");

		    	HttpResponse response = httpClient.execute(getRequest);
		  

		    	if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
				
			}
			 

			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
			

		    while ((resOut = br.readLine()) != null) {
	
		    	int pos = resOut.indexOf("data") + 6;
		    	
		    	String string  = resOut.substring(pos);
		    	
		    	
		    	JSONArray jArray = new JSONArray(string);
		    	
		    	jObject = jArray.getJSONObject(0);
		    		
		    	for(int i=0; i < jArray.length(); i++) {  
		            
		    	 	try { 
		    	   
		    	 			userList.add(jArray.getJSONObject(i));
		    	        
		    	        
		    	 		 } catch (JSONException e) {
		    		
		    	 			  System.out.println(e.getMessage());
		    	 		}
		    
		    	
		    	}
		    	
		    
		    	
		    
		        data = gson.fromJson(jObject.toString(), UserDTO.class);
		       
		        for ( int i = 0; i < userList.size(); i++) {
		        	
		         
		         System.out.println("Name " + userList.get(i).getString(fname) + " " + userList.get(i).getString(lname));
		  
		   
		         }
			}
	

			 
		  } catch (ClientProtocolException e) {
		
			  e.printStackTrace();

		  } catch (IOException e) {
		
			e.printStackTrace();
		  }

		return  data;

	}
	
	
	}

	


