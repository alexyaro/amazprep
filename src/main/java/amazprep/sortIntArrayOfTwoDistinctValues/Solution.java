package amazprep.sortIntArrayOfTwoDistinctValues;

public class Solution {
    public static void sortInTwoPasses(int[] a) {
        if(a == null || a.length <= 1) {
            return;
        }

        int i = a.length - 1;
        int min = a[i];
        // only two elements in the array: max and min, so find first min
        while (i > 0) {
            if (a[i] < min) {
                min = a[i];
                i = 0;
            } else if (a[i] > min) {
                i = 0;
            } else {
                i--;
            }
        }

        // i == 0, was not checked in the previous loop. So if first element is the min then it is the only one min and array is sorted. Expl: 0,1,1,1,1
        if (a[i] < min) {
            return;
        }

        for (int j = a.length - 1; i < j;) {
            if (a[i] == a[j]) {
                // use found min to determine which index to move
                if (a[i] == min) {
                    i++;
                } else {
                    j--;
                }
            } else {
                if (a[i] > a[j]) {
                    a[i] ^= a[j];
                    a[j] ^= a[i];
                    a[i] ^= a[j];
                }
                i++;
                j--;
            }
        }
    }
}
