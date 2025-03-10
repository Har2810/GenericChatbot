package com.cars24.Generic.data.responses;

import lombok.Data;

//package com.cars24.Generic.data.responses;
@Data
public class RespCollectionResponse {
    private String id;
    private String promptId;
    private String text;
    private boolean hasAttachments;
}
