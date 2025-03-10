package com.cars24.Generic.service;

import com.cars24.Generic.data.responses.NextPromptResponse;

import java.util.List;

public interface PromptService {
    List<NextPromptResponse> getInitialPrompts();
    List<NextPromptResponse> getNextPrompts(String promptId);
}
