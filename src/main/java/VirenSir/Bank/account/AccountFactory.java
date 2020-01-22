package VirenSir.Bank.account;

import java.util.List;

import VirenSir.Bank.account.exception.AccountException;
import VirenSir.Bank.account.exception.WholeSaleException;
import VirenSir.Bank.account.impl.InternalAccount;
import VirenSir.Bank.account.impl.Retail;
import VirenSir.Bank.account.impl.Wholesale;
import VirenSir.Bank.products.def.Product;
import VirenSir.Bank.util.CommonUtils;

public class AccountFactory {

	public static Account getAccount(AccountType accountType, List<Product> products) throws AccountException {
		switch (accountType) {
		case INTERNAL_ACCOUNT:
			return new InternalAccount(products);
		case RETAIL:
			return new Retail(products);
		case WHOLE_SALE:
			if (CommonUtils.getTotalValue(products) >= 35000) {
				return new Wholesale(products);
			}
			throw new WholeSaleException(
					"WholeSale account can not be created for products with value less than 35000");
		default:
			throw new AccountException("This account type is not recognized by the system.");
		}

	}

}
