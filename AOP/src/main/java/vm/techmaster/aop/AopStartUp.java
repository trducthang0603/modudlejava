package vm.techmaster.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import vm.techmaster.aop.controller.UserController;
import vm.techmaster.aop.performance.PerformanceManager;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = "vm.techmaster.aop")
@EnableAspectJAutoProxy
public class AopStartUp {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                        "vm.techmaster.aop"
                );
        UserController userController = applicationContext.getBean(UserController.class);
        userController.updateBalance(
                "Dzung",
                BigDecimal.ZERO
        );
        userController.updateProfile("Dzung", "dung@techmaster.vn");
        PerformanceManager performanceManager = applicationContext
                .getBean(PerformanceManager.class);
        System.out.println(performanceManager.getSummary());
    }
}
