package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.model.Customer;
import com.food.model.Food;
import com.food.model.Order;


@Service @Transactional
public class OrderDao {
	@Resource SessionFactory factory;
	
	 /*添加Order信息*/
    public void AddOrder(Order order) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(order);
    }
    
    /*删除Order信息*/
    public void DeleteOrder (Integer orderId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object order = s.load(Order.class, orderId);
        s.delete(order);
    }
    
    /*更新Order信息*/
    public void UpdateOrder(Order order) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(order);
    }
    
    /*查询所有Order信息*/
    public ArrayList<Order> QueryAllOrder() {
        Session s = factory.getCurrentSession();
        String hql = "From Order";
        Query q = s.createQuery(hql);
        List orderList = q.list();
        return (ArrayList<Order>) orderList;
    }

    /*根据主键获取对象*/
    public Order GetOrderById(Integer orderid) {
        Session s = factory.getCurrentSession();
        Order order = (Order)s.get(Order.class, orderid);
        return order;
    }
    
    /*根据查询条件查询，一般来说，订单查询时，会根据用户ID查对应的订单，或根据美食的名称查对应的订单*/
    public ArrayList<Order> QueryOrderInfo(Customer customer, Food food) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != customer && customer.getCustomerid()!=0) 
    		hql = hql + " and order.customer.customerid like '%" + customer.getCustomerid() + "%'";
    	if(null != food && null!=food.getFoodname()) 
    		hql = hql + " and order.food.foodname like '%" + food.getFoodname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }

}
