package com.cars24.Generic.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
//import org.springframework.data.annotation.Id;


@Document(collection = "prompts")
public class Prompt {
    @Id
    private String id;
    private String text;
    private String category;
    private int displayOrder;
    private List<String> nextPromptIds;
    private Date createdAt;
    private Date updatedAt;

    // Constructors
    public Prompt() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public List<String> getNextPromptIds() {
        return nextPromptIds;
    }

    public void setNextPromptIds(List<String> nextPromptIds) {
        this.nextPromptIds = nextPromptIds;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}