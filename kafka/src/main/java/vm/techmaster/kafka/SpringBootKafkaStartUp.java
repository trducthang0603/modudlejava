package vm.techmaster.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vm.techmaster.kafka.producer.MessageProducer;

@SpringBootApplication
public class SpringBootKafkaStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
                .run(SpringBootKafkaStartUp.class);
        MessageProducer messageProducer = applicationContext
                .getBean(MessageProducer.class);
        messageProducer.sendMessage("techmaster", "Hello Techmaster");
    }
}
