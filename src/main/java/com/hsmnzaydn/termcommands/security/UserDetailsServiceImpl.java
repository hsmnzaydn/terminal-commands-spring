package com.hsmnzaydn.termcommands.security;

import com.hsmnzaydn.termcommands.User.ApplicationUser;
import com.hsmnzaydn.termcommands.User.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser developer = userRepository.findUserByEmail(username);
        if (developer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(developer.getEmail(), developer.getPassword(), emptyList());
    }
}