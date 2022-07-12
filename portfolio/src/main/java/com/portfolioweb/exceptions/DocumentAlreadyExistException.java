package com.portfolioweb.exceptions;

import java.text.MessageFormat;

public class DocumentAlreadyExistException extends Exception  {
    private static final String ERROR_MESSAGE = "El documento {0} ya existe.";

    public DocumentAlreadyExistException(String documento) {
        super(MessageFormat.format(ERROR_MESSAGE,documento));
    }

}
