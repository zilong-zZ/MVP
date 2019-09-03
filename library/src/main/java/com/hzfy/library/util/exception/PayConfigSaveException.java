package com.hzfy.library.util.exception;


/**
 * 支付配置信息保存异常
 */
public class PayConfigSaveException extends Exception {
    public PayConfigSaveException() {

    }

    public PayConfigSaveException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public PayConfigSaveException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public PayConfigSaveException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "save payConfig failure";
        }
        return super.getMessage();
    }
}
