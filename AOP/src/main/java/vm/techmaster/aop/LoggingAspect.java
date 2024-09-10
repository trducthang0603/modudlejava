package vm.techmaster.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* vm.techmaster.aop.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "LoggingAspect: Before method "
                        + joinPoint.getSignature().getName()
                        + " execution"
        );
    }

    @After("execution(* vm.techmaster.aop.controller..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(
                "LoggingAspect: After method "
                        + joinPoint.getSignature().getName()
                        + " execution"
        );
    }
}
