package com.example.Login;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
//import com.google.gson.Gson.Gson;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginController.class);
	//MemCacheUtils mem = new MemCacheUtils();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("going");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//LoginBean bean=new LoginBean();
		//bean.setName(name);
		//bean.setPassword(password);
		//request.setAttribute("bean",bean);
		Boolean status = false;
		//URL url = new URL("http://localhost:8080/RestClient/index.jsp");
		//HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//conn.setRequestMethod("POST");
		//conn.connect();
		String passwordFromCache ="";
		//String contentType = conn.getContentEncoding();
		
		try
		{
			
				
			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RestService/loginservices/checkuservalidity");
			MultivaluedMap formData = new MultivaluedMapImpl();
			formData.add("username", name);
			formData.add("password", password);
			ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formData);
			System.out.println("call first mmethod");
			System.out.println(response.getCharacterEncoding());
			//System.out.println(contentType);
			if(restResponse.getStatus()!=200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
			
			String statusString = restResponse.getEntity(String.class);
			status = Boolean.parseBoolean(statusString);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(status)
		{
			
			
			//check for password
			HttpSession session = request.getSession();
			session.setAttribute("USER", name);
			
			//get all images of admin
			try
			{
				Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/RestService/getHomeService/getHome");
				//MultivaluedMap formData = new MultivaluedMapImpl();
				//formData.add("username", name);
				//formData.add("password", password);
				ClientResponse restResponse = webResource
				    .type(MediaType.APPLICATION_JSON)
				    .accept(MediaType.APPLICATION_JSON)
				    .post(ClientResponse.class);
				String json=restResponse.getEntity(String.class);
				System.out.println(json+"in servlet");
				if(restResponse.getStatus()!=200)
				{
					throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
				}
				//File[] list=webResource.accept("application/json").type("application/json").post(new GenericType<File[]>(){});
				//String statusString = restResponse.getEntity(String.class);
				//status = Boolean.parseBoolean(statusString);
				//JsonParser parser = new JsonParser();
				Gson gs= new Gson();
				ObjectMapper mapper = new ObjectMapper();
				ArrayList<HashMap<String,String>> lans = mapper.readValue(json, new TypeReference<ArrayList<HashMap<String,String>>>(){});
				if(restResponse.getStatus()==200)
				{
					RequestDispatcher rd=request.getRequestDispatcher("welcome_page.jsp");
					
					request.setAttribute("listans", lans);
					if(name.equals("admin")) {
						System.out.println("admin page");
						rd=request.getRequestDispatcher("AdminHome.jsp");
							
					}
					if(logger.isDebugEnabled()){
						logger.debug("This is debug : ");
					}
					rd.forward(request, response);
				}
				else
				{
					System.out.println("exception");
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
			
	}

}
