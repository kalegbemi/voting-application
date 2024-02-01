package com.ingryd_capstone_project.votingapplication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@SuperBuilder
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
    private String timeStamp;
    private String status;
    private int statusCode;
    private String message;
    private String path;
    private String requestMethod;
    private Map<?,?> data;

}
