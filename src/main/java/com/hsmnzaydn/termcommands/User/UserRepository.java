package com.hsmnzaydn.termcommands.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser,Integer> {


    ApplicationUser findUserByUsername(String username);

}
