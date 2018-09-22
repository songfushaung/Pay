package com.cn.project.service;

import com.cn.project.pojo.PaymentInfo;
import com.cn.project.pojo.ResponseBase;

/**
 * 支付接口
 * @author 宋付双
 *
 */
public interface PayService {
	/**
	 * 创建支付订单token
	 * @param paymentInfo
	 * @return
	 */
	public String createToken(PaymentInfo paymentInfo);
	/**
	 * 使用支付令牌查找支付信息  返回提交支付from表单元素
	 * @param payToken
	 * @return
	 */
	public ResponseBase findPayToken(String payToken);
}
