package com.youtube.ecommerce.controller;

import com.youtube.ecommerce.entity.MailStructure;
import com.youtube.ecommerce.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable String mail ,@RequestBody MailStructure mailStructure){
        mailService.sendMail(mail, mailStructure);
        return "Mail Sent Successfully";
    }
}
