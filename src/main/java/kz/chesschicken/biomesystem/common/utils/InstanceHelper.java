package kz.chesschicken.biomesystem.common.utils;

import lombok.SneakyThrows;

import java.util.Random;

public class InstanceHelper {
    @SneakyThrows
    public static <T> T generateNoiseInstance(Class<T> objectClass, Object... args) {
        return objectClass.cast(objectClass.getConstructor(Random.class, int.class).newInstance(args));
    }
}
