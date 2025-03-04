package com.cars24.Generic.data.entities;

// src/main/java/com/loans24/chatbot/entity/Response.java
//package com.loans24.chatbot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "responses")
public class Response {
    @Id
    private String id;
    private String promptId;
    private String text;
    private boolean hasAttachments;
    private Date createdAt;
    private Date updatedAt;

    // Constructors, getters, setters
    public Response() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPromptId() { return promptId; }
    public void setPromptId(String promptId) { this.promptId = promptId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isHasAttachments() { return hasAttachments; }
    public void setHasAttachments(boolean hasAttachments) { this.hasAttachments = hasAttachments; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
