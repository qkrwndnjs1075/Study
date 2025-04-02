package org.example.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {

    @KafkaListener(topics = ["topic"], groupId = "group_1")
    fun listenGroupFoo(data: Any){
        println(data)
    }
}