package com.facu.whatsapp.adapters.inbounds.api.controller;

import com.facu.whatsapp.adapters.inbounds.api.request.MessageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.facu.whatsapp.utils.*;

@Tag(name="Groups")
public interface GroupsControllerDoc {
    @Operation(summary = "Save message",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = { @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MessageRequest.class),
                    examples = { @ExampleObject(value = ApiDocConstants.SAVE_MESSAGE_REQUEST)})}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
    })
    ResponseEntity save(
            @RequestBody MessageRequest messageRequest);
}

