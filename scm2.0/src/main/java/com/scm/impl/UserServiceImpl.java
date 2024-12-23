package com.scm.impl;

import com.scm.entities.User;
import com.scm.helpers.ResourcesNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    private Logger logger= LoggerFactory.getLogger(this.getClass());



    @Override
    public User saveUser(User user) {
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }


    public UserServiceImpl() {
    }

    @Override
    public Optional<User> updateUser(User user) {

         User user2=userRepo.findById(user.getUserId()).orElseThrow(()->new ResourcesNotFoundException("user not  found"));
         user2.setName(user.getName());
         user2.setEmail(user.getEmail());
         user2.setPassword(user.getPassword());
         user2.setAbout(user.getAbout());
         user2.setPhoneNumber(user.getPhoneNumber());
         user2.setProfilePic(user.getProfilePic());
         user2.setEnabled(user.isEnabled());
         user2.setEmailVerified(user.isEmailVerified());
         user2.setPhoneVerified(user.isPhoneVerified());
         user2.setProvider(user.getProvider());
         user2.setProviderId(user.getProviderId());

         User save=userRepo.save(user2);
         return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2=userRepo.findById(id).orElseThrow(()->new ResourcesNotFoundException("user not  found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExists(String id) {
        User user2=userRepo.findById(id).orElse(null);
        return user2!=null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        User user=userRepo.findByEmail(email).orElse(null);
        return user!=null?true:false;
    }
}
