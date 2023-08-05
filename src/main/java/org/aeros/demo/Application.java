package org.aeros.demo;

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

		@GetMapping("/demo/hello")
		public String hello() {
			var os = System.getProperty("os.name");
			var arch = System.getProperty("os.arch");
			var username = System.getProperty("user.name");

			return "You've hit " + username + "@" + os + "-" + arch;
		}
	}

}
