package com.pms;

import java.util.List;

public class ProductServiceImp implements IProductService{

	private	ProductDAO  dao = new ProductDAO();
	@Override
	public int addProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.addProd(prod);
	}

	@Override
	public int updateProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.updateProd(prod);
	}

	@Override
	public int deleteProdById(int pid) {
		// TODO Auto-generated method stub
		return dao.deleteProdById(pid);
	}

	@Override
	public Product getProdById(int pid) {
		// TODO Auto-generated method stub
		return dao.getProdById(pid);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	
	}

