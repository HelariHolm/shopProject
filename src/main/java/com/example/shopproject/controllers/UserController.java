package com.example.shopproject.controllers;

import com.example.shopproject.entities.Product;
import com.example.shopproject.entities.User;
import com.example.shopproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@ResponseBody
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user")
    public User createUser(@Validated @RequestBody User user) {
        User createUser = new User();
        createUser.setUsername(user.getUsername());
        createUser.setUsertype(user.getUsertype());

        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userToUpdate)  {
        User foundUser = userRepository.findById(userId).orElseThrow();
        foundUser.setUsername(userToUpdate.getUsername());
        foundUser.setUsertype(userToUpdate.getUsertype());

        return userRepository.save(foundUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

}
