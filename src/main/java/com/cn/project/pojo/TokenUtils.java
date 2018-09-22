package com.cn.project.pojo;

import java.util.UUID;

public class TokenUtils {

	public static String getMemberToken() {
		return StatusInfo.TOKEN_MEMBER + "-" + UUID.randomUUID();
	}
    /**
     * 生成支付token
     * @return
     */
	public static String getPayToken() {
		return StatusInfo.TOKEN_PAY + "-" + UUID.randomUUID();
	}
}
