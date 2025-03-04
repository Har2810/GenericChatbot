package com.cars24.Generic.service.impl;

//package com.cars24.Generic.service.impl;

import com.cars24.Generic.data.entities.Response;
import com.cars24.Generic.data.repositories.ResponseRepository;
import com.cars24.Generic.data.responses.ResponseResponse;
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
    public ResponseResponse getResponseByPromptId(String promptId) {
//        Response response = responseRepository.findByPromptId(promptId)
//                .orElseThrow(() -> new RuntimeException("Response not found for prompt: " + promptId));
//        return convertToResponse(response);
        Query query = new Query(Criteria.where("promptId").is(promptId));
        Response response = mongoTemplate.findOne(query, Response.class);
        if (response == null) {
            throw new RuntimeException("Response not found for prompt: " + promptId);
        }
        return convertToResponse(response);
    }

    private ResponseResponse convertToResponse(Response response) {
        ResponseResponse responseDto = new ResponseResponse();
        responseDto.setId(response.getId());
        responseDto.setPromptId(response.getPromptId());
        responseDto.setText(response.getText());
        responseDto.setHasAttachments(response.isHasAttachments());
        return responseDto;
    }
}

