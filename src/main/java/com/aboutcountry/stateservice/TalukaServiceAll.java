package com.aboutcountry.stateservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aboutcountry.statemodel.Taluka;

@Service
public class TalukaServiceAll {
	
	List list = new ArrayList();
	
	public List<Taluka> getListOfTaluka()
	{
		Taluka ts =null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Taluka "); 
			while(rs.next())
			{
				ts= new Taluka();
				ts.setTid(rs.getString("tid"));
				ts.setTname(rs.getString("tname"));
				list.add(ts);
			
			}
			
		}
		catch(Exception e)
		{
			
		}
		return list;
	}

}
