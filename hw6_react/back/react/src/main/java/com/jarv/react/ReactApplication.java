package com.jarv.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication
public class ReactApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReactApplication.class, args);
	}
}

@RestController
@CrossOrigin(origins = "http://localhost:5173")
class SubmitController {
	@PostMapping("/api/submit")
	public String submitData(@RequestBody Map<String, String> data) {
		System.out.println("Отримано дані з форми (з React на 5173):");
		data.forEach((key, value) -> System.out.println(key + ": " + value));
		return "Дані отримано на сервері! (Перевірте консоль)";
	}
}