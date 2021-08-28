package kz.chesschicken.biomesystem.common.utils;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.Random;

public class InstanceHelper {
    @SneakyThrows
    public static <T> T generateNoiseInstance(Class<T> objectClass, Object... args) {
        Constructor<?> constructor = objectClass.getConstructor(Random.class, int.class);
        return objectClass.cast(constructor.newInstance(args));
    }
}
