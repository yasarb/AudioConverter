package com.ysrbdlgn.audioconverter.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public enum EServiceLocator {

    INSTANCE;

    private Map<Class<?>, Class<?>> services = new HashMap<>();
    private Map<Class<?>, Object> cache = new HashMap<>();

    public <T> void registerService(Class<T> service, Class<? extends T> provider) {
        services.put(service, provider);
    }

    public <T> T getService(Class<T> type) {

        Class<?> provider = services.get(type);
        Object instance = null;

        try {
            if(cache.containsKey(type)) {
                instance = cache.get(type);
            } else {
                instance = type.cast(provider.getConstructor().newInstance());
                cache.put(type, instance);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Service is not available.");
        }

        return type.cast(instance);
    }
}
