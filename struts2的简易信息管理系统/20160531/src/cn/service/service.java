package cn.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.model.Student;
import java.lang.*;


public class service {
	private Connection conn;
	private PreparedStatement pstmt;
	public service() throws SQLException{
		conn=new cn.conn.conn().getConnection();//调用conn方法建立连接
		}
	public boolean vailUser(Student user){
		try{
		pstmt=conn.prepareStatement("select*from Student where username=? and password=?");
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		}
	public List queryAllpro()
	{   List pros=new ArrayList();
		try{
			pstmt=conn.prepareStatement("select * from Student");
		    ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		    	Student pro=new Student();
		    	pro.setUsername(rs.getString(1));
		    	pro.setPassword(rs.getString(2));
		    	pros.add(pro);
		    	
		    }return pros;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}	
	public boolean addProduct(Student pro){
		try{pstmt=conn.prepareStatement("insert into Student"
				+"(username,password)"
				+"values(?,?)");
		pstmt.setString(1, pro.getUsername());
		pstmt.setString(2, pro.getPassword());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(Student pro){
		try{
			pstmt=conn.prepareStatement("update product set productnum=?,productfare=? where productname=?");
			pstmt.setString(1, pro.getUsername());
			pstmt.setString(2, pro.getPassword());
			pstmt.executeUpdate();
				return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}public Boolean delete(String username){
		try{
			pstmt=conn.prepareStatement("delete from student where username=?");
			pstmt.setString(1,username);
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public Student querybyname(String username)
	{   //List stus=new ArrayList();
		try{
			pstmt=conn.prepareStatement("select * from student where username=?");
		   pstmt.setString(1,username);
			ResultSet rs=pstmt.executeQuery();
		    if(rs.next())
		    {
		    	Student pro=new Student();
		    	pro.setUsername(rs.getString(1));
		    	pro.setPassword(rs.getString(2));
	            return pro;
		    }return null;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}