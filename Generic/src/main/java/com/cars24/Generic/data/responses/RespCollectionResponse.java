package com.cars24.Generic.data.responses;

import lombok.Data;

//package com.cars24.Generic.data.responses;
@Data
public class RespCollectionResponse {
    private String response_id;
    private String prompt_id;
    private String text;
    private boolean hasAttachments;
}
