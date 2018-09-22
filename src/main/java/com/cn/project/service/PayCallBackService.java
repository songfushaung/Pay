package com.cn.project.service;

import java.util.Map;

import com.cn.project.pojo.ResponseBase;

/**
 * 支付宝回调通知
 * @author Administrator
 *
 */
public interface PayCallBackService {
	
	/**
	 * 同步回调通知 根据返回参数进行签名验证
	 * @param params
	 * @return
	 */
	public ResponseBase synCallBack(Map<String, String> params);
	/**
	 * 异步回调通知
	 * @param params
	 * @return
	 */
	public String asynCallBack(Map<String, String> params);
}
