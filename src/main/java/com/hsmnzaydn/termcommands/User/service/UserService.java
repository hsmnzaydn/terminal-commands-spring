package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.User.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {

    ApplicationUser saveUser(ApplicationUser applicationUser);
    ApplicationUser findUserByusername(String username);
}
