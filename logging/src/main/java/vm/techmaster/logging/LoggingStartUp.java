package vm.techmaster.logging;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingStartUp {
    private static final Logger log = LoggerFactory.getLogger(LoggingStartUp.class);
    public static void main(String[] args) {
        log.info("hello world");
    }
}