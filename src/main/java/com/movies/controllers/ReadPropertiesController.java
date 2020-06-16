package com.movies.controllers;

import com.movies.properties.MyPropertiesCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DostM on 6/16/2020.
 */
@RestController
@RequestMapping("/io")
public class ReadPropertiesController {
    @Value("${io.com.message}")
    private String message;

//    @Autowired
//    Environment env;

    @Autowired
    public MyPropertiesCustom prop;

    @GetMapping("/readprop")
    public String readProps(){
        //return message;
        //return "env : "+env.getProperty("io.com.message");
        return "from fil: "+prop.getMessageRoot();
    }
}
