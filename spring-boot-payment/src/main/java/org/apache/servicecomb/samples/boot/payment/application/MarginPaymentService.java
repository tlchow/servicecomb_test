package org.apache.servicecomb.samples.boot.payment.application;

import java.math.BigDecimal;

import org.apache.servicecomb.samples.boot.payment.domain.model.MarginPayment;
import org.apache.servicecomb.samples.boot.payment.port.persistence.repository.MarginPaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class MarginPaymentService {
	private MarginPaymentRepository resp;
	
	public void fundIn(String casaAcc, String marginAcc, BigDecimal amount) {
		MarginPayment payment = new MarginPayment(casaAcc, marginAcc, amount, "IN");
		resp.save(payment);
	}

	public void fundOut(String casaAcc, String marginAcc, BigDecimal amount) {
		MarginPayment payment = new MarginPayment(casaAcc, marginAcc, amount, "OUT");
		resp.save(payment);
	}
}
