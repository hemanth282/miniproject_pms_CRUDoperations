package com.pms;

import java.util.List;

public interface IProductService {

	public int addProd(Product prod);
	public int updateProd(Product prod);
	public int deleteProdById(int pid);
	public Product getProdById(int pid);
	public List<Product>  getAll();
}
