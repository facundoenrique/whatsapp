package com.facu.whatsapp.adapters.inbounds.api.request;


import com.facu.whatsapp.domain.model.Message;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Validated
@Builder
public class MessageRequest {

    @NotNull
    private Long userId;
    @NotNull
    private Long groupId;
    @NotBlank
    private String message;
    @NotNull
    private OffsetDateTime dateSend;


    public Message toDomain(){
        return Message.builder()
                .userId(userId)
                .groupId(groupId)
                .message(message)
                .createdSend(dateSend)
                .build();
    }

}
