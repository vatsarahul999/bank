package VirenSir.Bank.account.impl;

import java.util.Arrays;
import java.util.List;

import VirenSir.Bank.account.AccountType;
import VirenSir.Bank.account.IAccounts;
import VirenSir.Bank.products.def.NoRiskProduct;
import VirenSir.Bank.products.def.Product;
import lombok.Getter;

@Getter
public class InternalAccount extends AbsAccount implements IAccounts {

	private final AccountType accountType = AccountType.INTERNAL_ACCOUNT;

	public InternalAccount(List<Product> product) {
		this.products = product;
	}

	public void addProduct(NoRiskProduct... product) {
		this.products.addAll(Arrays.asList(product));
	}


}
