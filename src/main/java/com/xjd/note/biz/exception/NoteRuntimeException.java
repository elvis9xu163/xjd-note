package com.xjd.note.biz.exception;

/**
 * <pre>
 * TODO
 * </pre>
 * 
 * @author elvis.xu
 * @since 2014-1-5 下午11:37:12
 */
public class NoteRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2108212776551324516L;

    /**
     * 
     */
    public NoteRuntimeException() {
	super();
    }

    /**
     * @param message
     * @param cause
     */
    public NoteRuntimeException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * @param message
     */
    public NoteRuntimeException(String message) {
	super(message);
    }

    /**
     * @param cause
     */
    public NoteRuntimeException(Throwable cause) {
	super(cause);
    }

}
