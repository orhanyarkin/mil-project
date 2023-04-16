package com.orhan.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Test {
    @GetMapping("/testing")
    @ResponseBody
    public String getTest(){
        return "Test";
    }
}
