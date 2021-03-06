package com.example.fetchProfile;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/fetch")
public class FetchProfile 
{
	@Path("/fetchprofile")
	@POST
	public Response fetchprofile(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		boolean status=false;
		boolean status1=false;
		String json=null;
		try
		{		
			//redirecting to microservice
			Client client = Client.create();
			System.out.println(formParam.getFirst("name")+"service");
			WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/fetchprofile/fetchprofile");
			/*.*/ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formParam);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			json=restResponse.getEntity(String.class);
			//	System.out.println("Here");
				return Response.ok().entity(json).build();
		}
		catch(Exception e)
		{
			System.out.println(e+" "+"Connection error");						
			//response=true;
		}
		System.out.println(response+"webservice");
		return Response.ok().entity(String.valueOf(status)).build();
	}
	

	@Path("/updateprofile")
	@POST
	public Response updateprofile(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		boolean status=false;
		boolean status1=false;
		String json=null;
		try
		{		
			//redirecting to microservice
			Client client = Client.create();
			System.out.println(formParam.getFirst("name")+"service");
			WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/fetchprofile/updateprofile");
			/*.*/ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formParam);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			json=restResponse.getEntity(String.class);
			//	System.out.println("Here");
				return Response.ok().entity(json).build();
		}
		catch(Exception e)
		{
			System.out.println(e+" "+"Connection error");						
			//response=true;
		}
		System.out.println(response+"webservice");
		return Response.ok().entity(String.valueOf(status)).build();
	}
	
	
	@Path("/fetchfriends")
	@POST
	public Response FetchFriends(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		boolean status=false;
		boolean status1=false;
		String json=null;
		try
		{		
			//redirecting to microservice
			Client client = Client.create();
			System.out.println(formParam.getFirst("name")+"service");
			WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/fetchprofile/fetchfriends");
			/*.*/ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formParam);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			json=restResponse.getEntity(String.class);
			System.out.println(json +"webservice");
			//	System.out.println("Here");
				return Response.ok().entity(json).build();
		}
		catch(Exception e)
		{
			System.out.println(e+" "+"Connection error");						
			//response=true;
		}
		System.out.println(response+"webservice");
		return Response.ok().entity(String.valueOf(status)).build();
	}

	@Path("/checkuseranswer")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	public Response isValidanswer(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		boolean status=false;
		boolean status1=false;
		try
		{		
			//redirecting to microservice
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/fetchprofile/checkuseranswer");
			/*.*/ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formParam);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			String statusString = restResponse.getEntity(String.class);
			System.out.println(statusString+"service");
			status = Boolean.parseBoolean(statusString);
		}
		catch(Exception e)
		{
			System.out.println(e+" "+"Connection error");						
			//response=true;
		}
		/*if(status)
		{
		}
		else {}*/
		/*
			//System.out.println("the username exists in loginwebservice");
			//checkng for password
			try
			{		
				//redirecting to microservice
				Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/userpassmicroservice/checkpassword");
				MultivaluedMap formData = new MultivaluedMapImpl();	
				formData.add("username", formParam.getFirst("username"));
				formData.add("password", formParam.getFirst("password"));
				ClientResponse restResponse = webResource
				    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				    .post(ClientResponse.class, formData);
				if(restResponse.getStatus()!=200)
				{
					throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
				}
				
				String statusString1 = restResponse.getEntity(String.class);
				status1 = Boolean.parseBoolean(statusString1);
			}
			catch(Exception e)
			{
				System.out.println(e+" "+"Connection error");						
				//response=true;
			}
			if(status1)
			{
				response=true;
				System.out.println("The password is true");
			}			
			else
				response=false;
		}
		else
		{
			System.out.println("The user name doesn't exist");
			response=false;
		}
		if(formParam.getFirst("password").equals("admin")){
			response = true;
		}
		else{
			response = false;
		}
*/		System.out.println(response+"webservice");
		return Response.ok().entity(String.valueOf(status)).build();
	}

	@Path("/setpassword")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	public Response setPassword(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		boolean status=false;
		boolean status1=false;
		try
		{		
			//redirecting to microservice
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/fetchprofile/setpassword");
			/*.*/ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formParam);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			String statusString = restResponse.getEntity(String.class);
			System.out.println(statusString+"service");
			status = Boolean.parseBoolean(statusString);
		}
		catch(Exception e)
		{
			System.out.println(e+" "+"Connection error");						
			//response=true;
		}
		/*if(status)
		{
		}
		else {}*/
		/*
			//System.out.println("the username exists in loginwebservice");
			//checkng for password
			try
			{		
				//redirecting to microservice
				Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/RestMicroServices/userpassmicroservice/checkpassword");
				MultivaluedMap formData = new MultivaluedMapImpl();	
				formData.add("username", formParam.getFirst("username"));
				formData.add("password", formParam.getFirst("password"));
				ClientResponse restResponse = webResource
				    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				    .post(ClientResponse.class, formData);
				if(restResponse.getStatus()!=200)
				{
					throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
				}
				
				String statusString1 = restResponse.getEntity(String.class);
				status1 = Boolean.parseBoolean(statusString1);
			}
			catch(Exception e)
			{
				System.out.println(e+" "+"Connection error");						
				//response=true;
			}
			if(status1)
			{
				response=true;
				System.out.println("The password is true");
			}			
			else
				response=false;
		}
		else
		{
			System.out.println("The user name doesn't exist");
			response=false;
		}
		if(formParam.getFirst("password").equals("admin")){
			response = true;
		}
		else{
			response = false;
		}
*/		System.out.println(response+"webservice");
		return Response.ok().entity(String.valueOf(status)).build();
	}
	
	
	
	
}
