package org.example.kafka

import org.example.kafka.producer.Producer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaApplicationTests {

	@Autowired
	lateinit var producer: Producer
	@Test
	fun test () {
		producer.create()

	}

}
