package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value={"spring"})
public class Init implements DisposableBean {
    @Bean
    public A getA(){
        return new A();
    }
    @Bean
    public AListenerBean getAl(){
        return new AListenerBean();
    }
    @Bean
    public B getB(){
        return new B();
    }

    @Bean
    public C getC(){
        return new C();
    }

    @Bean
    @Qualifier("DClass")
    public DI getD(){
        return new D();
    }

    @Bean
    @Qualifier("EClass")
    public DI getE(){
        return new E();
    }

    @Bean
    @Scope("prototype")
    public Prototype getPrototype(){
        return new Prototype();
    }

    @Bean
    public ConfigClass myConfig () {
        return new ConfigClass();
    }

    @Bean
    public ShutdownHook getShutdownHook(){
        return new ShutdownHook();
    }

    @Bean
    public StaticClass staticClass () {
        return new StaticClass();
    }

    @Bean
    public static StaticClass staticStaticClass () {
        return new StaticClass();
    }

    @Bean
    public TestStatic testStatic() {
        return new TestStatic();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed");
    }
}
