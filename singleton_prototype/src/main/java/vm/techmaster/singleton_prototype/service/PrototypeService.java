package vm.techmaster.singleton_prototype.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vm.techmaster.singleton_prototype.data.Data;

@Component
@Scope("prototype")
public class PrototypeService {
    public void execute(Data data){

    }
}
