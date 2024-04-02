package com.example.DiplomWork;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.DiplomWork.domain.Message;
import com.example.DiplomWork.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
            ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }


    @PostMapping("/getmessage")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

}
