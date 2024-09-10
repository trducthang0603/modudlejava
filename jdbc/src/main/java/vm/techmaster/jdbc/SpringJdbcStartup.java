package vm.techmaster.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vm.techmaster.jdbc.entity.User;
import vm.techmaster.jdbc.entity.UserStatus;
import vm.techmaster.jdbc.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SpringJdbcStartup {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "vm.techmaster.jdbc"
                );
        UserRepository userRepository = context.getBean(
                UserRepository.class
        );

        // Fetch user by ID
        User user = userRepository.findByUsername("tvd12");
        if (user == null) {
            user = new User();
            user.setUsername("tvd12");
            user.setEmail("ta.van.dung@techmaster.vn");
            user.setPassword("hash password");
            user.setDisplayName("Dzung");
            user.setStatus(String.valueOf(UserStatus.ACTIVATED));
            LocalDateTime now = LocalDateTime.now();
            user.setCreatedAt( Timestamp.valueOf(now));
            user.setUpdatedAt( Timestamp.valueOf(now));
            userRepository.save(user);
        }
        User fetchedUser = userRepository.findByUsername("tvd12");
        System.out.println("Fetched User: " + fetchedUser);
    }
}