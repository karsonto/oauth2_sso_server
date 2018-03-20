package com.karson.webmagic.serviceImpl;

import org.springframework.stereotype.Service;

import com.karson.webmagic.dao.UserDao;
import com.karson.webmagic.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 

@Service
public class CustomizeUserDetailService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		   User geOperator = userDao.findByUsername(username);
	        if(geOperator == null){  
	        	 throw new RuntimeException("User not found");
	        }      
	        return geOperator;  

	}
 
}
