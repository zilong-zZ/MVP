package com.hzfy.library.util.exception;


/**
 * 商品查询异常
 */
public class ProductSelectException extends Exception {
    public ProductSelectException() {

    }

    public ProductSelectException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ProductSelectException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public ProductSelectException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "商品查询失败";
        }
        return super.getMessage();
    }
}
