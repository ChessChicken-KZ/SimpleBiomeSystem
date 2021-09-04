package kz.chesschicken.biomesystem.common.utils.math;

public class ArraySearch {

    /**
     * A small and fast method to find nearest existing float value from an array.
     * @param array Array of floats.
     * @param x Float that need to be found.
     * @return Near value float from the array.
     */
    public static double fastNearestDouble(Double[] array, double x)
    {
        double value = array[0];
        double sr = Math.abs(value - x);

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i] - x) < sr) {
                sr = Math.abs(array[i] - x);
                value = array[i];
            }
        }

        return value;
    }

    public static double findNearestDoubleSlow(Double[] array, double d)
    {
        double distance = Math.abs(array[0] - d);
        int index = 0;

        for(int i = 1; i < array.length; i++){
            double q = Math.abs(array[i] - d);
            if(q < distance){
                index = i;
                distance = q;
            }
        }
        return array[index];
    }
}
