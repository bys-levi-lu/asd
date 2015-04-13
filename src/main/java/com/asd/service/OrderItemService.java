/**
 * Author:Administrator
 * Create time:2015  下午2:40:47
 */
package com.asd.service;

import java.util.List;

import com.asd.framework.QueryPageInfo;
import com.asd.model.OrderItemModel;

/**
 * @author Administrator
 *
 */
public interface OrderItemService
{
	public OrderItemModel getOrderItemByPk(int orderNo);
	
	public List<OrderItemModel> getOrderItemByAddress(String address);
	
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc);
	
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc,
			QueryPageInfo pageInfo);

	public List<OrderItemModel> getOrderItemByAddress(String address,
			QueryPageInfo pageInfo);
	
	public int createOrderItem(OrderItemModel orderItem);
	
	public int updateOrderItem(OrderItemModel orderItem);

}
