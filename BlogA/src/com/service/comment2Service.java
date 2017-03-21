package com.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.dao.comment2Dao;
import com.entity.comment2;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.tool.DBAccess;

public class comment2Service {
	comment2Dao comment2Dao;
	SqlSession sqlSession;
	public comment2Service() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		comment2Dao = sqlSession.getMapper(comment2Dao.class);
	}
	
	public List<comment2> selectById(int commentId) {
		List<comment2> comment2s = comment2Dao.comment2Select(commentId);
		return comment2s;
	}
}
