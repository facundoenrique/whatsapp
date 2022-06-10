package com.facu.whatsapp.domain.service;

import com.facu.whatsapp.adapters.outbounds.repository.GroupsRepository;
import com.facu.whatsapp.domain.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class GroupsService {

    private final GroupsRepository groupsRepository;

    public ResponseEntity save(Message message){

        //chequeo que el usuario pertenezca al grupo
//        Object check = groupsRepository.checkUser(message.getUserId(),message.getGroupId());
//        if (Objects.isNull(check)){
//            throw new SecurityException();
//        }

        Message result = groupsRepository.save(message);
        sendNotification(result);


        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    private void sendNotification(Message message){

    }

}
