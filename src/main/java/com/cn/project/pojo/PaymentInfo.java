package com.cn.project.pojo;

import java.util.Date;

public class PaymentInfo {
	private Integer id;
	/**
	 * 支付类型
	 */
	private Long typeId;
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 第三方平台支付id
	 */
	private String platformorderId;
	/**
	 * 价格 以分为单位
	 */
	private Long price;
	@Override
	public String toString() {
		return "PaymentInfo [id=" + id + ", typeId=" + typeId + ", orderId=" + orderId + ", platformorderId="
				+ platformorderId + ", price=" + price + ", source=" + source + ", state=" + state + ", payMessage="
				+ payMessage + ", userId=" + userId + ", created=" + created + ", updated=" + updated + "]";
	}
	/**
	 * 支付来源
	 */
	private String source;
	/**
	 * 支付状态 0 待支付、1支付成功 、2支付失败
	 */
	private Integer state;
	/**
	 * 支付报文
	 */
	private String payMessage;

	/**
	 * 用户userId
	 */
	private String userId;
	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 修改时间
	 */
	private Date updated;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPlatformorderId() {
		return platformorderId;
	}
	public void setPlatformorderId(String platformorderId) {
		this.platformorderId = platformorderId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPayMessage() {
		return payMessage;
	}
	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
