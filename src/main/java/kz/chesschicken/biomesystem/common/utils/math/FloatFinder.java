package kz.chesschicken.biomesystem.common.utils.math;

public class FloatFinder {

    /**
     * A small and fast method to find nearest existing float value from an array.
     * @param array Array of floats.
     * @param x Float that need to be found.
     * @return Near value float from the array.
     */
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
