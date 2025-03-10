package com.cars24.Generic.data.responses;

import lombok.Data;

import java.util.List;
@Data
public class ChatbotInteractionResponse {
    private RespCollectionResponse response;  // Bot's response to the prompt
    private List<NextPromptResponse> nextPrompts;
    private List<NextPromptResponse> initialPrompts;
}
