package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.User.ApplicationUser;
import com.hsmnzaydn.termcommands.User.UserRepository;
import com.hsmnzaydn.termcommands.Utility.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ApplicationUser saveUser(ApplicationUser applicationUser) {

        return userRepository.save(applicationUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userRepository.findUserByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
