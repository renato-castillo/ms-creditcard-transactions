package com.bootcamp.creditcard.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCreditcardTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditcardTransactionsApplication.class, args);
	}

}
