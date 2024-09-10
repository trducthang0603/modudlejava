package vm.techmaster.aop.hello;

public interface Aspect {
    void beforeMethod(String method);

    void afterMethod(String method);
}
