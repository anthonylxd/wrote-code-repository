package com.thony.FirstSpringboot.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;
import com.thony.FirstSpringboot.domin.User;

/**
 * {@link User} {@link Repository}
 *
 */
@Repository
public class UserRepository {

	/**
	 * 采用内存型的存储方式 ->Map
	 */
	private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<Integer, User>();
	
	private final static AtomicInteger idGenerator = new AtomicInteger();
	
	/**
	 * @param user
	 * @return
	 */
	public boolean save(User user) {
		Integer id = idGenerator.incrementAndGet();
		return repository.put(id, user) == null;
	}
	
}
