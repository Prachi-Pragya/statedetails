package com.aboutcountry.stateservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aboutcountry.statemodel.State;
import java.util.*;

@Service
public class StateService {
	
	List list = new ArrayList();
	public List<State> getState()
	{
		 State st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
		 
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from State "); 
		while(rs.next())
		{
		  st = new State();	
		  st.setSid(rs.getInt("sid"));
		  st.setSname(rs.getString("sname"));
		  list.add(st);
		 
		} 
		con.close(); 
	}
	catch(Exception e)
	{
		{ 
			System.out.println(e);
		} 
	}
	return list ;

}
}
