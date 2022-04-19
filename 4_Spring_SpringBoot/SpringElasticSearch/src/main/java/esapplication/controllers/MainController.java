package esapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/get")
    public String getMessageToKafkaTopic() {
        return "Hello world";
    }
}
