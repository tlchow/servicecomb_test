package org.apache.servicecomb.samples.boot.securities.margin;

import org.apache.servicecomb.pack.omega.spring.EnableOmega;
import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableOmega
@EnableServiceComb
public class Application {
  public static void main(String[] args) {
      new SpringApplicationBuilder(Application.class)
      .web(WebApplicationType.NONE)
      .run(args);
  }
}
