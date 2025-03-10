package com.cars24.Generic.service;

//package com.cars24.Generic.service;

import com.cars24.Generic.data.responses.RespCollectionResponse;

public interface ResponseService {
    RespCollectionResponse getResponseByPromptId(String promptId);
}

