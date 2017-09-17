package com.service;

import java.util.ArrayList;

import com.dao.ProductDao;
import com.model.ProductBean;

public class Service {

	
	public ArrayList<ProductBean> viewItems(String s)
	{
		ProductDao d = new ProductDao();
		ArrayList<ProductBean> pb = new ArrayList<>();
		pb = d.viewItems(s);
		return pb;
	}

	public ProductBean getProduct(int s1) {
		// TODO Auto-generated method stub
		ProductDao d = new ProductDao();
		ProductBean a = d.getProduct(s1);
		return a;
	}

	public boolean delProduct(int s1) {
		// TODO Auto-generated method stub
		ProductDao d = new ProductDao();
		boolean flag = d.delProduct(s1);
		return flag;
	}
}
