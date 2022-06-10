package com.facu.whatsapp.domain.service;

import com.facu.whatsapp.adapters.outbounds.repository.GroupsRepository;
import com.facu.whatsapp.domain.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class GroupsService {

    private final GroupsRepository groupsRepository;

    public ResponseEntity save(Message message){

        Message result = groupsRepository.save(message);
        sendNotification(result);

        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    public List<Long> getUserGroups(Long groupId){
        return groupsRepository.getUserGroups(groupId);
    }

    private void sendNotification(Message message){


        List<Long> ids = getUserGroups(message.getGroupId());
        if (CollectionUtils.isEmpty(ids)){
            new Exception("Error al obtener los ids para enviar las notificaciones");
        }

        /*
         * Debería ser algún proceso asincrono, utilizando alguna cola tipo rabbitMQ, Kafka
         */
        ids.forEach(
                id -> log.info("Se envía notificación al usuario con id: "+id)
        );
    }

}
