package com.cor;

public class PriceHandlerFactory {

	/*
	 * 创建PriceHandler的工厂方法
	 */
	public static PriceHandler createPriceHandler() {
		PriceHandler sales = new Sales();
		PriceHandler manager = new Manager();
		PriceHandler ceo = new CEO();
		sales.setSuccesser(manager);
		manager.setSuccesser(ceo);
		return sales;
	}

}
