package vm.techmaster.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vm.techmaster.singleton.controller.PaymentController;
import vm.techmaster.singleton.service.PaymentService;

import java.math.BigDecimal;

public class SingletonStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        "vm.techmaster.singleton"
                );
        PaymentController paymentController = applicationContext
                .getBean(PaymentController.class);
        paymentController.handleUserPayment("thang", BigDecimal.valueOf(200000));
        PaymentService paymentService = applicationContext
                .getBean("youngMonkeysPaymentService", PaymentService.class);
    }
}
