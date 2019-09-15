package com.hsmnzaydn.termcommands.User;


import com.hsmnzaydn.termcommands.User.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="User services", description="Include all user services")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findUser(@PathVariable("email") String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

}
