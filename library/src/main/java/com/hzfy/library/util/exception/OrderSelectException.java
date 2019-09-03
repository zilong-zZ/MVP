package com.hzfy.library.util.exception;


/**
 * 订单查询异常
 */
public class OrderSelectException extends Exception {
    public OrderSelectException() {

    }

    public OrderSelectException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public OrderSelectException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public OrderSelectException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "订单查询失败";
        }
        return super.getMessage();
    }
}
