package com.example.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/")
@Controller
public class IndexController {

    @RequestMapping(value = "")
    public String index (ModelMap modelMap) {
        modelMap.addAttribute("msg" , "this is a msg");
        return "/view/index";
    }

}
