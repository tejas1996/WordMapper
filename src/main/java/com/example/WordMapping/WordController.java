package com.example.WordMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class WordController {


    @RequestMapping("/home")
    public String vineet() {

        return "hey vineet";


    }

}
