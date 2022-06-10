package com.facu.whatsapp.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiDocConstants {

    public static final String SAVE_MESSAGE_REQUEST = "" +
            "{" +
                "\"userId\":\"123456\"" +
                "\"groupId\":\"2222\"" +
                "\"message\":\"Hola\"" +
                "\"dateSend\":\"2022-06-10 01:22:00\"" +
            "}";
}
