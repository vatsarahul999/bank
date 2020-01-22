package VirenSir.Bank.account.impl;

import java.util.List;

import VirenSir.Bank.account.AccountType;
import VirenSir.Bank.products.def.Product;
import lombok.Getter;

@Getter
public class Wholesale extends AbsAccount {

	private AccountType accountType;

	public Wholesale(List<Product> product) {
		this.products = product;

	}

}
