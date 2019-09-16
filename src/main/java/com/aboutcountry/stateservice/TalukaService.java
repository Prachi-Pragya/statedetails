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
public class TalukaService {

	List list = new ArrayList();
	Taluka tl = null;

	public List<Taluka> getTaluka(String did)

	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery ("select Taluka.tname,Taluka.tid, Dist.dname, Dist.did from Taluka\r\n" + 
					"join \r\n" + 
					"Dist on\r\n" + 
					"Dist.did=Taluka.did \r\n" + 
					"And Dist.did= 1 ");
				/*	("select Taluka.tname, Dist.dname, Dist.did from Taluka\r\n" + "join \r\n" +
					  "Dist on\r\n" + "Dist.did=Taluka.did \r\n" + "And Dist.did=1 ");*/
			
			 
			 while (rs.next()) {
				tl = new Taluka();

				tl.setTid(rs.getString("tid"));
				// tl.setDid(rs.getInt("did"));
				tl.setTname(rs.getString("tname"));
				list.add(tl);
			}
			 con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
