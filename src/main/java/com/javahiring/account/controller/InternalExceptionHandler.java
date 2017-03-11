package com.javahiring.account.controller;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javahiring.account.common.ErrorCode;
import com.javahiring.account.common.ErrorVO;

public abstract class InternalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(InternalExceptionHandler.class);

	public static class ApiException extends RuntimeException {
		private static final long serialVersionUID = -6627945524259565430L;

		public ApiException(Exception exception, Map<String, String> params) {
			this.exception = exception;
			this.params = params;
		}

		private Exception exception;
		private Map<String, String> params;
	}

	public static class ApiValidationException extends RuntimeException {
		private static final long serialVersionUID = -6627945524259565430L;

		public ApiValidationException(ErrorCode errorCode, String errorMessage) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

		private ErrorCode errorCode;
		private String errorMessage;

		public ErrorCode getErrorCode() {
			return errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ApiException.class)
	@ResponseBody
	public ErrorVO handleException(ApiException e) {
		String exceptionId = UUID.randomUUID().toString();
		logger.error("Got ApiException for exceptionId :" + exceptionId, e);
		return new ErrorVO(ErrorCode.INTERNAL_SERVER_ERROR.toString(), e.exception.getMessage(), exceptionId);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorVO handleException(Exception ex) {
		String exceptionId = UUID.randomUUID().toString();
		logger.error("Got un handled exception for exceptionId :" + exceptionId, ex);
		ErrorVO error = new ErrorVO(ErrorCode.REQUESTED_RESOURCE_NOT_FOUND.toString(),
				ErrorCode.REQUESTED_RESOURCE_NOT_FOUND.getMessage(), exceptionId);
		return error;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ApiValidationException.class)
	@ResponseBody
	public ErrorVO handleValidationException(ApiValidationException e) {
		String exceptionId = UUID.randomUUID().toString();
		logger.error("Got ApiValidationException for exceptionId :" + exceptionId, e);
		return new ErrorVO(e.getErrorCode().toString(), e.getErrorMessage(), exceptionId);
	}

}
