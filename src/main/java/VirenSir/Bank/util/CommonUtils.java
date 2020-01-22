package VirenSir.Bank.util;

import java.util.Collection;

import VirenSir.Bank.account.Account;
import VirenSir.Bank.balancesheet.Bank;
import VirenSir.Bank.products.def.Product;
import VirenSir.Bank.products.def.ProductType;

public class CommonUtils {

	public static double getTotalValue(Collection<Product> pdts) {
		double totalValue = 0;
		for (Product product : pdts) {
			if (product.getProductType().equals(ProductType.ASSET))
				totalValue += product.getGBPValue();
			else
				totalValue -= product.getGBPValue();
		}
		return totalValue;

	}

	public static double getSimpleRiskWeightedAssets(Bank bank) {
		double res = 0;
		for (Account acct : bank.getAccounts()) {
			for (Product product : acct.getProducts()) {
				res += (product.getGBPValue() - (product.getGBPValue() * .05) * product.getGBPValue());

			}
		}
		return res;
	}

}
