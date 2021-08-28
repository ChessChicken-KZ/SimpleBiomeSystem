package kz.chesschicken.biomesystem.utils.math;

public class FloatFinder {
    public static float fastNearestFloat(Float[] array, float x)
    {
        float closest_value = array[0];
        float subtract_result = Math.abs(closest_value - x);

        for (int i = 1; i < array.length; i++)
        {

            if (Math.abs(array[i] - x) < subtract_result)
            {
                subtract_result = Math.abs(array[i] - x);
                closest_value = array[i];
            }
        }

        return closest_value;
    }
}
