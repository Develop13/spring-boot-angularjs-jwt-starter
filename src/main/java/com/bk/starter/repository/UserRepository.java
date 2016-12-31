package com.bk.starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bk.starter.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u")
	public List<User> getUserList();
	
	@Query("select u from User u where u.username = :username")
	public User findByUserName(@Param("username") String username);
	
	@Query("select case when count(u) > 0 then 'true' else 'false' end from User u where u.email = :email and u.password = :password")
	public boolean checkUserExist(@Param("email") String email, @Param("password")String hashedPassword);
	
}
