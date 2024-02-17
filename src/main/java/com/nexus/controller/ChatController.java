package com.nexus.controller;

import com.nexus.models.Chat;
import com.nexus.models.User;
import com.nexus.request.ChatRequest;
import com.nexus.service.ChatService;
import com.nexus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/chats")
    public Chat createChat(@RequestBody ChatRequest req,
                           @RequestHeader ("Authorization") String jwt) throws Exception {
        User reqUser = userService.findUserByJwt(jwt);
        User user2 = userService.findUserById(req.getUserId());

        Chat chat = chatService.createChat(reqUser, user2);

        return chat;
    }

    @GetMapping("/api/chats")
    public List<Chat> findUsersChat(@RequestHeader ("Authorization") String jwt) {
        User user = userService.findUserByJwt(jwt);
        List<Chat> chats = chatService.findUsersChat(user.getId());

        return chats;
    }

}
