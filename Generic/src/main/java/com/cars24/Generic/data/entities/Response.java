package com.cars24.Generic.data.entities;

// src/main/java/com/loans24/chatbot/entity/Response.java
//package com.loans24.chatbot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@Data
@Document(collection = "responses")
public class Response {
    @Id
    private String id;
    private String promptId;
    private String text;
    private boolean hasAttachments;
    private Date createdAt;
    private Date updatedAt;
}
