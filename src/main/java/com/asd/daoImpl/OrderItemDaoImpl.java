/**
 * Author:Administrator
 * Create time:下午2:11:04
 */
package com.asd.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asd.dao.OrderItemDao;
import com.asd.framework.QueryPageInfo;
import com.asd.framework.db.DataProccessor;
import com.asd.framework.db.JdbcSupport;
import com.asd.model.OrderItemModel;

/**
 * @author Administrator
 *
 */
@Repository
public class OrderItemDaoImpl extends JdbcSupport implements OrderItemDao, DataProccessor<OrderItemModel>
{
	public static final String SELECT_SQL = "SELECT ORDER_NO, ORDER_DESC, ORDER_ADDRESS, ORDER_PHONE FROM ORDER_ITEM";
	
	public static final String INSERT_SQL = "INSERT INTO ORDER_ITEM (ORDER_NO, ORDER_DESC, ORDER_ADDRESS, ORDER_PHONE) VALUES (?,?,?,?)";
	
	public static final String UPDATE_SQL = "UPDATE ORDER_ITEM SET (ORDER_DESC=?, ORDER_ADDRESS=?, ORDER_PHONE=?) WHERE ORDER_NO = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#getOrderItemByPk(int)
	 */
	@Override
	public OrderItemModel getOrderItemByPk(int orderNo)
	{
		StringBuilder sql = new StringBuilder(SELECT_SQL);
		sql.append(" WHERE ORDER_NO = ?");
		List<OrderItemModel> list = select(sql.toString(), new Object[]{orderNo}, this);
		if (list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#getOrderItemByAddress(java.lang.String)
	 */
	@Override
	public List<OrderItemModel> getOrderItemByAddress(String address)
	{
		StringBuilder sql = new StringBuilder(SELECT_SQL);
		sql.append(" WHERE ORDER_ADDRESS LIKE ?");
		return select(sql.toString(), new Object[]{"%" + address+ "%"}, this);
	}
	
	@Override
	public List<OrderItemModel> getOrderItemByAddress(String address, QueryPageInfo pageInfo)
	{
		StringBuilder sql = new StringBuilder(SELECT_SQL);
		sql.append(" WHERE ORDER_ADDRESS LIKE ?");
		return select(sql.toString(), new Object[]{"%" + address+ "%"}, pageInfo, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#getOrderItemByDesc(java.lang.String)
	 */
	@Override
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc)
	{
		StringBuilder sql = new StringBuilder(SELECT_SQL);
		sql.append(" WHERE ORDER_DESC = ?");
		return select(sql.toString(), new Object[]{orderDesc}, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#createOrderItem(com.asd.model.OrderItemModel)
	 */
	@Override
	public int createOrderItem(OrderItemModel orderItem)
	{
		return update(INSERT_SQL, new Object[] { orderItem.getOrderNo(),
				orderItem.getOrderDesc(), orderItem.getOrderAddress(),
				orderItem.getOrderPhone() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#updateOrderItem(com.asd.model.OrderItemModel)
	 */
	@Override
	public int updateOrderItem(OrderItemModel orderItem)
	{
		return update(UPDATE_SQL, new Object[] { orderItem.getOrderDesc(),
				orderItem.getOrderAddress(), orderItem.getOrderPhone(),
				orderItem.getOrderNo() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#deleteOrderItemByPk(int)
	 */
	@Override
	public void deleteOrderItemByPk(int orderNo)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asd.dao.OrderItemDao#deleteOrderItemByAddress(java.lang.String)
	 */
	@Override
	public void deleteOrderItemByAddress(String address)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public OrderItemModel populate(ResultSet rs) throws SQLException
	{
		OrderItemModel model = new OrderItemModel();
		model.setOrderNo(rs.getInt("ORDER_NO"));
		model.setOrderDesc(rs.getString("ORDER_DESC"));
		model.setOrderAddress(rs.getString("ORDER_ADDRESS"));
		model.setOrderPhone(rs.getString("ORDER_PHONE"));
		return model;
	}

	@Override
	public List<OrderItemModel> getOrderItemByDesc(String orderDesc,
			QueryPageInfo pageInfo)
	{
		StringBuilder sql = new StringBuilder(SELECT_SQL);
		sql.append(" WHERE ORDER_DESC = ?");
		return select(sql.toString(), new Object[]{orderDesc}, pageInfo, this);
	}

}
