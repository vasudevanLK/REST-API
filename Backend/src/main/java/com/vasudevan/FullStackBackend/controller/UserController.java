package com.vasudevan.FullStackBackend.controller;

import com.vasudevan.FullStackBackend.exception.UserNotFoundException;
import com.vasudevan.FullStackBackend.model.User;
import com.vasudevan.FullStackBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost://3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);

    }
    @GetMapping("/allusers")
    List<User> getAllUsers(){

        return userRepository.findAll();
        }

    @GetMapping("/user/{id}")
    User getuserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user?{id}")

    User updateuserid(@RequestBody User newUser ,@PathVariable Long id ){
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                             }).orElseThrow(()->new  UserNotFoundException(id));
    }


    @DeleteMapping("/user/{id}")
    public String deleteuser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }

         userRepository.deleteById(id);
        return "User With ID "+ id +"has been deleted Successfully";
    }
    }


    

    
