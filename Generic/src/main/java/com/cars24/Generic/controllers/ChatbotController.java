package com.cars24.Generic.controllers;

//package com.loans24.chatbot.controller;


import com.cars24.Generic.data.responses.PromptResponse;
import com.cars24.Generic.data.responses.ResponseResponse;
import com.cars24.Generic.service.PromptService;
import com.cars24.Generic.service.ResponseService;
import com.cars24.Generic.service.impl.PromptServiceImpl;
import com.cars24.Generic.service.impl.ResponseServiceImpl;
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
    public ResponseEntity<List<PromptResponse>> getInitialPrompts() {
        List<PromptResponse> prompts = promptService.getInitialPrompts();
        return ResponseEntity.ok(prompts);
    }

    @GetMapping("/prompt/{promptId}")
    public ResponseEntity<PromptResponse> getPromptById(@PathVariable String promptId) {
        PromptResponse prompt = promptService.getPromptById(promptId);
        return ResponseEntity.ok(prompt);
    }

    @GetMapping("/response/{promptId}")
    public ResponseEntity<ResponseResponse> getResponseForPrompt(@PathVariable String promptId) {
        ResponseResponse response = responseService.getResponseByPromptId(promptId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/next-prompts/{promptId}")
    public ResponseEntity<List<PromptResponse>> getNextPrompts(@PathVariable String promptId) {
        List<PromptResponse> prompts = promptService.getNextPrompts(promptId);
        return ResponseEntity.ok(prompts);
    }


}