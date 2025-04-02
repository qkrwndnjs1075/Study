package org.example.kafka.producer



import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component



@Component
class Producer(
    private val kafkaTemplate: KafkaTemplate<String,String>

) {
    fun create(){
        kafkaTemplate.send("topic", "hello")
    }


}