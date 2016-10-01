package com.example.core.dao;

import com.example.core.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersDAO extends CrudRepository<Users, String> {

}
