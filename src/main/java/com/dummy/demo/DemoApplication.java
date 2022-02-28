package com.dummy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RestController
	class C {
		@PostMapping("/")
		public ResponseEntity<String> getStuff() {
			String body = "{\"access_token\": \"1578141871049-Aepb0E2P3YWz3jPiN0AjidEfQti0Lw\", \"token_type\": \"bearer\", \"expires_in\": 3600, \"scope\": \"*\"}";
			System.out.println("Got Request");
			return ResponseEntity.ok().headers(c -> {
				c.add("content-type", "application/json; charset=UTF-8");
				c.add("x-frame-options", "SAMEORIGIN");
				c.add("x-content-type-options", "nosniff");
				c.add("x-xss-protection", "1; mode=block");
				c.add("x-ratelimit-remaining", "299");
				c.add("x-ratelimit-used", "1");
				c.add("x-ratelimit-reset", "71");
				c.add("cache-control", "max-age=0, must-revalidate");
				c.add("x-moose", "majestic");
				c.add("accept-ranges", "bytes");
				c.add("date", "Sun, 27 Feb 2022 18:58:49 GMT");
				c.add("via", "1.1 varnish");
				c.add("set-cookie", "edgebucket=OXiitxTkDk5fDo5UpN; Domain=reddit.com; Max-Age=63071999; Path=/;  secure");
				c.add("strict-transport-security", "max-age=15552000; includeSubDomains; preload");
				c.add("server", "snooserv");
				c.add("content-length", "122");

			})
					.body(body);
		}
	}

}
