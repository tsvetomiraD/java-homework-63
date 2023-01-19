package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

    @Autowired
    public A classA;

    @Autowired
    public B classB;
    @Autowired
    public C classC;

    @Autowired
    @Qualifier("DClass")
    public DI classD;

    @Autowired
    @Qualifier("EClass")
    public DI classE;

    @Autowired
    public Prototype prototype;

    @Autowired
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor;

    @Autowired
    public ShutdownHook shutdownHook;

    @Autowired
    public MyApplication(A classA) {
        this.classA = classA;
    }

    @Autowired
    public void setA(A a) {
        this.classA = a;
    }

    public String processA(String msg){
        return this.classA.msg(msg);
    }
    public String processB(String msg){
        return this.classB.msg(msg);
    }

}