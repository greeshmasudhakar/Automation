package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseModel {
    private String status;
    private String place_id;
    private String scope;
    private String reference;
    private String id;
}
