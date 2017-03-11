package com.javahiring.account.common;

public enum ErrorCode {
	INTERNAL_SERVER_ERROR ("INTERNAL-SERVER-ERROR", "Internal server error"),
	REQUESTED_RESOURCE_NOT_FOUND("REQUESTED-RESOURCE-NOT-FOUND","Resource not found"),
	ER_1001 ("ER-1001", "UserId Required"),
	ER_1002 ("ER-1002", "Amount Required"),
	ER_1003 ("ER-1003", "Account Not Available"),
	ER_1004 ("ER-1004", "Balance is too Low for Debited");
	
	
	private final String code;
    private final String message;
    
    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return code;
    }
}
