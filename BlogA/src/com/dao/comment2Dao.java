package com.dao;

import java.util.List;
import com.entity.comment2;

public interface comment2Dao {
	
	//查询评论
	List<comment2> comment2Select(int commentId);
}
