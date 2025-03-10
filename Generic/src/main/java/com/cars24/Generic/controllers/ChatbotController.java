package com.cars24.Generic.controllers;

//package com.loans24.chatbot.controller;


import com.cars24.Generic.data.responses.*;
//import com.cars24.Generic.data.responses.GenericResponse;
import com.cars24.Generic.service.PromptService;
import com.cars24.Generic.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private PromptService  promptService;

    @Autowired
    private ResponseService responseService;


    @GetMapping("/interaction")
    //@ResponseBody
    public ResponseEntity<ApiResponse> getChatbotData(
            @RequestParam(value = "prompt_id", required = false) String promptId){
           // @RequestParam(required = false) String promptId) {
        ChatbotInteractionResponse response = new ChatbotInteractionResponse();

        // If promptId is not provided, return initial prompts
        if (promptId == null || promptId.isEmpty()) {
            List<NextPromptResponse> initialPrompts = promptService.getInitialPrompts();
            response.setInitialPrompts(initialPrompts);

            // Create success response directly
            ApiResponse apiResponse = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Initial prompts fetched successfully",
                    "APPUSR-" + HttpStatus.OK.value(),  // No error code for success case
                    true,
                    response
            );

            return ResponseEntity.ok(apiResponse);
                   // .contentType(MediaType.APPLICATION_JSON).body(apiResponse);
        }

        // Otherwise, return interaction details for the given promptId
        RespCollectionResponse botResponse = responseService.getResponseByPromptId(promptId);
        response.setResponse(botResponse);

        List<NextPromptResponse> nextPrompts = promptService.getNextPrompts(promptId);
        response.setNextPrompts(nextPrompts);

        // Create success response directly
        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "Interaction details fetched successfully",
                "APPUSR-" + HttpStatus.OK.value(),  // No error code for success case
                true,
                response
        );

        return ResponseEntity.ok(apiResponse);
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(apiResponse);
    }

}