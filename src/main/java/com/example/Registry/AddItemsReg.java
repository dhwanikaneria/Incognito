package com.example.Registry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class AddItemsReg
 */
@WebServlet("/AddItemsRegController")
public class AddItemsReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemsReg() {
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
		HttpSession session = request.getSession();
		String username=(String)session.getAttribute("USER");
		String[] friends=request.getParameterValues("friends");
		String reg_name=request.getParameter("RegName");
		//ArrayList<String>
		String arraytostring=Arrays.toString(friends);
	
		////System.out.println(arraytostring);
		ArrayList<String> pass= new ArrayList<String>();
		pass.add(username);
		pass.add(reg_name);
		pass.add(arraytostring);
		String json1=new Gson().toJson(pass);
		try
		{
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RestService/CreateUserRegService/CreateUserReg");
			//MultivaluedMap formData = new MultivaluedMapImpl();
			//formData.add("username", name);
			//formData.add("password", password);
			ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON)
			    .post(ClientResponse.class,json1);
			String json=restResponse.getEntity(String.class);
			//System.out.println(json+"in servlet");
			Gson gs= new Gson();
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<String> lans = mapper.readValue(json, new TypeReference<ArrayList<String>>(){});
			//ObjectMapper mapper = new ObjectMapper();
			ArrayList<HashMap<String,String>> first = mapper.readValue(lans.get(0), new TypeReference<ArrayList<HashMap<String,String>>>(){});
			ArrayList<HashMap<String,String>> second = mapper.readValue(lans.get(1), new TypeReference<ArrayList<HashMap<String,String>>>(){});
			HashMap<String,String> hm4=first.get(0);
			int reg_id=Integer.parseInt(hm4.get("reg_id"));
			if(restResponse.getStatus()==200)
			{
				
				request.setAttribute("reg_id", reg_id);
				//request.setAttribute(arg0, arg1);
				HttpSession sess=request.getSession();
				sess.setAttribute("Reg_id", reg_id);
				request.setAttribute("Product_details", second);
				RequestDispatcher rd=request.getRequestDispatcher("AddParticularItem.jsp");
				rd.forward(request, response);
			}
			else
			{
				//System.out.println("exception");
			}

		}
		catch(Exception e)
		{
			//System.out.println(e);
		}


		

	}

}
