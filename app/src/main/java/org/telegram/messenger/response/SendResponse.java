package org.telegram.messenger.response;

import org.telegram.messenger.Message;

public class SendResponse extends BaseResponse {

    private Message result;

    SendResponse() {
    }

    public Message message() {
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "result=" + result +
                '}';
    }
}