package com.facu.whatsapp.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Builder
@Data
public class Message {
    private Long userId;
    private Long groupId;
    private String message;
    private OffsetDateTime createdSend;
}
