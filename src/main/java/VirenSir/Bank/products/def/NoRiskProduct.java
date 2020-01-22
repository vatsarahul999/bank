package VirenSir.Bank.products.def;

import lombok.Getter;

@Getter
public abstract class NoRiskProduct implements Product {
	private final int riskRating = 0;
}
