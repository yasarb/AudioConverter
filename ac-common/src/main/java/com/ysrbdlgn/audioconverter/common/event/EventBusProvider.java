package com.ysrbdlgn.audioconverter.common.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public class EventBusProvider implements EventBus {

    public Group group = new Group();

    @Override
    public void fireEvent(Event event) {
        System.out.println("Firing event: " + event);
        group.fireEvent(event);
    }

    @Override
    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        group.addEventHandler(eventType, eventHandler);
    }

    @Override
    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        group.removeEventHandler(eventType, eventHandler);
    }
}
