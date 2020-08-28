package com.objective.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class IndexController {

    @CrossOrigin
    @RequestMapping({"/", "index"})
    public String getIndex(){
        return "index";
    }
}
