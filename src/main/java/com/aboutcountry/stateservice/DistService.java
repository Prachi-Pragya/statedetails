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
public class DistService {
	
	List list = new ArrayList();
	
	
	public List<Dist> getDist(String sid)
	{
		Dist ds =null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root"); 
			
			Statement stmt=con.createStatement(); 
			
			
			ResultSet rs=stmt.executeQuery
					("select Dist.dname, State.sname ,Dist.did from Dist\r\n" + 
					"join\r\n" + 
					"state on\r\n" + 
					"state.sid=Dist.sid\r\n" + 
					"And state.sid="+sid+""); 
			
			while(rs.next())
			{
				ds= new Dist();
				
				ds.setDid(rs.getString("did"));
				//ds.setSid(rs.getInt("sid"));
				//ds.setSname(rs.getString("sname"));
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
