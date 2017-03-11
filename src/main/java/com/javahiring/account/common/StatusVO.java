package com.javahiring.account.common;

public class StatusVO {
	private boolean status;
	private String msg;
	public StatusVO() {
	}
	public StatusVO(boolean status) {
		this.status = status;
		if(status) {
			this.msg="SuccessFully Updated";
		} else {
			this.msg = "Failed To Update";
		}
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "StatusVO [status=" + status + ", msg=" + msg + "]";
	}
}
