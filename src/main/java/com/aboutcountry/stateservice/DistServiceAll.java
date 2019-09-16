package com.aboutcountry.stateservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aboutcountry.statemodel.Dist;

@Service
public class DistServiceAll {
	
	List list = new ArrayList();
	
	public List<Dist> getListOfDisk()
	{
		Dist ds = null;
		try
		{		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
		 
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Dist "); 
		while(rs.next())
		{
			ds= new Dist();
			ds.setDid(rs.getString("did"));
			ds.setDname(rs.getString("dname"));
			list.add(ds);
		}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	

}
