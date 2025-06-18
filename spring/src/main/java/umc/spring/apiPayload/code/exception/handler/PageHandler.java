package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;

public class PageHandler extends RuntimeException {
    public PageHandler() {
        super(ErrorStatus.INVALID_PAGE.getMessage());
    }
}