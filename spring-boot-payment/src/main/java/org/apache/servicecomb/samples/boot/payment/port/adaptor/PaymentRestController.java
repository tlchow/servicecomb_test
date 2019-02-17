package org.apache.servicecomb.samples.boot.payment.port.adaptor;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.samples.boot.payment.application.MarginPaymentService;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "payment")
@RequestMapping(path = "/")
public class PaymentRestController {
	@SagaStart
	@PostMapping(path = "payment/marginFundIn/{casaAcc}/{marginAcc}/{amount}")
	public boolean marginFundIn(@PathVariable(name = "casaAcc") String casaAcc, @PathVariable(name = "marginAcc") String marginAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(PaymentRestController.class).info("Invoke marginFundIn= fr " + casaAcc + " to " + marginAcc+  " " + amount);
		
		MarginPaymentService sv = new MarginPaymentService();
		sv.fundIn(casaAcc, marginAcc, amount);
		return true;
	}

	@SagaStart
	@PostMapping(path = "payment/marginFundOut/{casaAcc}/{marginAcc}/{amount}")
	public boolean marginFundOut(@PathVariable(name = "casaAcc") String casaAcc, @PathVariable(name = "marginAcc") String marginAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(PaymentRestController.class).info("Invoke marginFundIn= fr " + casaAcc + " to " + marginAcc+  " " + amount);
		
		MarginPaymentService sv = new MarginPaymentService();
		sv.fundOut(casaAcc, marginAcc, amount);
		return true;
	}
}
