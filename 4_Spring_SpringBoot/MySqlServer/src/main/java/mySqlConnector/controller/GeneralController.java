package mySqlConnector.controller;

import mySqlConnector.entity.User;
import mySqlConnector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class GeneralController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ping")
    @ResponseBody
    public String getInfo() {
        return "Hello World";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name) {
        User u = new User();
        u.name=  name;
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}