import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import vm.techmaster.kafka.producer.MessageProducer;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = KafkaIntegrationTestApplication.class)
@EmbeddedKafka(partitions = 1, topics = {"techmaster"})
public class MessageConsumerIntegrationTest {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private MessageProducer messageProducer;

    private Consumer<String, String> consumer;

    @BeforeEach
    public void setUp() {
        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testGroup", "true", embeddedKafkaBroker);
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerProps);
        consumer = consumerFactory.createConsumer();
        embeddedKafkaBroker.consumeFromAnEmbeddedTopic(consumer, "techmaster");
    }

    @AfterEach
    public void tearDown() {
        consumer.close();
    }

    @Test
    void testKafkaMessageConsumption() throws Exception {
        // Arrange
        String topic = "techmaster";
        String message = "Integration Test Message";

        // Act
        messageProducer.sendMessage(topic, message);

        // Assert
        // Use KafkaTestUtils to receive the message
        ConsumerRecord<String, String> received = KafkaTestUtils.getSingleRecord(consumer, topic);
        assertThat(received.value()).isEqualTo(message);
    }

}
