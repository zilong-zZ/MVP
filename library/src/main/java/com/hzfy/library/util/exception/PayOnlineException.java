package com.hzfy.library.util.exception;


/**
 * 支付异常
 */
public class PayOnlineException extends Exception {
    public PayOnlineException() {

    }

    public PayOnlineException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public PayOnlineException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public PayOnlineException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "支付失败";
        }
        return super.getMessage();
    }
}
