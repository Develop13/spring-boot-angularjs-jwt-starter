package com.bk.starter.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.starter.domain.User;
import com.bk.starter.repository.UserRepository;
import com.bk.starter.service.UserService;
import com.bk.starter.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
    public User create(User user) {
		user.setPassword(CommonUtil.hashedPassword(user.getPassword()));
		if(user.getId() != null) {
			user.setModifiedDate(new Date().getTime());
			user.setModifiedBy(user.getId());
		} else {
			user.setCreatedDate(new Date().getTime());
			user.setModifiedDate(new Date().getTime());
		}
		return userRepository.save(user);
    }
	

	@Override
	public List<User> userList() {
		return userRepository.getUserList();
	}


	@Override
	public User findByUserName(String username) {
		return userRepository.findByUserName(username);
	}


	@Override
	public boolean login(String email, String password) {
		return userRepository.checkUserExist(email, CommonUtil.hashedPassword(password));
	}

}
