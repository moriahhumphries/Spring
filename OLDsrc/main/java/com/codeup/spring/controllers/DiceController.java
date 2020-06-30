package com.codeup.spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {
//    @GetMapping("/roll-dice/{guess}")
//    public String rollDice(){
//        return "roll-dice-game/roll-dice";
//    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDiceGuess(@PathVariable int guess, Model model){
        String message;

        int random = (int) Math.ceil(Math.random() * 6);

        if (random == guess) {
            message = "You guessed correct!";
        } else {
            message = "You guessed wrong.";
        }

        model.addAttribute("message", message);
        model.addAttribute("guess", guess);
        model.addAttribute("random", random);

        return "roll-dice-game/roll-dice";
    }
}