package org.fundacionjala.sfdc.core;

/**
 * Class that personalize the Runtime Exception.
 */
public class MyRuntimeException extends RuntimeException {

    /**
     * Constructor for the custom Runtime Exception.
     *
     * @param e exception event.
     */
    public MyRuntimeException(Exception e) {
        super(e);
    }
}
