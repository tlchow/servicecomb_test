package org.apache.servicecomb.samples.boot.securities.margin.port.adaptor;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.samples.boot.securities.margin.application.FundService;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "securitiesMargin")
@RequestMapping(path = "/")
public class FundRestController {
	@PutMapping(path = "securitiesMargin/debit/{marginAcc}/{amount}")
	public boolean fundIn(@PathVariable(name = "marginAcc") String marginAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(FundRestController.class).info("Debit " + marginAcc + " " + amount);
		
		FundService sv = new FundService();
		sv.fundIn(marginAcc, amount);
		return true;
	}
	
	@PutMapping(path = "depositCasa/credit/{marginAcc}/{amount}")
	public boolean fundOut(@PathVariable(name = "marginAcc") String marginAcc, 
			@PathVariable(name = "amount")  @NumberFormat(pattern="#0.00") BigDecimal amount) {
		Logger.getLogger(FundRestController.class).info("Credit " + marginAcc + " " + amount);
		
		FundService sv = new FundService();
		sv.fundOut(marginAcc, amount);
		return true;
	}
}
