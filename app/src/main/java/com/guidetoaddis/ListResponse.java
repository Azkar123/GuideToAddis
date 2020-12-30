package com.guidetoaddis;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse {

    @SerializedName("result")
    private List<ListResult> result = null;

    @SerializedName("status")
    private Integer status;

    @SerializedName("code")
    private Integer code;

    @SerializedName("message")
    private String message;

    public List<ListResult> getResult() {
        return result;
    }

    public void setResult(List<ListResult> result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}


