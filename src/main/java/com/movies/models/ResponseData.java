package com.movies.models;

import lombok.Builder;
import lombok.Data;

/**
 * Created by DostM on 6/13/2020.
 */
@Data
@Builder
public class ResponseData {
    private Boolean success;
    private String message;
    private Object data;
}
