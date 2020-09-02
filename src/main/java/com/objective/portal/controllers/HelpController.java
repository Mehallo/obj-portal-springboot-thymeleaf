package com.objective.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/")
public class HelpController {

    @CrossOrigin
    @RequestMapping("help")
    public String getInfo(){
        return "help";
    }

}
