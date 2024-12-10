package br.com.cotiinformatica.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	/*
	 * Método para criar uma fila no servidor
	 * de mensageria do RabbitMQ
	 */
	@Bean
	Queue queue() {
		//nome da fila -> pessoas
		return new Queue("pessoas", true);
	}	
}
