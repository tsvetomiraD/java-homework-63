package spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Homework63Tests {
    @Test
    public void testEventPublisher() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Init.class);

        CustomSpringEventPublisher bean = context.getBean(CustomSpringEventPublisher.class);
        assertFalse(bean.published);

        bean.sendMsg("A test message");
        assertTrue(bean.published);
    }

    @Test
    public void testEventListenerWithInterface() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Init.class);

        CustomSpringEventListener el = context.getBean(CustomSpringEventListener.class);

        CustomSpringEventPublisher bean = context.getBean(CustomSpringEventPublisher.class);
        assertFalse(el.received);

        bean.sendMsg("A test message");
        assertTrue(el.received);
    }

    @Test
    public void testEventListenerWithAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Init.class);

        AnnotationDrivenEventListener el = context.getBean(AnnotationDrivenEventListener.class);

        CustomSpringEventPublisher bean = context.getBean(CustomSpringEventPublisher.class);
        assertFalse(el.received);

        bean.sendMsg("A test message");
        assertTrue(el.received);
    }

    @Test
    public void testEventListenerContextRefreshedEvent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AListenerBean.class);
        //context.refresh();
    }
}
