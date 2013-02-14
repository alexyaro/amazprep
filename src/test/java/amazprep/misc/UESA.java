package amazprep.misc;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by illia
 * 04.02.13 at 19:50
 */
public class UESA {

    @Test
    public void testGeneralWorkability(){
        UnrepeatedElementInSortedArray aas = new UnrepeatedElementInSortedArray();
        int [] arr = {15, 1,1,3,3,45,45,221,221,-2234,-2234,15,15,423,423,3, 3};
        Integer result = aas.seekArr(arr);
        Integer expected = 15;
        assertEquals("not catch first element", expected, result);
        //-----------------------------------------------------------------------------------
        arr = new int[] {1,1,3,3,45,45,221,221,-2234,-2234,15,15,423,423,3};
        result = aas.seekArr(arr);
        expected = 3;
        assertEquals("not catch last element", expected, result);
        //------------------------------------------------------------------------------------
        arr = new int[] {1,1,3,3,45,45,221,3,221,-2234,-2234,15,15,423,423};
        result = aas.seekArr(arr);
        expected = 3;
        assertEquals("not catch kinda-mid element", expected, result);
        //------------------------------------------------------------------------------------
        arr = new int[] {1,1,3,3,45,45,221,221,-2234,-2234,15,15,423,423};
        result = aas.seekArr(arr);
        assertNull("wrong even - size array handling", result);
        //------------------------------------------------------------------------------------
        arr = null;
        result = aas.seekArr(arr);
        assertNull("wrong null array handling", result);
        //------------------------------------------------------------------------------------
        arr = new int[] {};
        result = aas.seekArr(arr);
        assertNull("wrong zero - size array handling", result);

    }

}
