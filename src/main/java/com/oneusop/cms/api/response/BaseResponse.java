package com.oneusop.cms.api.response;

import java.io.Serializable;

public class BaseResponse implements Serializable{
    private static final long serialVersionUID=1L;
    private String resultCode;
    private String resultMessage;

    public BaseResponse() {
    }

    public BaseResponse(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
