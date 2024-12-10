package br.com.cotiinformatica.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.entities.Pessoa;

@Component
public class MessageProducerComponent {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private Queue queue;

	public void send(Pessoa pessoa) throws Exception {

		var json = objectMapper.writeValueAsString(pessoa);
		rabbitTemplate.convertAndSend(queue.getName(), json);
	}
}
