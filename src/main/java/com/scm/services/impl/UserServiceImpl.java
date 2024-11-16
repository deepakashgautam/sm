package com.scm.services.impl;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepository;
import com.scm.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }



    @Override
    public User saveUser(User user) {
        //UserId have to generate
        String userIdRandom = UUID.randomUUID().toString();
        user.setUserId(userIdRandom);
        //password encode
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
      User user1 =  userRepository.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
      //update karenge user, user2 from user
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePic(user.getProfilePic());
        user1.setEnabled(user.isEnabled());
        user1.setEmailVarified(user.isEmailVarified());
        user1.setPhoneVarified(user.isPhoneVarified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());
        //save the user in database
        User save = userRepository.save(user1);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user1 =  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
     userRepository.delete(user1);

    }

    @Override
    public boolean isUserExist(String userId) {
       User user1 = userRepository.findById(userId).orElse(null);
       return user1!=null? true: false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user1 = userRepository.findByEmail(email).orElse(null);
        return user1!=null? true: false;
    }

    @Override
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }
}
