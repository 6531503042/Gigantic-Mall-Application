package com.gigantic.admin.Service.Impl;

import com.gigantic.admin.Repository.RoleRepository;
import com.gigantic.admin.Repository.UserRepository;
import com.gigantic.admin.Service.UserService;
import com.gigantic.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }
}