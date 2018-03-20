package com.karson.webmagic.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karson.webmagic.domain.User;

public interface UserDao extends MongoRepository<User, String> {
	User findByUsername(String username);
}
