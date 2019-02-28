package com.microservice.AddFriend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/GetfriendsMicro")
public class MicroGetFriends 
{
	@Path("/GetFriends")
	@POST
	//@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getFriends(String user)
	{
		String json=null;
		ArrayList<String> values= new ArrayList<String>();
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/giftregistry";
			String username = "root";
			String password1 = "root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password1);
			//response=true;			
			System.out.println("connection established");
			Statement st=conn.createStatement();
			String sql="SELECT * FROM giftregistry.sharedregistry where name='"+user+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				values.add(rs.getString("friends"));
			}
			json= new Gson().toJson(values);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return Response.ok(json).build();
	}

}
