package com.Anshul.myjournal.Controllers;

import com.Anshul.myjournal.Entities.User;
import com.Anshul.myjournal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){

        userService.createNewUser(user);
    }

}
