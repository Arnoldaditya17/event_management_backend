package com.project.UniversityEventManagement.service;


import com.project.UniversityEventManagement.model.UserEntity;
import com.project.UniversityEventManagement.repository.UserRepository;
import com.project.UniversityEventManagement.utility.PasswordMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;
    public UserEntity validateUser(String email, String password) {

        return userRepository.findByEmailAndPassword(email,password);

    }

    public UserEntity findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity user) {
        user.setPassword(PasswordMaker.generatePassword());
        userRepository.save(user);
        if(user.getId() !=null){
            mailService.sendMailToUser(user.getEmail(),user.getPassword());
        }
        return user;
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
