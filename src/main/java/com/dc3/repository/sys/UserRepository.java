package com.dc3.repository.sys;

import org.springframework.data.repository.CrudRepository;

import com.dc3.model.sys.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
