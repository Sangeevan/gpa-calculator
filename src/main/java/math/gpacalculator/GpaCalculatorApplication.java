package math.gpacalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GpaCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpaCalculatorApplication.class, args);
	}

	@GetMapping("/calculate-gpa")
    public String calculateGpa() {
      return String.format("GPA Calculator");
    }

}
