package vm.techmaster.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vm.techmaster.helloworld.controller.HelloWorldController;

public class HelloWorldStartUp {
    public static void main(String[] args){
        ApplicationContext applicationContext   = new AnnotationConfigApplicationContext( "vm.techmaster.helloworld") ;
        HelloWorldController helloWorldController = applicationContext.getBean(HelloWorldController.class);
        helloWorldController.handleHelloWorld();
    }
}
