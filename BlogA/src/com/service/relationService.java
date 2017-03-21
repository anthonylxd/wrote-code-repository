package com.service;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.dao.relationDao;
import com.entity.relation;

public class relationService {
	relationDao relationDao;
	SqlSession sqlSession;
	public relationService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		relationDao = sqlSession.getMapper(relationDao.class);
	}
		//增加关注
		public boolean Insert(int followUserId,int fanUserId) {
			relation relation = new relation();
			relation.setFanUserId(fanUserId);
			relation.setFollowUserId(followUserId);
			int result = relationDao.relationInsert(relation);
			sqlSession.commit();
			if(result == 1){
				return true;
			}else{
				return false;
			}
		}
		
		//查询关注
		public List<Integer> relationSelect(int fanUserId) {
			List<Integer> relations;
			relations =  relationDao.relationSelect(fanUserId);
			return relations;
		};
		
		//删除关注
		public boolean relationDelete(int followUserId,int fanUserId) {
			relation relation = new relation();
			relation.setFanUserId(fanUserId);
			relation.setFollowUserId(followUserId);
			int result = relationDao.relationDelete(relation);
			sqlSession.commit();
			if(result == 1){
				return true;
			}else{
				return false;
			}
		}
		
		//查询是否关注
		public boolean isRelation(int followUserId,int fanUserId) {
			int result = relationDao.relationIsSelect(followUserId, fanUserId);
			sqlSession.commit();
			if(result == 1){
				return true;
			}else{
				return false;
			}
		}
		
		//查询一个用户的所有粉丝
		public List<Integer> selectByfollowUserId(int followUserId) {
			List<Integer> relations;
			relations = relationDao.relationSelectByfollowUserId(followUserId);
			return relations;
		}
		
}
