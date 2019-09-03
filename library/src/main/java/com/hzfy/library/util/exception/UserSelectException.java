package com.hzfy.library.util.exception;


/**
 * 用户查询异常
 */
public class UserSelectException extends Exception {
    public UserSelectException() {

    }

    public UserSelectException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public UserSelectException(String exceptionMessage, Throwable throwable) {
        super(exceptionMessage, throwable);
    }

    public UserSelectException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return "用户查询失败";
        }
        return super.getMessage();
    }
}
