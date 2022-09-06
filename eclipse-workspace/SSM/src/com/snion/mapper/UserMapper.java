package com.snion.mapper;

import org.apache.ibatis.annotations.Param;

import com.snion.entity.User;

public interface UserMapper {

	public User getUser(String identifier);
	
	public int update(User user);
	
//	List<Role> getRolesByParam(@Param("key_id") int id, @Param("key_name") String name);


}
