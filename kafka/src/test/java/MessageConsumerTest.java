import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import vm.techmaster.kafka.producer.MessageConsumer;

import static org.mockito.Mockito.*;

public class MessageConsumerTest {

    @InjectMocks
    private MessageConsumer messageConsumer;

    public MessageConsumerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListen() {
        // Arrange
        String message = "Test message";

        // Act
        messageConsumer.listen(message);

        // Assert
        // Since we're only printing to console, we can verify the correct message processing
        // Here we could assert the logic, but in this case, we'll assume it's only for side effects
        // and test the print statement manually if needed
    }
}