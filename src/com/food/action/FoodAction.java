package com.food.action;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.FoodDao;
import com.food.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class FoodAction extends ActionSupport{
	
	 /*业务层对象*/
    @Resource FoodDao foodDao;
    
    
    private Food food;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "food")
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	private List<Food> foodList;
	
	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	/*添加Food*/
	public String addFood() throws Exception{
		
		System.out.println(food.getFoodname());
		foodDao.AddFood(food);
		return "message";
		
	}
	
	/*显示所有Food*/
    public String showFood() {
        
        foodList = foodDao.QueryAllFood();
        return "show_view";
    }

    /*显示某一Food的详细信息*/
    public String showDetail() {
    	food = foodDao.GetFoodById(food.getFoodid());
        return "detail_view";
    }
    
    /*显示food的修改项*/
    public String showEdit() throws Exception {
    	food = foodDao.GetFoodById(food.getFoodid());
        return "edit_view";
    }

    /*编辑food*/
    public String editFood() throws Exception {
    	foodDao.UpdateFood(food);
        return "edit_message";
    }
    
    /*删除Food*/
    public String deleteFood() throws Exception {
    	foodDao.DeleteFood(food.getFoodid());
        return "delete_message";
    }
    
    /*查询Food*/
    public String queryFoods() throws Exception {
    	foodList = foodDao.QueryFoodInfo(keyWords);
        return "show_view";
    }




}
