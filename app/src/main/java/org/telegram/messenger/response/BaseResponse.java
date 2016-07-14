package org.telegram.messenger.response;

public class BaseResponse {

    private boolean ok;
    private int error_code;
    private String description;

    BaseResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public int errorCode() {
        return error_code;
    }

    public String description() {
        return description;
    }

    @Override
    public String toString() {
        return "{" +
                "ok=" + ok +
                ", error_code=" + error_code +
                ", description='" + description + '\'' +
                '}';
    }
}