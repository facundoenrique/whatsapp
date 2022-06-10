package com.facu.whatsapp.util;

import com.facu.whatsapp.adapters.inbounds.api.request.MessageRequest;

import java.time.OffsetDateTime;

public class Mocks {
    public static MessageRequest getMessageRequest(){
        return MessageRequest.builder()
                .message("Hola")
                .groupId(1l)
                .userId(1l)
                .dateSend(OffsetDateTime.now())
                .build();
    }
}
