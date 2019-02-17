package org.apache.servicecomb.samples.boot.securities.margin.application;

import java.math.BigDecimal;

import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.springframework.stereotype.Service;

@Service
public class FundService {
	
	@Compensable(compensationMethod = "fundInEC")
	public void fundIn(String casaAcc, BigDecimal amount) {

	}

	public void fundInEC(String casaAcc, BigDecimal amount) {

	}
	
	@Compensable(compensationMethod = "fundOut")
	public void fundOut(String casaAcc, BigDecimal amount) {
	}
	
	public void fundOutEC(String casaAcc, BigDecimal amount) {

	}
}
