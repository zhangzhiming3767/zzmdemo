package com.example.zzmdemo.core.response;

public class FailedResponse implements Response {
	private String code;
	private String msg;

	public FailedResponse() {
		this.code = "-1";
		this.msg = "failed";
	}

	
	public FailedResponse(String msg) {
		this.code = "-1";
		this.msg = msg;
	}
	public FailedResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
}
