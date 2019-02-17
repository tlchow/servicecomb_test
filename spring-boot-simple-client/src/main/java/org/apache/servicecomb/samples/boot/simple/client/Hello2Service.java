package org.apache.servicecomb.samples.boot.simple.client;

import org.apache.log4j.Logger;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestSchema(schemaId = "hello2")
@RequestMapping(path = "/")
public class Hello2Service {
	@RpcReference(microserviceName = "spring-boot-simple", schemaId = "hello")
	private HelloInf intf;
	
	@RequestMapping(path = "hello2", method = RequestMethod.GET)
	public String sayHello(@RequestParam(name="name") String name) {
		Logger.getLogger(Hello2Service.class).info("Invoke Hello2 with name=" + name);
		String result = "";
		if(name.equals("many")) {
			Logger.getLogger(Hello2Service.class).info("Invoke Hello 100 times");
			for(int i=0; i<100; i++) {
				result = result + intf.sayHello(name);
			}
		}
		
		try {
		result = result + intf.sayHello(name);
		} catch (InvocationException e) {
			e.getCause().printStackTrace();
			return "fallback by " + e.getMessage();
		}
		if(result == null || result.equals("")) {
			return "fallback";
		} else {
			return "Hello 2 call " + result;
		}
	}
}
