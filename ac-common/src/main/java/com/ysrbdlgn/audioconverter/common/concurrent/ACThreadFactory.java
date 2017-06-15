package com.ysrbdlgn.audioconverter.common.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ysrbdlgn on 15-Jun-17.
 * Ref: http://fxexperience.com/2011/07/worker-threading-in-javafx-2-0/
 */
public class ACThreadFactory implements ThreadFactory {

    static final AtomicInteger poolNumber = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AudioConverter-" + poolNumber.getAndIncrement() + "-thread");
        thread.setDaemon(true);

        return thread;
    }

}