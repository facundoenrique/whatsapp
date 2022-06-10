package com.facu.whatsapp.adapters.inbounds.api.controller;

import com.facu.whatsapp.adapters.inbounds.api.request.MessageRequest;
import com.facu.whatsapp.domain.model.Message;
import com.facu.whatsapp.domain.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupsController implements GroupsControllerDoc{

    private final GroupsService groupsService;

    @PostMapping
    public ResponseEntity save(MessageRequest messageRequest){
        return groupsService.save(messageRequest.toDomain());
    }

}
