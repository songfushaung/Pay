package com.cn.project.pojo;

public class ResponseBase {

	private Integer rtnCode;
	private String msg;
	private Object data;

	public ResponseBase() {

	}

	public ResponseBase(Integer rtnCode, String msg, Object data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}


	public Integer getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(Integer rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseBase [rtnCode=" + rtnCode + ", msg=" + msg + ", data=" + data + "]";
	}
	public static ResponseBase setResultError(Integer code,String msg) {
		return setResult(code, msg, null);
	}
	// 返回错误，可以传msg
	public static ResponseBase setResultError(String msg) {
		return setResult(StatusInfo.HTTP_RES_CODE_500, msg, null);
	}

	// 返回成功，可以传data值
	public static ResponseBase setResultSuccess(Object data) {
		return setResult(StatusInfo.HTTP_RES_CODE_200, StatusInfo.HTTP_RES_CODE_200_VALUE, data);
	}

	// 返回成功，沒有data值
	public static ResponseBase setResultSuccess() {
		return setResult(StatusInfo.HTTP_RES_CODE_200, StatusInfo.HTTP_RES_CODE_200_VALUE, null);
	}

	// 返回成功，沒有data值
	public static ResponseBase setResultSuccess(String msg) {
		return setResult(StatusInfo.HTTP_RES_CODE_200, msg, null);
	}

	// 通用封装
	public static ResponseBase setResult(Integer code, String msg, Object data) {
		return new ResponseBase(code, msg, data);
	}

}
