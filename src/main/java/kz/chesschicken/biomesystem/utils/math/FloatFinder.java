package kz.chesschicken.biomesystem.utils.math;

public class FloatFinder {
    public static float fastNearestFloat(Float[] array, float x)
    {
        float value = array[0];
        float sr = Math.abs(value - x);

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i] - x) < sr) {
                sr = Math.abs(array[i] - x);
                value = array[i];
            }
        }

        return value;
    }
}
