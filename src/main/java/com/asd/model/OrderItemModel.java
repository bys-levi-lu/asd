package com.asd.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "ORDER_ITEM", uniqueConstraints = { @UniqueConstraint(columnNames = {"ORDER_NO"}) })
public class OrderItemModel
{
	@Column(name="ORDER_NO")
	private Integer orderNo;
	
	@Column(name="ORDER_DESC")
	private String orderDesc;
	
	@Column(name="ORDER_ADDRESS")
	private String orderAddress;
	
	@Column(name="ORDER_PHONE")
	private String orderPhone;

	public Integer getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(Integer orderNo)
	{
		this.orderNo = orderNo;
	}

	public String getOrderDesc()
	{
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc)
	{
		this.orderDesc = orderDesc;
	}

	public String getOrderAddress()
	{
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress)
	{
		this.orderAddress = orderAddress;
	}

	public String getOrderPhone()
	{
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone)
	{
		this.orderPhone = orderPhone;
	}

}
