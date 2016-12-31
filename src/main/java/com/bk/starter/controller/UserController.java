package com.bk.starter.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bk.starter.domain.User;
import com.bk.starter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveduser = userService.create(user);
		return new ResponseEntity<User>(saveduser, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User saveduser = userService.create(user);
		return new ResponseEntity<User>(saveduser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> userList() {
		return new ResponseEntity<List<User>>(userService.userList(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/by/username/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByEmailAddress(@PathVariable String username) {
		return new ResponseEntity<User>(userService.findByUserName(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> login(@RequestBody final LoginCredentials login) throws ServletException {
		LoginResponse response = new LoginResponse(null, false);
		if(userService.login(login.email, login.password)){
			response.status = true;
			response.token = Jwts.builder().setSubject(login.email).claim("email", login.email).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,  "bkApp").compact();
		}
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
	}
	
	
	
	private static class LoginCredentials {
		public String email;
		public String password;
	}
	
	@SuppressWarnings("unused")
	private static class LoginResponse {
        public String token;
        public boolean status;

		public LoginResponse(final String token, final boolean status) {
            this.token = token;
            this.status = status;
        }
    }
	
}
