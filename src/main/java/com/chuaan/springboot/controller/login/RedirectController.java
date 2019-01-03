package com.chuaan.springboot.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author:chuaan
 * created:2019-01-03
 */

@Controller

public class RedirectController {

    @RequestMapping(value="redirect")
    public String redirect(Model model,
                           @RequestParam(value = "next", required = false) String next){
        model.addAttribute("next",next);
        return "login/login";
    }
}
