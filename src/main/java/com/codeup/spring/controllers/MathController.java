package com.codeup.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number1, @PathVariable int number2 ) {
        return 3 + " plus " + 4 + " is equal to " + (number1 + number2) + "!";
    }
}
