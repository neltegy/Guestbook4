package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<GuestBookVo> getlist(){
		
		List<GuestBookVo> list = sqlsession.selectList("guestbook.getlist"); //두번째 인자는 어떤 값을 전달해야할때
		return list;
	}
	
	public void delete(GuestBookVo guestBookVo){
		
		sqlsession.delete("guestbook.delete",guestBookVo); //두번째 인자는 어떤 값을 전달해야할때
		
	}
	
}
