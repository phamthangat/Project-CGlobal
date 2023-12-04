package com.project.CGlobal.Domain.dto;

import com.project.CGlobal.Enums.ErrorCodes;
import com.project.CGlobal.Enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BaseResDto {
    private int responseCode;
    private String responseMessage;
    private String errorCode;
    private String responseType;
    private String hexTime;
    private Object data;

    public BaseResDto(int responseCode, String responseMessage, String responseType, Object data){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseType = responseType;
        this.data = data;
    }

    public void withSuccessStatus() {
        this.responseMessage = null;
        this.errorCode = ErrorCodes.APPS_SUCCESS.name();
        this.responseType = ResponseCode.SUCCESS.name();
        this.responseCode = ResponseCode.SUCCESS.ordinal();
    }

    public void setErrorResponse(String errorCode) {
        this.errorCode = errorCode;
        this.responseMessage = ErrorCodes.APPS_FAILED.getMessage();
        this.responseType= ResponseCode.FAILED.name();
    }
}
