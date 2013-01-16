package amazprep.sortIntArrayOfTwoDistinctValues;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void sortInTwoPasses() {
        int[] a = new int[] {0,1,0,0,1,1};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,0,0,1,1,1});

        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,0,0,1,1,1});

        a = new int[] {1,1,1,1,1,0};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,1,1,1,1,1});

        a = new int[] {0,1,1,1,1,1};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,1,1,1,1,1});

        a = new int[] {0,0,1,0,0};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,0,0,0,1});

        a = new int[] {1,0,1,0,1};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0,0,1,1,1});

        a = new int[] {0};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0});

        a = new int[] {1, 0};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{0, 1});

        a = new int[] {1, 1, 1};
        Solution.sortInTwoPasses(a);
        Assert.assertArrayEquals(a, new int[]{1, 1, 1});
    }

}
