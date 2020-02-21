package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionUpdate {
	static ActionUpdate model = new ActionUpdate();
	public static ActionUpdate instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ï¿½ë™†ï¿½ì”ªï¿½ì“£ ï§¡ì– ë¸˜ï¿½?ƒ‚
	
	public void Update(BoardDto list) {
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.update("updateDB",list);
	//mapper.xml ¿¡¼­ updateDB ¸¦ id·Î»ç¿ëÇÏ´Â update ±¸¹®¿¡ º¯¼ö¸¦ º¸³»ÁÖ¸é¼­ È£Ãâ("id",º¯¼ö) 
	
	sqlSession.commit();
	sqlSession.close();
	
	}
}
