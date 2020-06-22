package com.codeup.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

///add/3/and/4	7
@Controller
public class MathController {
    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2 ) {
        return 3 + " plus " + 4 + " is equal to " + (number1 + number2) + "!";
    }

//    /subtract/3/from/10	7

    @RequestMapping(path = "/subtract/{number1}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number1, @PathVariable int number2 ) {
        return 10 + " minus " + 3 + " is equal to " + (number2 - number1) + "!";
    }


//            /multiply/4/and/5	20

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2 ) {
        return 4 + " times " + 5 + " is equal to " + (number1 * number2) + "!";
    }
//            /divide/6/by/3	2
    @RequestMapping(path = "/divide/{number1}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2 ) {
        return 6 + " divided by " + 3 + " is equal to " + (number1 / number2) + "!";
}




}
