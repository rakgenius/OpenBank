package com.openbank.banking.exception;

public class BankException extends RuntimeException {
    public BankException() {
        super();
    }

    public BankException(String s) {
        super(s);
    }

    public BankException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BankException(Throwable throwable) {
        super(throwable);
    }

    protected BankException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
