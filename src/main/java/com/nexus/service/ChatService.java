package com.nexus.service;

import com.nexus.exception.ChatException;
import com.nexus.models.Chat;
import com.nexus.models.User;

import java.util.List;

public interface ChatService {


    public Chat createChat(User reqUser, User user2);

    public Chat findChatById(Integer chatId) throws ChatException;

    public List<Chat> findUsersChat(Integer userId);
}
