package com.vyomlabs.bussiness;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;*/

public class CheckCredential 
{
	static Connection con;
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","automationedge","pune@123");

		}catch(Exception e){e.printStackTrace();}
	}
	public String Check(String imp_Id,String pass)throws IOException
	{
		System.out.println(imp_Id+" "+pass);
		String result=""; 
		boolean ef=false,pf=false;
		String qe="select *from logindata where Emp_Id=?";
		String qp="select *from logindata where password=?";
		try{
			
			System.out.println("Connected");
			PreparedStatement ps=con.prepareStatement(qe);
			ps.setString(1, imp_Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			ef=true;
			}
			PreparedStatement ps1=con.prepareStatement(qp);
			ps1.setString(1, pass);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()){
				System.out.println("password query="+ps.toString());
				pf=true;
				
				}
			if(ef==false){
				result="Sorry...!! You Entered wrong Employee_Id";

			}else if(pf==false){
				result="Sorry...!! You Entered wrong Password";
			}else
			{
				result="";
			}
			
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
				
		
			return result;
	}

}
