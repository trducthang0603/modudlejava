package vm.techmaster.aop.controller;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class UserController {

    public void updateProfile(
            String username,
            String data
    ) throws InterruptedException { /* TODO document why this method is empty */
        Thread.sleep(3000);
    }

    public void updateBalance(
            String username,
            BigDecimal balance
    ) throws InterruptedException { /* TODO document why this method is empty */
        Thread.sleep(3000);}
}