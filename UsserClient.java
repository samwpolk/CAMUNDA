package com.polk.java;


/**
 * Sam Polk 
 * 12/8/2020
 * CAMUNDA assignment for Technical Support Engineer
 * 
 * Java application that act like a small REST client to grab user data from the reqres.in REST API
 * We used 
 * 
 */



public class UsserClient {

	public static void main(String[] args) {
		
		ApacheHttpClientGet userClient = new ApacheHttpClientGet();
		UserDTO  udto = new UserDTO();
		
		 udto = userClient.getRequest("https://reqres.in/api/users?page=1");
		 System.out.println(udto.getFirst_name() + "\n");
		 

		 udto = userClient.getRequest("https://reqres.in/api/users?page=2");
		 System.out.println(udto.getFirst_name());
		 
		
		
	
		
		 
		}

}
