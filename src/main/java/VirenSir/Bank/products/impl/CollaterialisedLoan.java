package VirenSir.Bank.products.impl;

import VirenSir.Bank.products.def.Product;
import VirenSir.Bank.products.def.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CollaterialisedLoan implements Product {
	
	private double GBPValue;
	private final ProductType productType = ProductType.LIABILITY;
	private int riskRating;

}
