package VirenSir.Bank.account;

import VirenSir.Bank.products.def.NoRiskProduct;

public interface IAccounts extends Account{

	public void addProduct(NoRiskProduct... product);

}
