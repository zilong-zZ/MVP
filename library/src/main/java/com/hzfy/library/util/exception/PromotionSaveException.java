package com.hzfy.library.util.exception;


/**
 * 促销信息保存异常
 */
public class PromotionSaveException extends Exception {
    public PromotionSaveException() {

    }

    public PromotionSaveException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public PromotionSaveException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public PromotionSaveException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "save promotion failure";
        }
        return super.getMessage();
    }
}
