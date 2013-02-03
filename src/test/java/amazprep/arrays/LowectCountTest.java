package amazprep.arrays;

import org.junit.Test;

/**
 * by illia
 */
public class LowectCountTest {

    @Test
    public void lowestNumberTest(){
        LowestCountOfElementsInArray L = new LowestCountOfElementsInArray();
        int [] arr = {1,2,3,4,5,5,3,4,2,2,3,1,3,4,4,2,2,3,3,4,3,3,2,2,2,1,1,2,2,3,4,4,3,2,2,1,1,2,3,3,2,2,1,1,1,4,3,
        4,3,2,2,4,4,3,2,2,1,2,3,4,3,2,3,1,3,4,5,3,3,2,1,2,5,5,5,5,5,5,5,5,5};
        int number = L.lowerNumberSeeker(arr);
        System.out.println(number);
    }
}
