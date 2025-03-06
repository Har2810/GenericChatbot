package com.cars24.Generic.data.responses;

import java.util.List;

public class ChatbotInteractionResponse {
    private ResponseResponse response;  // Bot's response to the prompt
    private List<PromptResponse> nextPrompts;  // Next available options/prompts for user

    public ResponseResponse getResponse() {
        return response;
    }

    public void setResponse(ResponseResponse response) {
        this.response = response;
    }

    public List<PromptResponse> getNextPrompts() {
        return nextPrompts;
    }

    public void setNextPrompts(List<PromptResponse> nextPrompts) {
        this.nextPrompts = nextPrompts;
    }
}
