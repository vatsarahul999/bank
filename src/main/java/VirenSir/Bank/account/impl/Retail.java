package VirenSir.Bank.account.impl;

import java.util.List;

import VirenSir.Bank.account.AccountType;
import VirenSir.Bank.products.def.Product;
import lombok.Getter;

@Getter
public class Retail extends AbsAccount {

	private AccountType accountType = AccountType.RETAIL;

	public Retail(List<Product> product) {
		this.products = product;
	}

}
