package com.service;
/*
 * 微博操作
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.dao.weiboDao;
import com.entity.weibo;
import com.tool.DBAccess;

/*
 * 微博活动
 */
public class weiboService {
	weiboDao weiboDao;
	SqlSession sqlSession;
	public weiboService() throws IOException {
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		weiboDao = sqlSession.getMapper(weiboDao.class);
	}
	//发布原创微博
	public boolean insert(int userId,String weiboContent,String weiboImg) {
		weibo weibo = new weibo();
		weibo.setUserId(userId);
		weibo.setWeiboContent(weiboContent);
		weibo.setWeiboImg(weiboImg);
		if(weiboDao.weiboInsert(weibo)){
			sqlSession.commit();
			return true;
		}else{
			return false;
		}	
	}
	//查询微博
	public List<weibo> selectByuserId(int userId,int page,int contentSize) throws IOException {
		int pageSize = page*2;
		List< weibo> weibos = weiboDao.weiboSelectByuserId(userId,pageSize,contentSize);
		return weibos;
	}
	//用户对某条微博进行评论，评论总数变化
	public boolean weiboLikeAdd(int weiboId,int add) {
		if(weiboDao.weiboLikeAdd(weiboId, add) == 1) {
			sqlSession.commit();
			return true;
		}else{
			return false;
		}
	}
	
	//用户对一条微博点赞或取消赞，总数变化
	public boolean weiboCommentAdd(int weiboId,int add) {
		if(weiboDao.weiboCommentAdd(weiboId, add) == 1) {
			sqlSession.commit();
			return true;
		}else{
			return false;
		}
	}
	//根据用户的关注查询微博
	public List<weibo> selectByRelation(List<Integer> follows,int page,int contentSize) throws IOException {
		int pageSize = page*2;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", follows);
		map.put("pageSize", pageSize);
		map.put("contentSize",contentSize);
		List<weibo> weibos = weiboDao.weiboSelectByRelation(map);
		return weibos;
	}
	//转发微博，根据微博Id查询后新增
	public boolean forward(int weiboId,int userId) {
		weibo oldweibo = weiboDao.weiboSelecByWeiboId(weiboId);
		weibo newweibo = new weibo();
		System.out.println(oldweibo.getForwardId());
		if(oldweibo.getForwardId() > 0 ){
			newweibo.setForwardId(oldweibo.getForwardId());
		}else{
			newweibo.setForwardId(oldweibo.getUserId());
		}
		newweibo.setWeiboCommentNum(0);
		newweibo.setWeiboLikeNum(0);
		newweibo.setUserId(userId);
		newweibo.setWeiboContent(oldweibo.getWeiboContent());
		newweibo.setWeiboImg(oldweibo.getWeiboImg());
		weiboDao.weiboInsert(newweibo);
		sqlSession.commit();
		return true;
	}
}
