package vm.techmaster.singleton_prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vm.techmaster.singleton_prototype.data.Data;
import vm.techmaster.singleton_prototype.service.PrototypeService;
import vm.techmaster.singleton_prototype.service.SingletonService;

public class SpringSingletonPrototypeStartup {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("vm.techmaster.singleton_prototype");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            SingletonService singletonService = applicationContext.getBean(SingletonService.class);
            singletonService.execute(new Data());
        }
        long end = System.currentTimeMillis();
        System.out.println("singleton elapsed time: " + (end - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            PrototypeService prototypeService = applicationContext.getBean(PrototypeService.class);
            prototypeService.execute(new Data());
        }
        end = System.currentTimeMillis();
        System.out.println("prototype elapsed time: " + (end - start));

    }
}
