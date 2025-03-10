package com.cars24.Generic.data.responses;

import lombok.Data;

@Data
public class NextPromptResponse {
    private String prompt_id;
    private String text;
    private String category;
}

