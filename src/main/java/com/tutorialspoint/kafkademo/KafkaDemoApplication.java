package com.tutorialspoint.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("Hello-Kafka", msg);
    }
    public void sendMsg(String msg) { kafkaTemplate.send("Test", msg);}
    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       for (int i = 0; i < 10; i++) {
            sendMessage("Hi Welcome to Spring For Apache Kafka99" + '\n');
            Thread.sleep(1000);
            sendMsg("Hi Hello99" + '\n');
            Thread.sleep(1000);
        }
    }
//    @Bean
//    public NewTopic topic1(){
//        return new NewTopic("Hello-Kafka", 10, (short) 2);
//    }
}
