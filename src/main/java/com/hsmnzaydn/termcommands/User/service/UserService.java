package com.hsmnzaydn.termcommands.User.service;

import com.hsmnzaydn.termcommands.User.User;

public interface UserService {

    User findUserByEmail(String email);
    User saveUser(User user);
}
