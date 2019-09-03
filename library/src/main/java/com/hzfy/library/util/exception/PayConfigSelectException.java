package com.hzfy.library.util.exception;


/**
 * 支付配置查询异常
 */
public class PayConfigSelectException extends Exception {
    public PayConfigSelectException() {

    }

    public PayConfigSelectException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public PayConfigSelectException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public PayConfigSelectException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "支付配置查询失败";
        }
        return super.getMessage();
    }
}
