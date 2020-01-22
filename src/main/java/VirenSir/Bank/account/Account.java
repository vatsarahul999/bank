package VirenSir.Bank.account;

import java.util.List;

import VirenSir.Bank.products.def.Product;


public interface Account {
	
	public List<Product> getProducts();
	
	public AccountType getAccountType();
	
	public double getTotalValue();
	
	public void addProduct(Product product);

}
