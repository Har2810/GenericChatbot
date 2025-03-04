package com.cars24.Generic.service;

import com.cars24.Generic.data.responses.PromptResponse;

import java.util.List;

public interface PromptService {
    List<PromptResponse> getInitialPrompts();
    PromptResponse getPromptById(String promptId);
    List<PromptResponse> getNextPrompts(String promptId);
}
