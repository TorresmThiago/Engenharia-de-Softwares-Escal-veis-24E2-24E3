package br.infnet.edu.nota_fiscal_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotaFiscalWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotaFiscalWorkerApplication.class, args);
	}

}
