package com.around.dev.controller.webSocket;

/**
 * Created by laurent on 01/09/2014.
 */
/*@Component
public class TestRandomDatas implements ApplicationListener<BrokerAvailabilityEvent> {
    private final MessageSendingOperations<String> messagingTemplate;

    @Autowired
    public TestRandomDatas(final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onApplicationEvent(final BrokerAvailabilityEvent event) {
    }

    @Scheduled(fixedDelay = 1000)
    public void sendDataUpdates() {

        this.messagingTemplate.convertAndSend(
                "/data", new Random().nextInt(100));

    }
}*/
