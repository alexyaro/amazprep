package amazprep.count1BitsInInt;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 1/16/13
 * Time: 1:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    // runtime is linear
    public static int countOneBitsByShift(int number) {
        int counter = 0;
        while (number != 0) {
            if ((1 & number) == 1) {
                counter++;
            }
            number >>>= 1; // sign shift
        }
        return counter;
    }

    // do it faster.
    // hint: runtime in number of 1-es
    public static int countOneBitsFaster(int number) {
        number = number - ((number >> 1) & 0x55555555);
        number = (number & 0x33333333) + ((number >> 2) & 0x33333333);
        return (((number + (number >> 4))&0x0F0F0F0F)*0x01010101) >> 24;
    }



}
