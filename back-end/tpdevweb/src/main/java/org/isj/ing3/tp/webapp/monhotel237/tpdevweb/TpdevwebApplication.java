package org.isj.ing3.tp.webapp.monhotel237.tpdevweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper")
public class TpdevwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpdevwebApplication.class, args);
	}

}
