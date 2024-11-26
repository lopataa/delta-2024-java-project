package org.delta.observer_mdkii;

import java.util.Collection;
import java.util.List;

public class VeryCoolTopicSubscriber implements Observer {
    public Subject subject;

    public VeryCoolTopicSubscriber() {
        this.subject = new VeryCoolTopic();
    }

    @Override
    public void update() {
        System.out.println("Message received: " + subject.getUpdate(this));
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
