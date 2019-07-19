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

    /*
     * Basically a form object th:object="${onemsg}" is named "onemsg"
     * but the controller is looking for class name not "onemsg" (the variable name)
     */
    @PostMapping("/process")
    public String processMsg(@Valid @ModelAttribute("onemsg") Message onemsg,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addMsg";
        }
        else {
            //model.addAttribute("onemsg", onemsg);
            messageRepository.save(onemsg);
            return "redirect:/";
        }
    }

    @PostMapping("/updateprocess")
    public String processUpdateMsg(@Valid @ModelAttribute("onemsg") Message onemsg,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "updateMsg";
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
        return "updateMsg";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMsg(@PathVariable("id") long id, Model model) {
        messageRepository.deleteById(id);
        return "redirect:/";
    }
}
