package org.aeros.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@RestController
	public class DemoController {
		private final Logger LOG = LoggerFactory.getLogger(DemoController.class);

		@GetMapping("/api/hello")
		public String hello() throws IOException {
			LOG.info("I was hit");
			return "Hello!";
		}
	}

}
