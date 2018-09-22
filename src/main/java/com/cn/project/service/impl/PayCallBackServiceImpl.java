package com.cn.project.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.cn.project.config.payConfig;
import com.cn.project.pojo.ResponseBase;
import com.cn.project.pojo.StatusInfo;
import com.cn.project.service.PayCallBackService;
@Service
public class PayCallBackServiceImpl extends ResponseBase implements PayCallBackService {
	/**
	 * 同步回调通知 根据返回参数进行签名验证
	 * @param params
	 * @return
	 */
	@Override
	public ResponseBase synCallBack(Map<String, String> params) {
		// 获取支付宝GET过来反馈信息
				try {
					System.out.println("####同步回调开始####params:"+params);
					boolean signVerified = AlipaySignature.rsaCheckV1(params, payConfig.alipay_public_key,
							payConfig.charset, payConfig.sign_type); // 调用SDK验证签名
					// ——请在这里编写您的程序（以下代码仅作参考）——
					if (!signVerified) {
						System.err.println("验签失败!");
						return setResultError("验签失败!");
					}
					// 商户订单号
					//String out_trade_no = params.get("out_trade_no");
					// 支付宝交易号
					//String trade_no = params.get("trade_no");
					// 付款金额
					//String total_amount = params.get("total_amount");
					//JSONObject data = new JSONObject();
					//data.put("out_trade_no", out_trade_no);
					//data.put("trade_no", trade_no);
					//data.put("total_amount", total_amount);
					return setResultSuccess(params);
				} catch (Exception e) {
					System.out.println("######PayCallBackServiceImpl##ERROR:#####"+e);
					return setResultError("系统错误!");
				}finally{
					System.out.println("####同步回调结束####params:"+params);
				}

	}
	/**
	 * 异步回调通知 只有俩个状态 为退款  支付成功
	 * 返回success支付宝收到 如果收不到会进行连接重试
	 * @param params
	 * @return
	 */
	@Override
	public  String asynCallBack(Map<String, String> params) {
		// 获取支付宝GET过来反馈信息
		try {
			System.out.println("####异步回调开始####params:"+params);
			boolean signVerified = AlipaySignature.rsaCheckV1(params, payConfig.alipay_public_key,
					payConfig.charset, payConfig.sign_type); // 调用SDK验证签名
			// ——请在这里编写您的程序（以下代码仅作参考）——
			if (!signVerified) {
				return StatusInfo.PAY_FAIL;
			}
			// 商户订单号
			String out_trade_no = params.get("out_trade_no");
			// 支付宝交易号
			String trade_no = params.get("trade_no");
			// 付款金额
			String total_amount = params.get("total_amount");
			/*防止重复提交(幂等性问题,就是 支付修改完成了,但后续代码出现延迟并没有及时返回 支付宝重试回调)
			     并行执行 俩次请求一起执行 这种概率很低 解决:1.方法加synchronized确保每次只执行一个 2.集群的话就是Zookeeper分布式锁
			    在查询之前zookeeper上锁
                                   先去selectBy商户订单号out_trade_no查询支付状态state
			    if(state==1){
			         return StatusInfo.PAY_SUCCESS;
		           }
			       判断接口是否被篡改 金额与数据库金额是否一致
			       不一致 标记为异常订单*/		
			
			//成功了 修改支付的数据库state支付状态字段  payMessage支付宝的报文 platformorderId支付id
			    //执行修改
			  //if(!修改失败){
			     // return StatusInfo.PAY_FAIL;
			   // }
			 //在通知订单 修改订单状态
			  
			   /**
			    * 对于事物 如果支付表修改成功 但订单修改失败,此时的事物 不一致
			    * 
			    */
			  return StatusInfo.PAY_SUCCESS;
		} catch (Exception e) {
			System.out.println("######PayCallBackServiceImpl##ERROR:#####"+e);
			 return StatusInfo.PAY_FAIL;
		}finally{
			System.out.println("####异步回调结束####params:"+params);
		}

	}

}
