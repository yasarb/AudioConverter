package com.ysrbdlgn.audioconverter.common.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public interface EventBus {

    void fireEvent(Event event);

    <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler);
    <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler);

}
