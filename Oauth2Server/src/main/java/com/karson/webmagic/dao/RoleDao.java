package com.karson.webmagic.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karson.webmagic.domain.Role;


public interface RoleDao extends MongoRepository<Role, String> {
}
