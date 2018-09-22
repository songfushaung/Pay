package com.cn.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cn.project.pojo.PaymentInfo;
import com.cn.project.pojo.ResponseBase;
import com.cn.project.pojo.StatusInfo;
import com.cn.project.service.PayService;

/**
 * 支付的controller
 * @author Administrator
 *
 */
@Controller
public class PayController {
	
   @Autowired
   private PayService payService;
   @RequestMapping(value="/pay/createToken",method =RequestMethod.POST)
   @ResponseBody
   public ResponseBase newToken(@RequestBody PaymentInfo paymentInfo){
	   System.out.println(paymentInfo);
	   //根据支付信息创建token
	   String token=payService.createToken(paymentInfo);
	   JSONObject json=new JSONObject();
	   json.put("payToken", token);
	   return ResponseBase.setResultSuccess(json);
   }
    /**
     * 使用支付令牌查找支付信息
     * @param payToken
     * @param response
     * @throws IOException
     */
	@RequestMapping(value="/pay/checkTokenToForm",method =RequestMethod.GET)
	public void getPayToken(String payToken, HttpServletResponse response) throws IOException {
		//不使用工具 浏览器直接post请求
		if(payToken==null){
			payToken="2";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		// 1.参数验证
		if (StringUtils.isEmpty(payToken)) {
			return;
		}
		// 2.调用支付服务接口 获取支付宝html元素
		ResponseBase payTokenResult = payService.findPayToken(payToken);
		if (!payTokenResult.getRtnCode().equals(StatusInfo.HTTP_RES_CODE_200)) {
			String msg = payTokenResult.getMsg();
			writer.println(msg);
			return;
		}
		// 3.返回可以执行的html元素给客户端
		String payHtml = (String) payTokenResult.getMsg();
		writer.println(payHtml);
		writer.close();
		/*LinkedHashMap data = (LinkedHashMap) payTokenResult.getData();
		String payHtml = (String) data.get("payHtml");
		log.info("####PayController###payHtml:{}", payHtml);
		// 4. 页面上进行渲染
		writer.println(payHtml);*/
	}

}
