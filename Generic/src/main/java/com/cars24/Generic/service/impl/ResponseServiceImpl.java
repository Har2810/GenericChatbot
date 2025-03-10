package com.cars24.Generic.service.impl;

//package com.cars24.Generic.service.impl;

import com.cars24.Generic.data.entities.Prompt;
import com.cars24.Generic.data.entities.Response;
import com.cars24.Generic.data.repositories.ResponseRepository;
import com.cars24.Generic.data.responses.RespCollectionResponse;
import com.cars24.Generic.exceptions.PromptNotFoundException;
import com.cars24.Generic.exceptions.ResponseNotFoundException;
import com.cars24.Generic.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public RespCollectionResponse getResponseByPromptId(String prompt_id) {
        Query query = new Query(Criteria.where("prompt_id").is(prompt_id));
        Prompt prompt = mongoTemplate.findOne(query, Prompt.class);
        //Prompt prompt = mongoTemplate.findById(prompt_id, Prompt.class);
        if (prompt == null) {
            throw new PromptNotFoundException("Prompt not found: " + prompt_id);
        }
        //Query query = new Query(Criteria.where("prompt_id").is(prompt_id));
        Response response = mongoTemplate.findOne(query, Response.class);
        if (response == null) {
            throw new ResponseNotFoundException("Response not found for prompt: " + prompt_id);
        }
        return convertToResponse(response);
    }

    private RespCollectionResponse convertToResponse(Response response) {
        RespCollectionResponse respCollectionResponse = new RespCollectionResponse();
        respCollectionResponse.setResponse_id(response.getResponse_id());
        respCollectionResponse.setPrompt_id(response.getPrompt_id());
        respCollectionResponse.setText(response.getText());
        respCollectionResponse.setHasAttachments(response.isHasAttachments());
        return respCollectionResponse;
    }
}

