package vm.techmaster.helloworld.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import vm.techmaster.helloworld.service.HelloWorldService;
@Component
public class HelloWorldController {
    private final HelloWorldService helloWorldService;
    public HelloWorldController(HelloWorldService helloWorldService){
        this.helloWorldService = helloWorldService;
    }
    public void handleHelloWorld(){
        helloWorldService.helloWorldService();
    }
}
