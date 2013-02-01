package amazprep.subarraywitlargestsum;
import static org.junit.Assert.*;

import amazprep.subarraywithlargestsum.SubArrayWithLargestSum;
import org.junit.Test;

import java.util.Random;

public class TestSubArrayWithLargestSum {

    public static SubArrayWithLargestSum instance = new SubArrayWithLargestSum();

    @Test
    public void testSimpleArray(){
        int [] testArray = {1,2,3,4,5,6,6,3,4,3,42,4,234,234,5,34,534,5,546,54,6,456,45,74,56,45,645,645,7,56,7};
        int length = testArray.length - 1;
        instance.searchForSum(testArray);

        assertEquals("wrong calculating on full positive array number",length, instance.getEndIndex());
    }

    @Test
    public void testStandartArray(){
        int [] testArray = {5, -15, 20, -30, 10, 115, 26, -3, 3,55, -18, 9};
        instance.searchForSum(testArray);
        int expectedStart = 4;
        int expectedEnd = 9;
        int expectedSum = 206;

        assertEquals("calculating start index on standart array was wrong",expectedStart, instance.getStartingIndex());
        assertEquals("calculating end index on standart array was wrong",expectedEnd, instance.getEndIndex());
        assertEquals("calculating sum on standart array was wrong",expectedSum, instance.getSum());
    }

    @Test
    public void negativeArray(){
        int [] testArray = {-4, -14, -1, -44, -5, -17, -18, -3};

        instance.searchForSum(testArray);
        int expectedStart = 2;
        int expectedEnd = 2;
        int expectedSum = -1;

        assertEquals("calculating start index on negative array was wrong",expectedStart, instance.getStartingIndex());
        assertEquals("calculating end index on negative array was wrong",expectedEnd, instance.getEndIndex());
        assertEquals("calculating sum on negative array was wrong",expectedSum, instance.getSum());

    }

    @Test
    public void largeArrayNoteTheTime(){
        int [] veryLargeArray = new int[1500000];
        Random rand = new Random();
        for(int i = 0; i <veryLargeArray.length; i ++){
            veryLargeArray[i] =rand.nextInt(300) - 280;
        }

        long currentTime = System.currentTimeMillis();
        instance.searchForSum(veryLargeArray);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - currentTime)/1000.0 + " seconds");
        System.out.println(instance.getSum());
        System.out.println(instance.getStartingIndex());
        System.out.println(instance.getEndIndex());
    }
}
