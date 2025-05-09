package umc.spring.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;

public class ReviewHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public ReviewHandler(ErrorStatus status) {
        super(status.getMessage());
        this.errorStatus = status;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}