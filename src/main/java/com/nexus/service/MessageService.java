package com.nexus.service;

import com.nexus.models.Chat;
import com.nexus.models.Message;
import com.nexus.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId, Message req) throws Exception;

    public List<Message> findChatsMessages(Integer chatId) throws Exception;

}
