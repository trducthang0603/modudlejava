package vm.techmaster.messaging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.SubscribableChannel;
import vm.techmaster.messaging.handler.MessageConsumer;
import vm.techmaster.messaging.producer.MessageProducer;

public class MessagingStartUp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "vm.techmaster.messaging"
        );

        SubscribableChannel channel = context.getBean(SubscribableChannel.class);
        MessageConsumer handler = context.getBean(MessageConsumer.class);
        channel.subscribe(handler);

        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessage("Hello, Techmaster!");
        producer.sendMessage("Hello, Techmaster2!");
    }
}