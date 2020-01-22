package VirenSir.Bank.balancesheet;

import java.util.List;

import VirenSir.Bank.account.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bank {

	private List<Account> accounts;

	public Bank(List<Account> accounts) {
		this.accounts = accounts;
	}

	public double getValue() {
		double bankValue = 0;
		for (Account account : accounts) {
			bankValue += account.getTotalValue();
		}
		return bankValue;
	}

}
