package com.example.WordMapping;

import com.example.WordMapping.model.Heart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class WordController {

    @Autowired
    Heart heart;

    @RequestMapping("/home")
    public String vineet() throws Exception {

        heart.makeConnection("hey", "there");

        return "hey vineet";


    }

}
