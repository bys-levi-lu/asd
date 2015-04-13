package com.asd.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.asd.dao.OrderItemDao;
import com.asd.framework.QueryPageInfo;
import com.asd.framework.db.PkGenerator;
import com.asd.model.OrderItemModel;
import com.asd.service.OrderItemService;

@Service
public class OrderItemBusiness implements OrderItemService
{
	@Resource
	private OrderItemDao dao;
	
	@Autowired
	@Qualifier(value="SingleIntegerPkGen")
	private PkGenerator pkGen;

	@Override
	public OrderItemModel getOrderItemByPk(int orderNo)
	{
		return dao.getOrderItemByPk(orderNo);
	}

	@Override
	public List<OrderItemModel> getOrderItemByAddress(String address)
	{
		return dao.getOrderItemByAddress(address);
	}
	
	@Override
	public List<OrderItemModel> getOrderItemByAddress(String address, QueryPageInfo pageInfo)
	{
		return dao.getOrderItemByAddress(address, pageInfo);
	}

	@Override
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc)
	{
		return dao.getOrderItemByDesc(orderDesc);
	}
	
	@Override
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc,
			QueryPageInfo pageInfo)
	{
		return dao.getOrderItemByDesc(orderDesc, pageInfo);
	}

	@Override
	public int createOrderItem(OrderItemModel orderItem)
	{
		orderItem.setOrderNo((Integer)pkGen.getNextPrimaryKey(OrderItemModel.class));
		return dao.createOrderItem(orderItem);
	}

	@Override
	public int updateOrderItem(OrderItemModel orderItem)
	{
		return dao.updateOrderItem(orderItem);
	}

}
