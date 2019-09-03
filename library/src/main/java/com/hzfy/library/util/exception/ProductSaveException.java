package com.hzfy.library.util.exception;


/**
 * 商品保存异常
 */
public class ProductSaveException extends Exception {
    public ProductSaveException() {

    }

    public ProductSaveException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ProductSaveException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public ProductSaveException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "save product failure";
        }
        return super.getMessage();
    }
}
