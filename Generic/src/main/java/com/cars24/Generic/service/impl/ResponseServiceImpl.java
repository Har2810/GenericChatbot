package com.cars24.Generic.service.impl;

//package com.cars24.Generic.service.impl;

import com.cars24.Generic.data.entities.Response;
import com.cars24.Generic.data.repositories.ResponseRepository;
import com.cars24.Generic.data.responses.ResponseResponse;
import com.cars24.Generic.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public ResponseResponse getResponseByPromptId(String promptId) {
        Response response = responseRepository.findByPromptId(promptId)
                .orElseThrow(() -> new RuntimeException("Response not found for prompt: " + promptId));
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

