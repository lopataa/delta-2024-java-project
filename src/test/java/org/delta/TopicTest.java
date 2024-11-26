package org.delta;

import org.delta.observer_mdkii.Observer;
import org.delta.observer_mdkii.Subject;
import org.delta.observer_mdkii.VeryCoolTopic;
import org.delta.observer_mdkii.VeryCoolTopicSubscriber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TopicTest {

    @Test
    void meow() {
        VeryCoolTopic veryCoolTopic = new VeryCoolTopic();

        Observer observer1 = new VeryCoolTopicSubscriber();
        Observer observer2 = new VeryCoolTopicSubscriber();
        Observer observer3 = new VeryCoolTopicSubscriber();

        veryCoolTopic.register(observer1);
        veryCoolTopic.register(observer2);
        veryCoolTopic.register(observer3);

        veryCoolTopic.postMessage("meow");
    }
}