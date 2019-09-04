package com.tea.coffee.exception;

public class MaterialOverFlowException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MaterialOverFlowException(String exceptionMessgae) {
		super(exceptionMessgae);
	}
}
