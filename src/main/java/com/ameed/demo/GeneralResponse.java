package com.ameed.demo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by ameed_fah
 * 10/05/2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse {
    private String error;
    private Object result;

    public GeneralResponse() {
    }

    public GeneralResponse(Object result) {
        this.result = result;
    }

    public GeneralResponse(Exception e) {
        this.result = null;
        this.error = e.getMessage();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
