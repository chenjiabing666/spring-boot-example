package com.zengqingfa.tx.exception;

/**
 * @fileName: MyException
 * @author: zengqf3
 * @date: 2021-7-19 11:30
 * @description:
 */
public class MyException extends RuntimeException {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
