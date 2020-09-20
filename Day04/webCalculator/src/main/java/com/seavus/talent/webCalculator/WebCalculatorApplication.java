package com.seavus.talent.webCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCalculatorApplication{

	public static void main(String[] args) {

		SpringApplication.run(WebCalculatorApplication.class, args);

	}


}
//http://localhost:8080/calculate?leftOperand=10&rightOperand=6&operator=%2b
//http://localhost:8080/calculate?leftOperand=8&rightOperand=2&operator=-
