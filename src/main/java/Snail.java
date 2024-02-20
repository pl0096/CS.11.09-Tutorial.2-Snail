import java.util.Arrays;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if(array2d == null){
            return new int[0];
        }
        if(!isPerfectSquare(array2d)){
            return new int[0];

        }

        int side = array2d.length;
        int[] array1d = new int[side * side];
        int idx = 0;
        int side1 = 0;
        int side2 = 0;
        while(true) {
            for (int i = 0; i < side; i++) {
                array1d[idx] = array2d[side1][side2];
                side2++;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1++;
            side2--;
            side--;
            for(int i = 0; i < side; i++){

                array1d[idx] = array2d[side1][side2];
                side1++;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1--;
            side2--;
            for (int i = 0; i < side; i++) {
                array1d[idx] = array2d[side1][side2];
                side2--;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1--;
            side2++;
            side--;
            for(int i = 0; i < side; i++){
                array1d[idx] = array2d[side1][side2];
                side1--;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side2++;
            side1++;
        }
        print1dArray(array1d);
        return array1d;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(array1d == null){
            return new int[0][0];
        }
        if(!isPerfectSquare(array1d)){
            return new int[0][0];
        }
        int side = (int) Math.sqrt(array1d.length);
        int[][] array2d = new int[side][side];
        int idx = 0;
        int side1 = 0;
        int side2 = 0;
        while(true) {
            for (int i = 0; i < side; i++) {
                array2d[side1][side2] = array1d[idx];
                side2++;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1++;
            side2--;
            side--;
            for(int i = 0; i < side; i++){

                array2d[side1][side2] = array1d[idx];
                side1++;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1--;
            side2--;
            for (int i = 0; i < side; i++) {
                array2d[side1][side2] = array1d[idx];
                side2--;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side1--;
            side2++;
            side--;
            for(int i = 0; i < side; i++){
                array2d[side1][side2] = array1d[idx];
                side1--;
                idx++;
            }
            if(idx >= array1d.length){
                break;
            }
            side2++;
            side1++;
        }

        return array2d;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        System.out.println(Arrays.toString(array1d));
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        System.out.println(Arrays.deepToString(array2d));
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        double side = Math.sqrt(length);
        if(side == (int) side){
            return true;
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int length1 = array2d.length;
        int length2 = array2d[0].length;
        if(length1 != length2){
            return false;
        }
        for(int[] i : array2d){
            if(i.length != length2){
                return false;
            }
        }

        return true;
    }


}
