package dic;

public class ApplicationEventPublisher {
    Container container;
    protected ApplicationEventPublisher(Container container) {
        this.container = container;
    }
    public void publishEvent(ApplicationEvent event) {
        container.publishedEvents.add(event);
    }
}
