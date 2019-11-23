package com.template.model;

public class TicketMalformedException extends IllegalArgumentException {

    public TicketMalformedException(String msg) {
        super(msg);
    }

    public TicketMalformedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
