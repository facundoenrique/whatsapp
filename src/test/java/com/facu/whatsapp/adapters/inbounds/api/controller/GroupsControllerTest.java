package com.facu.whatsapp.adapters.inbounds.api.controller;

import com.facu.whatsapp.domain.model.Message;
import com.facu.whatsapp.domain.service.GroupsService;
import com.facu.whatsapp.util.Mocks;
import com.facu.whatsapp.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class GroupsControllerTest {

    private static final String PATH = "/groups";


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GroupsService groupsService;

    @InjectMocks
    private GroupsController groupsController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(groupsController)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    void post_OK() throws Exception {

        //Given
        given(groupsService.save(any(Message.class)))
                .willReturn(new ResponseEntity(Message.builder()
                        .groupId(1l)
                        .message("Hola")
                        .userId(1l)
                        .createdSend(OffsetDateTime.now())
                        .build(), HttpStatus.CREATED));


        //When
        var result = mockMvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.toJson(Mocks.getMessageRequest())));

        result.andExpect(status().isCreated());
        //Faltaria testear todos los atributos de la respuesta

    }
}
