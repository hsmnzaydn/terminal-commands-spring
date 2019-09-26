package com.hsmnzaydn.termcommands.User;


import com.hsmnzaydn.termcommands.User.service.UserService;
import com.hsmnzaydn.termcommands.Utility.JwtTokenUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Api(value="ApplicationUser services", description="Include all user services")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;



    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @PostMapping
    public ResponseEntity<ApplicationUser> createUser(@RequestBody ApplicationUser applicationUser){

        ApplicationUser applicationUser1=applicationUser;
        applicationUser1.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        applicationUser1.setAuthorizationKey(jwtTokenUtil.generateToken(userService.loadUserByUsername(applicationUser.getUsername())));
        
      return ResponseEntity.ok(userService.saveUser(applicationUser1));
    }


}
