package com.company.dto;

public class ResponseDto {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object obj ;


    private ResponseDto(){
        }

    public static ResponseDto of(Object obj){

        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        return resp;

    }

    public static ResponseDto of(Object obj,String successMessage){

        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        resp.setSuccessMessage(successMessage);
        return resp;

    }


    public static ResponseDto of(Object obj,Integer errorCode,String errorMessage){

        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        resp.setErrorCode(errorCode);
        resp.setErrorMessage(errorMessage);
        return resp;

    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
