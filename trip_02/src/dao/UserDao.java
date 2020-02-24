package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import vo.UserDto;

public class UserDao {
	Connection conn=null; 
	Statement stmt=null;

	public UserDao(){
	try{//占쏙옙占쏙옙占쌘뤄옙 占쏙옙占쏙옙譴占� 호占쏙옙
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
	}
}
	
	public Connection Drive(){
	try{//DB占쏙옙占쏙옙
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8","root","911221");
	}catch(Exception e){
		
	}
	return conn;
}
	
	public void close() {//DB占쌥댐옙 占쌉쇽옙
		try{
		
			
			stmt.close();
			
		}catch(Exception e) {
			
		}try{
			
			conn.close();
			
		}catch(Exception e) {
			
		}
			
	}
	
	public void Signup(String name,String id,String password,String email,String phone,String birth,String postcode,String addr1,String addr2){//DB占쏙옙 회占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌉뤄옙
	try {
		conn=Drive();
		stmt = conn.createStatement();
		String command = "insert into user values('"+id+"','"+name+"','"+password+"','"+email+"','"+phone+"','"+birth+"','"+postcode+"','"+addr1+"','"+addr2+"');";
		//System.out.print(command);
		int rowNum = stmt.executeUpdate(command);
		if(rowNum<1)
		throw new Exception("占쏙옙占쏙옙占싶몌옙 DB占쏙옙 占쌉뤄옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙."); 
		
		stmt.close();
} catch (Exception e) {
	System.out.println(e);
}
	
close();
}

public void UserDelete(String id) {//회占쏙옙탈占쏙옙
	try {
		conn=Drive();
		stmt = conn.createStatement();
		String command = "delete from user where id='"+id+"';";
		//System.out.println(command);
		int rowNum = stmt.executeUpdate(command);
		if(rowNum<1) 
		throw new Exception("占쏙옙占쏙옙占싶몌옙 DB占쏙옙 占쌉뤄옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙."); 
		
		stmt.close();
} catch (Exception e) {
	System.out.println(e);
}
	
close();
}

public int Login(String id,String password) {//占싸깍옙占쏙옙
	int s = 0;
	try{
		conn=Drive();
		stmt=conn.createStatement();
		String command = "select * from user where id='"+id+"';";
		ResultSet rs=stmt.executeQuery(command);
		//System.out.println(command);
		if(rs.next()){
			String ID = rs.getString("id");
			String PW = rs.getString("password");

			if(ID.equals(id)&&PW.equals(password)){
			s=3;//ID占쏙옙 PW占쏙옙 占쏙옙치占싹몌옙 3占쏙옙 占쏙옙占쏙옙
		    }

			else{
			 s=2;//ID占쏙옙 占쏙옙치占싹곤옙 PW占쏙옙 占쌕몌옙占쏙옙1占쏙옙 占쏙옙占쏙옙
			}
}
		else {
			s=1;//ID占쏙옙 占쏙옙占쏙옙占쏙옙占� 2占쏙옙 占쏙옙占쏙옙
		}

		stmt.close();
} catch (Exception e) {
	System.out.println(e);
}
	//System.out.println(s);
	return s;
}


public int ConfirmID(String id) {//ID 占쌩븝옙 체크
	int s = 0;
	try{
		conn=Drive();
		stmt=conn.createStatement();
		String command = "select * from user where id ='" + id +"';";
		ResultSet rs=stmt.executeQuery(command);
		//System.out.println(command);
		if(rs.next()){   
			  s=1;	//id占쏙옙占쏙옙占쏙옙占쏙옙 1占쏙옙 占쏙옙환	  
		  }else{
			  s=0; //id占쏙옙占쏙옙占쏙옙占쏙옙 0占쏙옙占쏙옙환
		  }
		stmt.close();
} catch (Exception e) {
	System.out.println(e);
}
	return s;
}


public int ConfirmMail(String email) {//占싱몌옙占쏙옙 占쌩븝옙 체크
	int s = 0;
	try{
		conn=Drive();
		stmt=conn.createStatement();
		String command = "select * from user where email ='" + email +"';";
		ResultSet rs=stmt.executeQuery(command);
		//System.out.println(command);
		if(rs.next()){   
			  s=1;	//email占쏙옙占쏙옙占쏙옙 1占쏙옙占쏙옙占쏙옙환  
		  }else{
			  s=0; //email占쏙옙占쏙옙占쏙옙占쏙옙 0占쏙옙占쏙옙환
		  }
		stmt.close();
} catch (Exception e) {
	System.out.println(e);
}
	//System.out.println(s);
	return s;
}


public String FindID(String name,String email) {//ID찾占쏙옙
	String str=null;
	try{
	conn=Drive();
	stmt=conn.createStatement();
	String command = "select * from user where name='"+name+"' and email='"+email+"';";
	ResultSet rs=stmt.executeQuery(command);
	//System.out.println(command);
	if(rs.next()){
		str = rs.getString("id");		
	}
	else{
	    str = "0";
	}

	stmt.close();
} catch (Exception e) {
System.out.println(e);
}
//System.out.println(str);
return str;
}


public ArrayList<UserDto> UserList(String id) {//ID占쏙옙 占쏙옙치占싹댐옙회占쏙옙 占쏙옙占쏙옙 占쏙옙占�
	ArrayList<UserDto> UserList=new ArrayList<UserDto>(); 
	try{
		conn=Drive();
	stmt=conn.createStatement();//占쌉실깍옙 占쏙옙체占쏙옙占쏙옙占쏙옙占� order by number desc 占쌉시뱄옙占쏙옙호占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	String command = "select * from user where id='"+id+"';";
	ResultSet rs=stmt.executeQuery(command);
	while(rs.next()) {	
		
		UserDto dto=new UserDto();
		dto.setName(rs.getString("name"));
		dto.setId(rs.getString("id"));
		dto.setEmail(rs.getString("email"));
		dto.setPhone(rs.getString("phone"));
		dto.setBirth(rs.getDate("birth"));
		dto.setPostcode(rs.getString("postcode"));
		dto.setAddr1(rs.getString("addr1"));
		dto.setAddr2(rs.getString("addr2"));
		
		UserList.add(dto);
	}
	stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	close();
	return UserList;
}

public int Userupdate(String id,String pw,String email,String phone,String post,String addr1,String addr2) {//회占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	int rowNum=0;
	try{
		conn=Drive();
		stmt=conn.createStatement();
		String command=null;
		if(pw==null||pw=="") {
		command = "update user set email='"+email+"',phone='"+phone+"',postcode='"+post+"',addr1='"+addr1+"',addr2='"+addr2+"' where id='"+id+"';";
		}else {
		command = "update user set password='"+pw+"',email='"+email+"',phone='"+phone+"',postcode='"+post+"',addr1='"+addr1+"',addr2='"+addr2+"' where id='"+id+"';";
		}
		//System.out.println(command);
		rowNum = stmt.executeUpdate(command);
		if(rowNum<1)
		throw new Exception("占쏙옙占쏙옙占싶몌옙 DB占쏙옙 占쌉뤄옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙."); 
		
		stmt.close();
	}
	catch (Exception e) {
	System.out.println(e);
    }
	close();
	return rowNum;
    }
}
