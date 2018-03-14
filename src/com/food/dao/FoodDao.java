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


@Service @Transactional
public class FoodDao {
	@Resource SessionFactory factory;
	
	 /*添加Food信息*/
    public void AddFood(Food food) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(food);
    }
    
    /*删除Food信息*/
    public void DeleteFood (Integer foodId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object food = s.load(Food.class, foodId);
        s.delete(food);
    }
    
    /*更新Food信息*/
    public void UpdateFood(Food food) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(food);
    }
    
    /*查询所有Food信息*/
    public ArrayList<Food> QueryAllFood() {
        Session s = factory.getCurrentSession();
        String hql = "From Food";
        Query q = s.createQuery(hql);
        List foodList = q.list();
        return (ArrayList<Food>) foodList;
    }

    /*根据主键获取对象*/
    public Food GetFoodById(Integer foodid) {
        Session s = factory.getCurrentSession();
        Food food = (Food)s.get(Food.class, foodid);
        return food;
    }
    
    /*根据查询条件查询*/
    public ArrayList<Food> QueryFoodInfo(String foodname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Food food where 1=1";
    	if(!foodname.equals("")) hql = hql + " and food.foodname like '%" + foodname + "%'";
    	Query q = s.createQuery(hql);
    	List foodList = q.list();
    	return (ArrayList<Food>) foodList;
    }

}
