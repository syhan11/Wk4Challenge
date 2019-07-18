package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.Entity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.persistence.Id;

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
        model.addAttribute("onemsg", new Message());
        return "addMsg";
    }


    @PostMapping("/process")
    public String processMsg(@Valid Message onemsg, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("onemsg", onemsg);
            return "addMsg";
        }
        else {
            model.addAttribute("onemsg", onemsg);
            messageRepository.save(onemsg);
            return "redirect:/";
        }

    }

    @RequestMapping("/detail/{id}")
    public String showMsg(@PathVariable("id") long id, Model model){
        model.addAttribute("onemsg", messageRepository.findById(id).get());
        return "detailMsg";
    }

    @RequestMapping("/update/{id}")
    public String updateMsg(@PathVariable("id") long id, Model model){
        model.addAttribute("onemsg", messageRepository.findById(id).get());
        return "addMsg";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMsg(@PathVariable("id") long id, Model model) {
        messageRepository.deleteById(id);
        return "redirect:/";
    }
}
