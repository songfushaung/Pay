package com.cn.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.project.pojo.ResponseBase;
import com.cn.project.pojo.StatusInfo;
import com.cn.project.service.PayCallBackService;

@Controller
public class PayCallBackController {
	
	@Autowired
	private PayCallBackService callService;
	    /**
	     * 同步回调
	     * 回调后 在本url后悔携带参数 应该隐藏
	     *   1.应该回调后自己生成一个form表单 在提交到成功页面
	     * @param request
	     * @param response
	     * @throws IOException
	     */
		@RequestMapping(value = "/callBack/synCallBack")
		public void synCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=utf-8");
			//从回调地址中取出参数
			Map<String, String[]> requestParams = request.getParameterMap();
			Map<String, String> params = new HashMap<String, String>();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			PrintWriter writer = response.getWriter();
			ResponseBase synCallBack = callService.synCallBack(params);
			if (!synCallBack.getRtnCode().equals(StatusInfo.HTTP_RES_CODE_200)) {
				return;
			}

			Map data = (Map) synCallBack.getData();
			String htmlFrom = "<form name='punchout_form'"
					+ " method='post' action='http://127.0.0.1/callBack/synSuccessPage' >"
					+ "<input type='hidden' name='outTradeNo' value='" + data.get("out_trade_no") + "'>"
					+ "<input type='hidden' name='tradeNo' value='" + data.get("trade_no") + "'>"
					+ "<input type='hidden' name='totalAmount' value='" + data.get("total_amount") + "'>"
					+ "<input type='submit' value='立即支付' style='display:none'>"
					+ "</form><script>document.forms[0].submit();" + "</script>";
			writer.println(htmlFrom);
			writer.close();
		}

		// 同步回调,解决隐藏参数
		@RequestMapping(value = "/callBack/synSuccessPage", method = RequestMethod.POST)
		public String synSuccessPage(HttpServletRequest request, String outTradeNo, String tradeNo, String totalAmount) {
			request.setAttribute("outTradeNo", outTradeNo);
			request.setAttribute("tradeNo", tradeNo);
			request.setAttribute("totalAmount", totalAmount);
			return "success";
		}
	
		// 异步回调
		@ResponseBody
		@RequestMapping(value = "/callBack/asynCallBack")
		public String asynCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Map<String, String[]> requestParams = request.getParameterMap();
			Map<String, String> params = new HashMap<String, String>();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			return callService.asynCallBack(params);
		}

}
