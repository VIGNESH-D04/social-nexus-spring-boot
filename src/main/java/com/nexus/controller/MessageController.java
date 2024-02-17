package com.nexus.controller;

import com.nexus.models.Message;
import com.nexus.models.User;
import com.nexus.service.MessageService;
import com.nexus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestHeader ("Authorization") String jwt,
                                 @RequestBody Message req, @PathVariable Integer chatId) throws Exception {

        User user = userService.findUserByJwt(jwt);
        Message message = messageService.createMessage(user, chatId, req);

        return message;
    }

    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatsMessages(@RequestHeader ("Authorization") String jwt,
                                           @PathVariable Integer chatId) throws Exception {

        User user = userService.findUserByJwt(jwt);
        List<Message> messages = messageService.findChatsMessages(chatId);

        return messages;
    }

}
