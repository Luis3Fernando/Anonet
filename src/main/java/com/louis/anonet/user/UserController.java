package com.louis.anonet.user;

import com.louis.anonet.user.dto.UserRequest;
import com.louis.anonet.user.UserService;
import com.louis.anonet.user.model.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody @Valid UserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }
}
