package com.sg.kata.exception;

public class SgBusinessException extends Exception {

    public SgBusinessException(String errorMessage) {
        super(errorMessage);
    }

}