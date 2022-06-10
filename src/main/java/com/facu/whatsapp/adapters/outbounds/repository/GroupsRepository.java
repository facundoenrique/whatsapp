package com.facu.whatsapp.adapters.outbounds.repository;

import com.facu.whatsapp.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GroupsRepository {

    private final GroupsRepositoryMyBatis groupsRepositoryMyBatis;

    public Message save(Message message){
        return groupsRepositoryMyBatis.save(message);
    }

    public Object checkUser(Long userId, Long groupId){
        return groupsRepositoryMyBatis.checkUser(userId,groupId);
    }

}
