package org.aeros.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@RestController
	public class DemoController {
		private final Logger LOG = LoggerFactory.getLogger(DemoController.class);

		@GetMapping("/demo/hello")
		public String hello() throws IOException {
			var os = execReadToString("hostname").trim();
			var arch = System.getProperty("os.arch");
			var username = System.getProperty("user.name");

			LOG.info("{}@{}-{} was hit", username, os, arch);
			return "Hello!";
		}
	}

	public static String execReadToString(String execCommand) throws IOException {
		try (Scanner s = new Scanner(Runtime.getRuntime().exec(execCommand).getInputStream()).useDelimiter("\\A")) {
			return s.hasNext() ? s.next() : "";
		}
	}

}
