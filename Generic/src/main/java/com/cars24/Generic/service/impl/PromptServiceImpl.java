package com.cars24.Generic.service.impl;

import com.cars24.Generic.data.dao.PromptDao;
import com.cars24.Generic.data.entities.Prompt;
import com.cars24.Generic.data.responses.PromptResponse;
import com.cars24.Generic.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromptServiceImpl implements PromptService {

    @Autowired
    private PromptDao promptDao;

    @Override
    public List<PromptResponse> getInitialPrompts() {
        List<Prompt> prompts = promptDao.findMainCategoriesWithDisplayOrder();
        return prompts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PromptResponse getPromptById(String promptId) {
        Prompt prompt = promptDao.findById(promptId)
                .orElseThrow(() -> new RuntimeException("Prompt not found: " + promptId));
        return convertToResponse(prompt);
    }

    @Override
    public List<PromptResponse> getNextPrompts(String promptId) {
//        Prompt prompt = promptDao.findById(promptId)
//                .orElseThrow(() -> new RuntimeException("Prompt not found: " + promptId));
        Prompt prompt = promptDao.findById(promptId)
                .orElseThrow(() -> new RuntimeException("Prompt not found: " + promptId));


        List<Prompt> nextPrompts = promptDao.findAllByIdIn(prompt.getNextPromptIds());
        return nextPrompts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private PromptResponse convertToResponse(Prompt prompt) {
        PromptResponse response = new PromptResponse();
        response.setId(prompt.getId());
        response.setText(prompt.getText());
        response.setCategory(prompt.getCategory());
        response.setNextPromptIds(prompt.getNextPromptIds());
        return response;
    }
}
