package com.codeup.deimosspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StringTransformController {
    @RequestMapping(path = "/string/reverse/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String reverse(@PathVariable String string){
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    @RequestMapping(path = "/string/uppercase/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String upper(@PathVariable String string){
        return string.toUpperCase();
    }

    @RequestMapping(path = "/string/both/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String both(@PathVariable String string){
        return upper(reverse(string));
    }

    @RequestMapping(path = "/string/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String query(@PathVariable String string, @RequestParam(value="reverse", required = true) boolean reverse, @RequestParam(value="caps", required = true) boolean caps){
        if (reverse){
            if (caps){
                return both(string);
            }
            else{
                return reverse(string);
            }
        }
        else{
            if (caps){
                return upper(string);
            }
            else{
                return string;
            }
        }
    }
}
