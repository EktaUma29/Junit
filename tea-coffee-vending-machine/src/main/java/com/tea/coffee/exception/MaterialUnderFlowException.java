package com.tea.coffee.exception;

public class MaterialUnderFlowException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaterialUnderFlowException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
