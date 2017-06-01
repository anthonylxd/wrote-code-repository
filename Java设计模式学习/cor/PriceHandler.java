package com.cor;

/*
 * 价格处理人，负责处理客户折扣申请
 */
public abstract class PriceHandler {
	//直接后继，用于传递请求
	protected PriceHandler successer;

	public void setSuccesser(PriceHandler successer) {
		this.successer = successer;
	}
	
	//处理折扣申请
	public abstract void processDiscount(float discount);
	
}
