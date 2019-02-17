package org.apache.servicecomb.samples.boot.payment.port.persistence.repository;

import org.apache.log4j.Logger;
import org.apache.servicecomb.samples.boot.payment.domain.model.MarginPayment;

public class MarginPaymentRepository {
	public void save(MarginPayment payment) {
		Logger.getLogger(MarginPaymentRepository.class).info("Save Payment " + payment.toString());
	}
}
