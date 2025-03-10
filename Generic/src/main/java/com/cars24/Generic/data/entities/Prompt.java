package com.cars24.Generic.data.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
//import org.springframework.data.annotation.Id;

@Data
@Document(collection = "Generic_prompts")
public class Prompt {
    @Id
    private String id;
    private String prompt_id;
    private String text;
    private String category;
    private int displayOrder;
    private List<String> nextPromptIds;
    private Date createdAt;
    private Date updatedAt;
}