# Pay
项目中支付宝调用的详解

支付流程 :
 请求参数提交到支付接口(项目对接支付宝是以form表单post提交),成功后通知请求,支付宝发送同步通知和异步通知,无论同步通知还是异步通知都会有结果返回封装在map中,同步通知会那参数进行加签验证 成功后将参数返回 用于页面展示
	 
	 沙箱环境的买家:yqbwir2581@sandbox.com 111111
	 
	   提交到支付接口加密方式:https 加签名(防止数据篡改) MD5 BASE64 DES SHA1 支付宝使用加签和rsa(公钥 私钥 )加密 所以要把自己
	   的解密的钥匙 把加密的钥匙给支付宝
	   
	   支付宝通知结果:包含了支付状态  为退款  支付成功 商品订单信息
	                  同步通知:用于即时通知支付完成 从支付宝的页面上重定向到自己的网站继续后续操作 会把参数展现到回调地址的url上
	                  异步通知:用于防止信息漏发漏收  用于记录  得到通知后还需要返回success支付宝收到 如果收不到会进行连接重试 
			  支付宝以httpclient更改订单状态    
	                  
	    使用支付宝RSA工具生成公钥 私钥 :将私钥保存到本地 公钥配置给支付宝
	    
	    //将订单信息与支付信息插入到支付表 成功后创建支付token 将token作为键放入缓存 支付id作为值 并返回token(目的是防止长时间
	        未支付token过期)
	    //订单号:提前生成,放到redis 在生成订单前查询一下, 用分布式job定时查看数据库订单号的数量 如果少于 一定数量就增加
       使用支付令牌查找支付信息 没过期 调用支付宝
  
  
  
-----------------------------------------------------------------------------宋付双---------联系邮箱:1113201707@qq.com
