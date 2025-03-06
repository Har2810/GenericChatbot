package com.cars24.Generic.controllers;

//package com.loans24.chatbot.controller;


import com.cars24.Generic.data.responses.ApiResponse;
import com.cars24.Generic.data.responses.ChatbotInteractionResponse;
import com.cars24.Generic.data.responses.PromptResponse;
import com.cars24.Generic.data.responses.ResponseResponse;
import com.cars24.Generic.service.PromptService;
import com.cars24.Generic.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private PromptService  promptService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("/initial-prompts")
    public ResponseEntity<ApiResponse<List<PromptResponse>>> getInitialPrompts() {
        List<PromptResponse> prompts = promptService.getInitialPrompts();
        return ResponseEntity.ok((ApiResponse.success(prompts, "Initial prompts fetches successfully")));
    }

    @GetMapping("/prompt/{promptId}")
    public ResponseEntity<PromptResponse> getPromptById(@PathVariable String promptId) {
        PromptResponse prompt = promptService.getPromptById(promptId);
        return ResponseEntity.ok(prompt);
    }

    @GetMapping("/response/{promptId}")
    public ResponseEntity<ApiResponse<ResponseResponse>> getResponseForPrompt(@PathVariable String promptId) {
        ResponseResponse response = responseService.getResponseByPromptId(promptId);
        //return ResponseEntity.ok(response);
        return ResponseEntity.ok((ApiResponse.success(response, "promptId fetched successfully")));
    }

    @GetMapping("/next-prompts/{promptId}")
    public ResponseEntity<ApiResponse<List<PromptResponse>>> getNextPrompts(@PathVariable String promptId) {
        List<PromptResponse> prompts = promptService.getNextPrompts(promptId);
        return ResponseEntity.ok((ApiResponse.success(prompts, "next prompt details fetched successfully")));
    }

    @GetMapping("/interaction/{promptId}")
    public ResponseEntity<ApiResponse<ChatbotInteractionResponse>> getInteractionDetails(@PathVariable String promptId) {
        ChatbotInteractionResponse response = new ChatbotInteractionResponse();

        ResponseResponse botResponse = responseService.getResponseByPromptId(promptId);
        response.setResponse(botResponse);

        List<PromptResponse> nextPrompts = promptService.getNextPrompts(promptId);
        response.setNextPrompts(nextPrompts);

        return ResponseEntity.ok(ApiResponse.success(response, "Interaction details fetched successfully"));
    }
}