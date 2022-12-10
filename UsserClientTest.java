package com.polk.java;

/**
* Sam Polk 
* 12/8/2020
* CAMUNDA assignment for Technical Support Engineer
* 
* Tiny JUnit test to see if the first name in the list is correct 
*/


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsserClientTest {
	
	ApacheHttpClientGet  userTestClient;

	@Before
	public void setUp() throws Exception {
		
		 userTestClient = new ApacheHttpClientGet();
	}

	@Test
	public void testMain() {
		
			
			//String str  = "UserDTO [id=1, email=george.bluth@reqres.in, first_name=George, last_name=Bluth, avatar=https://reqres.in/img/faces/1-image.jpg]";
			
		    UserDTO  udto = new UserDTO();
		    
			
		    String url1 = "https://reqres.in/api/users?page=1";
			
			String url2 = "https://reqres.in/api/users?page=2";
			
			udto = userTestClient.getRequest(url2);
			
			assertEquals(6, udto.getId() - 1);
			
			System.out.println();
			
			assertEquals("George",userTestClient.getRequest(url1).getFirst_name()); 
			
			System.out.println();
			
			assertEquals("Michael",userTestClient.getRequest(url2).getFirst_name()); 
			
			
			
			//System.out.println();
			
			//assertEquals(str,userTestClient.getRequest(url1));
			
		

		
	}
		
		
			
			
}
	
	
