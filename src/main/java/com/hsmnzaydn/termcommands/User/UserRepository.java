package com.hsmnzaydn.termcommands.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserByEmail(String email);
}
