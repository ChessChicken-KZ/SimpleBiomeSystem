package kz.chesschicken.biomesystem.common.utils;

import lombok.SneakyThrows;

import java.util.Random;

public class InstanceHelper {

    /**
     * Return an instance from the class. The class must have constructor Random, int.
     * @param objectClass Class with constructor.
     * @param args Arguments.
     * @param <T> Class value/
     * @return New class instance.
     */
    @SneakyThrows
    public static <T> T generateNoiseInstance(Class<T> objectClass, Object... args) {
        return objectClass.cast(objectClass.getConstructor(Random.class, int.class).newInstance(args));
    }
}
