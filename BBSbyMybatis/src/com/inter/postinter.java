package com.inter;

import java.util.List;
import com.entity.post;

public interface postinter {
	//
	public List<post> display();
	//
	public boolean deletepost(String title);
	//
	public boolean addpost(post post);
	//
	public boolean dianzan(String title);
}
