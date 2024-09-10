package vm.techmaster.singleton.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import vm.techmaster.singleton.model.UserModel;
import vm.techmaster.singleton.service.PaymentService;
import vm.techmaster.singleton.service.UserService;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;

@Controller
public class PaymentController {

    private final UserService userService;
    private final PaymentService paymentService;
    private final ExecutorService applicationExecutorService;

    public PaymentController(
            UserService userService,
            @Qualifier("techmasterPaymentService")
            PaymentService paymentService,
            ExecutorService applicationExecutorService
    ) {
        this.userService = userService;
        this.paymentService = paymentService;
        this.applicationExecutorService = applicationExecutorService;
    }

    public void handleUserPayment(
            String username,
            BigDecimal amount
    ) {
        UserModel user = userService.getUserByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("user not found");
        }
        applicationExecutorService.execute(() ->
                paymentService.processUserPayment(
                        username,
                        amount
                )
        );
    }
}