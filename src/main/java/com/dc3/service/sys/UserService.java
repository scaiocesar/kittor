package com.dc3.service.sys;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.sys.User;
import com.dc3.repository.sys.UserRepository;

@Service("userService")
@Transactional
public class UserService implements Serializable{

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public Iterable<User> findAll(){
    	return userRepository.findAll();
    }
    
    public void save(User user){
    	userRepository.save(user);
    }

    public void saveGenaretePwd(User user){
    	SecureRandom random = new SecureRandom();
    	user.setPassword(new BigInteger(40, random).toString(34));
    	userRepository.save(user);
    }
    public void delete(Integer idUser){
    	userRepository.delete(idUser);
    }
}
