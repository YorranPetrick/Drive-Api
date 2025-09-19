package com.yp.DriveApi.models.exceptions;

import lombok.Getter;

@Getter
public class ResponseExceptions {

    private String message;
    private Boolean Successful;

    public ResponseExceptions(String message, Boolean successful) {
        this.message = message;
        Successful = successful;
    }

}
