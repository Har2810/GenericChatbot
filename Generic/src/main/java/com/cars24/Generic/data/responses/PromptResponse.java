package com.cars24.Generic.data.responses;

// src/main/java/com/loans24/chatbot/response/PromptResponse.java
//package com.loans24.chatbot.response;

import java.util.List;

public class PromptResponse {
    private String id;
    private String text;
    private String category;
    private List<String> nextPromptIds;

    // Constructors, getters, setters
    public PromptResponse() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public List<String> getNextPromptIds() { return nextPromptIds; }
    public void setNextPromptIds(List<String> nextPromptIds) { this.nextPromptIds = nextPromptIds; }
}