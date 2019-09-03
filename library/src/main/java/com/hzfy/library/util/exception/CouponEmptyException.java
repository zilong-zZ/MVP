package com.hzfy.library.util.exception;


/**
 * 优惠券为空异常
 */
public class CouponEmptyException extends Exception {
    public CouponEmptyException() {

    }

    public CouponEmptyException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public CouponEmptyException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public CouponEmptyException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "coupons is empty";
        }
        return super.getMessage();
    }
}
