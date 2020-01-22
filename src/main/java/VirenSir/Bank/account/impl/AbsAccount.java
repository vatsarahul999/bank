package VirenSir.Bank.account.impl;

import java.util.List;

import VirenSir.Bank.account.Account;
import VirenSir.Bank.products.def.Product;
import VirenSir.Bank.util.CommonUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbsAccount implements Account {

	protected List<Product> products;
	protected double totalValue;

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public double getTotalValue() {
		return CommonUtils.getTotalValue(products);
	}

}
