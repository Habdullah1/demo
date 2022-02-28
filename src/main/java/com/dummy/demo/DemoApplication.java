package com.dummy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class DemoApplication {

	private static Map<String, String> headersMap;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		headersMap = new HashMap<>();
		headersMap.put("content-type", "application/json; charset=UTF-8");
		headersMap.put("x-frame-options", "SAMEORIGIN");
		headersMap.put("x-content-type-options", "nosniff");
		headersMap.put("x-xss-protection", "1; mode=block");
		headersMap.put("x-ratelimit-remaining", "299");
		headersMap.put("x-ratelimit-used", "1");
		headersMap.put("x-ratelimit-reset", "71");
		headersMap.put("cache-control", "max-age=0, must-revalidate");
		headersMap.put("x-moose", "majestic");
		headersMap.put("accept-ranges", "bytes");
		headersMap.put("date", "Sun, 27 Feb 2022 18:58:49 GMT");
		headersMap.put("via", "1.1 varnish");
		headersMap.put("set-cookie", "edgebucket=OXiitxTkDk5fDo5UpN; Domain=reddit.com; Max-Age=63071999; Path=/;  secure");
		headersMap.put("strict-transport-security", "max-age=15552000; includeSubDomains; preload");
		headersMap.put("server", "snooserv");

	}


	@RestController
	class C {
		@PostMapping("/")
		public ResponseEntity<String> getStuff() {
			String body = "{\"access_token\": \"1578141871049-Aepb0E2P3YWz3jPiN0AjidEfQti0Lw\", \"token_type\": \"bearer\", \"expires_in\": 3600, \"scope\": \"*\"}";
			System.out.println("Got Request");
			return ResponseEntity.ok()
					.headers(c -> {
						headersMap.forEach(c::add);
						c.add("content-length", "122");
					})
					.body(body);
		}

		@GetMapping("/r/technology/new")
		public ResponseEntity<String> getRedditPost() {
			InputStream input = DemoApplication.class.getResourceAsStream("/demo.txt");
			StringBuilder sb = new StringBuilder();
			try {
				byte[] bytes = Objects.requireNonNull(input).readAllBytes();
				System.out.println("Number of bytes = " + bytes.length);
				for (int i = 0; i < bytes.length; i++) {
					if (i == 120 || i == 121 || i == 122 || i == 123) {
						System.out.printf("%d char is %c\n", bytes[i], (char) bytes[i]);
					}
					byte aByte = bytes[i];
					sb.append((char) aByte);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					Objects.requireNonNull(input).close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			ResponseEntity<String> body = ResponseEntity.ok()
					.headers(c -> headersMap.forEach(c::add))
					.body(sb.toString());
			System.out.println(body);

			return body;
		}
	}


}
