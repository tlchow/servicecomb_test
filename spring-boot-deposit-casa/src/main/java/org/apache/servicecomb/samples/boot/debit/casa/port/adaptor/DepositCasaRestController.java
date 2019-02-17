package org.apache.servicecomb.samples.boot.debit.casa.port.adaptor;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.samples.boot.debit.casa.application.DebitCasaService;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "depositCasa")
@RequestMapping(path = "/")
public class DepositCasaRestController {
	@PutMapping(path = "depositCasa/debit/{casaAcc}/{amount}")
	public boolean debit(@PathVariable(name = "casaAcc") String casaAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(DepositCasaRestController.class).info("Debit " + casaAcc + " " + amount);
		
		DebitCasaService sv = new DebitCasaService();
		sv.debit(casaAcc, amount);
		return true;
	}
	
	@PutMapping(path = "depositCasa/credit/{casaAcc}/{amount}")
	public boolean marginFundOut(@PathVariable(name = "casaAcc") String casaAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(DepositCasaRestController.class).info("Credit " + casaAcc + " " + amount);
		
		DebitCasaService sv = new DebitCasaService();
		sv.credit(casaAcc, amount);
		return true;
	}
}
