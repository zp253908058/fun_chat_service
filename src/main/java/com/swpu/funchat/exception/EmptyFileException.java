package com.swpu.funchat.exception;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/24
 */
public class EmptyFileException extends RuntimeException {

    public EmptyFileException() {
        super("file is empty.");
    }
}
