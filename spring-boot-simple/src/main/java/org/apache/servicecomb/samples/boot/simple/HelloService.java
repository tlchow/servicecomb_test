package org.apache.servicecomb.samples.boot.simple;

import org.apache.log4j.Logger;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestSchema(schemaId = "hello")
@RequestMapping(path = "/")
public class HelloService {
	@RequestMapping(path = "hello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(name="name") String name) {
		Logger.getLogger(HelloService.class).info("Invoke Hello with name=" + name);
		if(name.equals("timeout")) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Hello " + name;
	}
}
