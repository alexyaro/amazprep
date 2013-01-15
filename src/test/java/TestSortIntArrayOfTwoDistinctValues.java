import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sortIntArrayOfTwoDistinctValues.Solution;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 1/16/13
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestSortIntArrayOfTwoDistinctValues {

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
