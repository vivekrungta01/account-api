package com.javahiring.account.common;

public class ErrorVO {
	private String errorCode;
	private String errorMessage;
    private String errorIdentifier;
	
	public ErrorVO(String errorCode, String errorMessage, String errorIdentifier) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
        this.errorIdentifier = errorIdentifier;
	}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorIdentifier() {
        return errorIdentifier;
    }

    public void setErrorIdentifier(String errorIdentifier) {
        this.errorIdentifier = errorIdentifier;
    }
}
