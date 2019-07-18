package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("allmsg", messageRepository.findAll());
        return "listAll";
    }

    @GetMapping("/add")
    public String addMsg(Model model) {
        model.addAttribute("newmsg", new Message());
        return "addMsg";
    }


    @PostMapping("/process")
    public String processMsg(@Valid Message msg, BindingResult result) {

        if (result.hasErrors())
            return "addMsg";
        else {
            messageRepository.save(msg);
            return "redirect:/";
        }

    }
}
