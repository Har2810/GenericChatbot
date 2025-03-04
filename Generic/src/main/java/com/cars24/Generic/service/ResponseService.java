package com.cars24.Generic.service;

//package com.cars24.Generic.service;

import com.cars24.Generic.data.responses.ResponseResponse;

public interface ResponseService {
    ResponseResponse getResponseByPromptId(String promptId);
}

