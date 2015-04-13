package com.asd.dao;

import java.util.List;

import com.asd.framework.QueryPageInfo;
import com.asd.model.OrderItemModel;

public interface OrderItemDao
{
	public OrderItemModel getOrderItemByPk(int orderNo);
	
	public List<OrderItemModel> getOrderItemByAddress(String address);
	
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc);
	
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc, QueryPageInfo pageInfo);
	
	public int createOrderItem(OrderItemModel orderItem);
	
	public int updateOrderItem(OrderItemModel orderItem);
	
	public void deleteOrderItemByPk(int orderNo);
	
	public void deleteOrderItemByAddress(String address);

	public List<OrderItemModel> getOrderItemByAddress(String address,
			QueryPageInfo pageInfo);
	
}
