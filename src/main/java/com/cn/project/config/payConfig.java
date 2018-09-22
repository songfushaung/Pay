package com.cn.project.config;

import java.io.FileWriter;
import java.io.IOException;

public class payConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2016092200570181";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCottwRZ2WTjaHq0J7bb6h3N9Xu/qREF58KiGOUzA+YOA3oove4z/Q/V6pF7D8s+71FeXXE0AXyvz4hmmdmAB7+GoJLND/kHpnXTq2OxF4JJiKmInXYmQ53KPzjbOlnGyr0E5JhQU05xj+KlKcs+uzeL2/lfooP6W4ug2VngyCJBaJfbV/Aa8GhtlmyCFFhdWEU7l1RXnH83NEsxPPeLDuEipbdASoC9AvVEnv2pvo1VLbaiCOliBM5AV0L/qA3SwJ/ST5DPJ65L0y7karW3dKaqECMidhLcz6ET6JmS0SqUoKd4rZqA4dnfmj47rLEnqcIOoRp3E7lRg+lArxROKcTAgMBAAECggEBAJpdbO8zlnmx/fL13FNUT2R9Hu2j6TIwFqExd0N+jcoth3RSH6vmAUkvcai2ZntG/b8iSYHA/6BCIJvoRTDLbY/7OzmJ3edfpEyePShCPPPMA6nUH9UE/XpDc1a2oLto3R0jByya7gitfhfSuT7re2wzJQNqivHSF7DRIifajxsuIC6GttLBhjkQlzvd4VMUsrQND7U50zieygof6YAB5RVOc9TGmrbRFEaiL9nUb+LZ54w4556C7B5zqkkQbVN+aTFLZrpSTwtPuSPUR//JwK3ygHaWntrvdMSVcOg3mO0werAkZnCKJ1fbtDOKq7lhvbrvB/cs0ehNvnepnKQJjxkCgYEA6+DADamDy1Xt9wYclHcfBSo+URhhrxIwxtKWJ8hV9XbK1ydeT+sRWwXgOrEGDS7W5y2p72CnicoXu3++Z15ldW4eEcnPCCIfFElNsdtyQfc8SCFYwknhQNrwcGJ4VQLGYtdYmhLf2QXmHqd8vbIV/Kniyg5QKJW26C3bDBTXBH0CgYEAtxtZE817MGCYrLvBVIbjX/txAQgTc2haBA4wgav4MV47R8v2dJ1Rrvqjg11sqY5vdMXWUcfrwhXTeXkc4iajMdVZVVL8te7BecF3v0LJbp0DRLGSHvgjWD4//kSp96OUVroxOt27FF7XSsc23WPvQZwe1wiau7SyNMIgu4EI/s8CgYB/LgdfVm8BS6uq7VirlC7dkhFXmFXTF3PFP/ZGLPZsC0kDCO8JGC2bbmegPaKNqRumOjDOKMcsvBJfvljjUzpRPrZn0PAX6o3nWj7SDwhkGPIf0hsRZtRVK7dIYU+QRpbA5GuZZ2PamBujm5rejQ7d1Ju7ZkxCFbcxKMhak0H74QKBgDO/JdBj3LGSSvNd6EgUCsQAUjJBbwXJcs78l5a929lP0R78ND1GjGQP7w/b4i6U00jD9EqOXkEuW+JTaOc8lhgqPCHR3xsnS0Q2ebnyjOyWsOrD6BCafZqdlQYtr38Nmolb+zewnAMovl0iqY2thVscXNbWVqw/Z7FjP07eK4WfAoGBAKbnBWy8OkfrLwI+0qLvGOb7KXgz7Nl8ok/I5D50cfJ1YhDyjZVu3nSV8A7Fa1FtKu3iN1Fv4ElhbRnsQ9/lH+mtI54zkT12sRcdmssobudp2nDk+cfY+NdtcNrhPOYlJIrYumuVIhqCDqc7lUtEm66JYCPe0+Qq1Rxz5z4mEvOd";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyMchDD79VwwUJ9WdvC+Hyz4uG6mSah+QUQ1QDaaz8hL+luQMO0g20lTa8mF+fWBPyGX8ad1WfkteeJlvAIzOEHyPVNUIYlFETK15ChF3u+wGY5WtjFeeC4lt7W3Zb9/+pFY7aLFsk+QBD+Fym5/uHoLg1rdMI1KozbiosYTsZR0dN0fdbMB7BaJRI4fsxQWVNOd5sM2VvyHpBvsFYk5RelZ1Z284wUeTFpsgMSexETr/+q4UkLLRerPhTRxR/Rri4UUumBJamPFmgTixvE+q/F3pdqo7c7lWw7TFs6jzEacqgJovT6LHJo29MA7uj1kcu5n0LQmuSXZ3/cBu0YcaMwIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://0806.free.idcfengye.com/callBack/asynCallBack";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String return_url = "http://0806.free.idcfengye.com/callBack/synCallBack";

		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		
		// 支付宝网关
		public static String log_path = "C:\\";
		 /** 
	     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	     * @param sWord 要写入日志里的文本内容
	     */
	    public static void logResult(String sWord) {
	        FileWriter writer = null;
	        try {
	            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
	            writer.write(sWord);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (writer != null) {
	                try {
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
