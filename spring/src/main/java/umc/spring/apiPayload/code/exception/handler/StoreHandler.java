package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;

public class StoreHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public StoreHandler(ErrorStatus status) {
        super(status.getMessage());
        this.errorStatus = status;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}