package kz.chesschicken.biomesystem.utils.math;

public class FloatFinder {
    public static float findClosest(float[] array, float nearest)
    {
        int n = array.length;

        if (nearest <= array[0])
            return array[0];
        if (nearest >= array[n - 1])
            return array[n - 1];

        int i = 0;
        int j = n;
        int m = 0;

        while (i < j) {
            m = (i + j) / 2;

            if (array[m] == nearest)
                return array[m];

            if (nearest < array[m]) {
                if (m > 0 && nearest > array[m - 1])
                    return getClosest(array[m - 1], array[m], nearest);
                j = m;
            }

            else {
                if (m < n-1 && nearest < array[m + 1])
                    return getClosest(array[m], array[m + 1], nearest);
                i = m + 1;
            }
        }

        return array[m];
    }

    public static float getClosest(float f1, float f2, float f3)
    {
        if (f3 - f1 >= f2 - f3)
            return f2;
        else
            return f1;
    }

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
