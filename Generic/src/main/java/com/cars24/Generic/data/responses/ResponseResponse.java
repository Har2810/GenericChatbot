package com.cars24.Generic.data.responses;

// src/main/java/com/loans24/chatbot/response/ResponseResponse.java
//package com.loans24.chatbot.response;

//package com.cars24.Generic.data.responses;

//package com.cars24.Generic.data.responses;

public class ResponseResponse {

    private String id;
    private String promptId;
    private String text;
    private boolean hasAttachments;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPromptId() {
        return promptId;
    }

    public void setPromptId(String promptId) {
        this.promptId = promptId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHasAttachments() {
        return hasAttachments;
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }
}
