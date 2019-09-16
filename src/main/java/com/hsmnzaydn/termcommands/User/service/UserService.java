package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.User.ApplicationUser;

public interface UserService {

    ApplicationUser findUserByEmail(String email);
    ApplicationUser saveUser(ApplicationUser applicationUser);
}
