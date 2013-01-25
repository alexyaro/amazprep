package amazprep.count1BitsInInt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 1/16/13
 * Time: 1:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestCountOneBitsInInt {
    @Test
    public void countOneBitsByShift() {
        Assert.assertEquals(1, Solution.countOneBitsByShift(4));
        Assert.assertEquals(3, Solution.countOneBitsByShift(7));
        Assert.assertEquals(31, Solution.countOneBitsByShift(Integer.MAX_VALUE));
        Assert.assertEquals(1, Solution.countOneBitsByShift(Integer.MIN_VALUE));
    }

    @Test
    public void countOneBitsFaster() {
        Assert.assertEquals(1, Solution.countOneBitsFaster(4));
        Assert.assertEquals(3, Solution.countOneBitsFaster(7));
        Assert.assertEquals(31, Solution.countOneBitsFaster(Integer.MAX_VALUE));
        Assert.assertEquals(1, Solution.countOneBitsFaster(Integer.MIN_VALUE));
    }
}
