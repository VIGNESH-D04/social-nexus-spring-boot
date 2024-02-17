package com.nexus.repository;

import com.nexus.models.Chat;
import com.nexus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    public List<Chat> findByUsersId(Integer userId);

    @Query("select c from Chat c where :user member of c.users and :reqUser member of c.users")
    public Chat findChatByUsersId(@Param("user") User user,
                                  @Param("reqUser") User reqUser);

}
