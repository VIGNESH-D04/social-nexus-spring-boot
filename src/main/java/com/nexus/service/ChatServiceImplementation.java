package com.nexus.service;

import com.nexus.exception.ChatException;
import com.nexus.models.Chat;
import com.nexus.models.User;
import com.nexus.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImplementation implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(User reqUser, User user2) {
        Chat isExist = chatRepository.findChatByUsersId(user2, reqUser);

        if (isExist != null) {
            return isExist;
        }

        Chat chat = new Chat();
        chat.getUsers().add(user2);
        chat.getUsers().add(reqUser);
        chat.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatId) throws ChatException {
        Optional<Chat> optional = chatRepository.findById(chatId);

        if (optional.isEmpty()) {
            throw new ChatException("Chat not found with id: " + chatId);
        }

        return optional.get();
    }

    @Override
    public List<Chat> findUsersChat(Integer userId) {

        return chatRepository.findByUsersId(userId);
    }
}
