package VirenSir.Bank.products.impl;

import VirenSir.Bank.products.def.NoRiskProduct;
import VirenSir.Bank.products.def.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Teir1Capitial extends NoRiskProduct {
	
	private double GBPValue;
	private final ProductType productType = ProductType.ASSET;
	

}
