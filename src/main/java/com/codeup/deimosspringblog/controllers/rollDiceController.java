package com.codeup.deimosspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class rollDiceController {
    @GetMapping("/roll-dice")
    public String roll(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String guess(@PathVariable String guess, Model model){
        boolean display = (guess != null);
        String roll1 = Integer.toString((int) (Math.random() * ((6 - 1) + 1)) + 1);
        boolean first = roll1.equals(guess);
        boolean first2 = !roll1.equals(guess);
        String roll2 = Integer.toString((int) (Math.random() * ((6 - 1) + 1)) + 1);
        boolean second = roll2.equals(guess);
        boolean second2 = !roll2.equals(guess);
        String roll3 = Integer.toString((int) (Math.random() * ((6 - 1) + 1)) + 1);
        boolean third = roll3.equals(guess);
        boolean third2 = !roll3.equals(guess);
        model.addAttribute("first", first);
        model.addAttribute("firstR", roll1);
        model.addAttribute("second", second);
        model.addAttribute("secondR", roll2);
        model.addAttribute("third", third);
        model.addAttribute("thirdR", roll3);
        model.addAttribute("first2", first2);
        model.addAttribute("second2", second2);
        model.addAttribute("third2", third2);
        model.addAttribute("display", display);
        return "roll-dice";
    }
}
