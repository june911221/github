

import java.util.ArrayList;


public class Students {

public ArrayList<StudentBean> input(){
	
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	
	StudentBean[] s= new StudentBean[5];
	s[0]= new StudentBean();
	s[1]= new StudentBean();
	s[2]= new StudentBean();
	s[3]= new StudentBean();
	s[4]= new StudentBean();
	
	
	s[0].setId("gabriel");
	s[0].setName("ddd");
	s[0].setSnum("123");
	s[0].setYear(2010);
	s[0].setPass("pass");
	s[0].setEmail("gabrieljune@naver.com");
	

	s[1].setId("gabriel");
	s[1].setName("fff");
	s[1].setSnum("223");
	s[1].setYear(1998);
	s[1].setPass("pass");
	s[1].setEmail("gabrieljune@naver.com");

	
	s[2].setId("gabriel");
	s[2].setName("aaa");
	s[2].setSnum("698");
	s[2].setYear(2011);
	s[2].setPass("unpass");
	s[2].setEmail("ghdwnsdud@gmail.com");

	
	s[3].setId("gabriel");
	s[3].setName("www");
	s[3].setSnum("698");
	s[3].setYear(1992);
	s[3].setPass("pass");
	s[3].setEmail("ghdwnsdud@gmail.com");
	
	
	s[4].setId("gabriel");
	s[4].setName("dddf");
	s[4].setSnum("223");
	s[4].setYear(2005);
	s[4].setPass("unpass");
	s[4].setEmail("gabrieljune@naver.com");
	
	list.add(s[0]);
	list.add(s[1]);
	list.add(s[2]);
	list.add(s[3]);
	list.add(s[4]);
	
	return list;
	
	}
}