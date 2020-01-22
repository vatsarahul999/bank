package VirenSir.Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import VirenSir.Bank.account.Account;
import VirenSir.Bank.account.AccountFactory;
import VirenSir.Bank.account.AccountType;
import VirenSir.Bank.account.exception.AccountException;
import VirenSir.Bank.balancesheet.Bank;
import VirenSir.Bank.products.def.Product;
import VirenSir.Bank.products.impl.Bond;
import VirenSir.Bank.products.impl.Cash;
import VirenSir.Bank.products.impl.CollaterialisedLoan;
import VirenSir.Bank.products.impl.Teir1Capitial;
import VirenSir.Bank.util.CommonUtils;

public class App {
	public void modelBank() {

		List<Account> accounts = new ArrayList<Account>();
		getInternalAccountFor10Billion(accounts);
		getInternalAccountFor10Loans(accounts);
		getInternalAccountFor10WholeSale(accounts);
		Bank bank = new Bank(accounts);
		System.out.println(String.format("The value of the bank  %.2f", bank.getValue()));
		System.out.println(
				String.format("The value of the bank srwa  %.2f", CommonUtils.getSimpleRiskWeightedAssets(bank)));

	}

	private void getInternalAccountFor10WholeSale(List<Account> accounts) {

		for (int i = 0; i < 10; i++) {
			List<Product> pdt = new ArrayList<Product>();
			Product loan = Cash.builder().GBPValue(ThreadLocalRandom.current().nextDouble(10000d, 100000d)).build();
			Product bonds = Bond.builder().GBPValue(ThreadLocalRandom.current().nextDouble(10000d, 100000d)).build();
			Product bond2 = Bond.builder().GBPValue(ThreadLocalRandom.current()
					.nextDouble((35000d - loan.getGBPValue() - bonds.getGBPValue()), 100000d)).build();
			pdt.add(loan);
			pdt.add(bonds);
			pdt.add(bond2);

			Account internalAccount = null;
			try {
				internalAccount = AccountFactory.getAccount(AccountType.WHOLE_SALE, pdt);
			} catch (AccountException e) {
				System.out.println("Could not create account : " + e.getMessage());
			}
			if (internalAccount != null)
				accounts.add(internalAccount);
		}

	}

	private void getInternalAccountFor10Loans(List<Account> accounts) {
		List<Product> pdt = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product loan = CollaterialisedLoan.builder()
					.GBPValue(ThreadLocalRandom.current().nextDouble(100000d, 200000d)).build();
			pdt.add(loan);
		}
		Account internalAccount = null;
		try {
			internalAccount = AccountFactory.getAccount(AccountType.INTERNAL_ACCOUNT, pdt);
		} catch (AccountException e) {
			System.out.println("Could not create account : " + e.getMessage());
		}
		if (internalAccount != null)
			accounts.add(internalAccount);

	}

	private void getInternalAccountFor10Billion(List<Account> accounts) {
		Product tierCapital = Teir1Capitial.builder().GBPValue(10000000000d).build();
		Account internalAccount = null;
		try {
			internalAccount = AccountFactory.getAccount(AccountType.INTERNAL_ACCOUNT, Arrays.asList(tierCapital));
		} catch (AccountException e) {
			System.out.println("Could not create account : " + e.getMessage());
		}
		if (internalAccount != null)
			accounts.add(internalAccount);
	}

	public static void main(String[] args) {
		App app = new App();
		app.modelBank();
	}
}
