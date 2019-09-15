package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.Category.CategoryRepository;
import com.hsmnzaydn.termcommands.User.User;
import com.hsmnzaydn.termcommands.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
