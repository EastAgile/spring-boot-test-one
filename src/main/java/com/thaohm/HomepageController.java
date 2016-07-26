package com.thaohm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by thaohm on 7/26/16.
 */
@Controller
public class HomepageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", messageService.getMessage());
        return "index";
    }
}
