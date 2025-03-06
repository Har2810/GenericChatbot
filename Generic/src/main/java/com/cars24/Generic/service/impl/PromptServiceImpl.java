package com.cars24.Generic.service.impl;

//import com.cars24.Generic.data.dao.PromptDao;
import com.cars24.Generic.data.entities.Prompt;
import com.cars24.Generic.data.responses.ApiResponse;
import com.cars24.Generic.data.responses.PromptResponse;
import com.cars24.Generic.exceptions.PromptNotFoundException;
import com.cars24.Generic.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromptServiceImpl implements PromptService {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<PromptResponse> getInitialPrompts() {
        Query query = new Query(Criteria
                .where("category").is("main_category")
                .and("displayOrder").lte(5));
        query.with(Sort.by(Sort.Order.asc("id")));
        List<Prompt> prompts = mongoTemplate.find(query, Prompt.class);

             return prompts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PromptResponse getPromptById(String promptId) {
        Prompt prompt = mongoTemplate.findById(promptId, Prompt.class);
        if (prompt == null) {
            throw new PromptNotFoundException("Prompt not found: " + promptId);
        }
        return convertToResponse(prompt);
    }

    @Override
    public List<PromptResponse> getNextPrompts(String promptId) {
        Prompt prompt = mongoTemplate.findById(promptId, Prompt.class);
        if (prompt == null) {
            //throw new RuntimeException("Prompt not found: " + promptId);
            throw new PromptNotFoundException("Prompt not found :" + promptId);
        }

        Query query = new Query(Criteria.where("_id").in(prompt.getNextPromptIds()));
        List<Prompt> nextPrompts = mongoTemplate.find(query, Prompt.class);

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
