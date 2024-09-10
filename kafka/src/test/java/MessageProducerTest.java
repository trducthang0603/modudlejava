import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import vm.techmaster.kafka.producer.*;
import static org.mockito.Mockito.*;
public class MessageProducerTest  {
    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private MessageProducer messageProducer;

    public MessageProducerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendMessage() {
        // Arrange
        String topic = "techmaster";
        String message = "Hello Kafka";

        // Act
        messageProducer.sendMessage(topic, message);

        // Assert
        verify(kafkaTemplate).send(topic, message);
    }
}
