package com.cars24.Generic.service.impl;

//import com.cars24.Generic.data.dao.PromptDao;
import com.cars24.Generic.data.entities.Prompt;
import com.cars24.Generic.data.responses.NextPromptResponse;
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
    public List<NextPromptResponse> getInitialPrompts() {
        Query query = new Query(Criteria
                .where("category").is("main_category")
                .and("displayOrder").lte(5));
        query.with(Sort.by(Sort.Order.asc("displayOrder")));
        List<Prompt> prompts = mongoTemplate.find(query, Prompt.class);

             return prompts.stream()
                .map(this::convertToNextResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<NextPromptResponse> getNextPrompts(String prompt_id) {
        Query findPromptQuery = new Query(Criteria.where("prompt_id").is(prompt_id));
        Prompt prompt = mongoTemplate.findOne(findPromptQuery, Prompt.class);
        //Prompt prompt = mongoTemplate.findById(prompt_id, Prompt.class);
        if (prompt == null) {
            //throw new RuntimeException("Prompt not found: " + promptId);
            throw new PromptNotFoundException("Prompt not found :" + prompt_id);
        }

        Query query = new Query(Criteria.where("prompt_id").in(prompt.getNextPromptIds()));
        List<Prompt> nextPrompts = mongoTemplate.find(query, Prompt.class);

        return nextPrompts.stream()
                .map(this::convertToNextResponse)
                .collect(Collectors.toList());
    }

    private NextPromptResponse convertToNextResponse(Prompt prompt) {
        NextPromptResponse nextPromptResponse = new NextPromptResponse();
        nextPromptResponse.setPrompt_id(prompt.getPrompt_id());
        nextPromptResponse.setText(prompt.getText());
        nextPromptResponse.setCategory(prompt.getCategory());
        return nextPromptResponse;
    }
}
