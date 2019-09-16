package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.User.ApplicationUser;
import com.hsmnzaydn.termcommands.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;


    @Override
    public ApplicationUser findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser applicationUser) {
        return userRepository.save(applicationUser);
    }
}
