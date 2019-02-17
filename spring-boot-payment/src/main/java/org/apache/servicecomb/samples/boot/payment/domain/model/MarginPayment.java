package org.apache.servicecomb.samples.boot.payment.domain.model;

import java.math.BigDecimal;

public class MarginPayment {
	public MarginPayment(String casaAcc, String marginAcc, BigDecimal amount, String type) {
		super();
		this.casaAcc = casaAcc;
		this.marginAcc = marginAcc;
		this.amount = amount;
		this.type = type;
	}
	@Override
	public String toString() {
		return "MarginPayment [casaAcc=" + casaAcc + ", marginAcc=" + marginAcc + ", amount=" + amount + ", type="
				+ type + "]";
	}
	private String casaAcc;
	private String marginAcc;
	private BigDecimal amount;
	private String type;
}
