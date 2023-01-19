package spring;

import org.springframework.context.ApplicationEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

class CustomSpringEvent extends ApplicationEvent {
    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

@Component
class CustomSpringEventPublisher {
        public boolean published = false;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendMsg(final String message) {
        published = true;
        System.out.println("Publishing custom event. ");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}

@Component
class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    public boolean received = false;

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        received = true;
        System.out.println("Received spring custom event with interface - " + event.getMessage());
    }
}

@Component
class AnnotationDrivenEventListener {
    public boolean received = false;

    @EventListener
    public void handleContextStart(CustomSpringEvent event) {
        received = true;
        System.out.println("Received spring custom event with annotation - " + event.getMessage());
    }
}

@Component
class AListenerBean {
    public boolean received = false;

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        received = true;
        System.out.println("context refreshed event received: " + event);
    }
}
