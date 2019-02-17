package org.apache.servicecomb.samples.boot.debit.casa.application;

import java.math.BigDecimal;

import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.springframework.stereotype.Service;

@Service
public class DebitCasaService {
	
	@Compensable(compensationMethod = "debitEC")
	public void debit(String casaAcc, BigDecimal amount) {

	}

	public void debitEC(String casaAcc, BigDecimal amount) {

	}
	
	@Compensable(compensationMethod = "creditEC")
	public void credit(String casaAcc, BigDecimal amount) {
	}
	
	public void creditEC(String casaAcc, BigDecimal amount) {

	}
}
