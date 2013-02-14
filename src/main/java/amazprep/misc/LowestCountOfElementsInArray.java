package amazprep.misc;


import java.util.HashMap;
import java.util.Map;

public class LowestCountOfElementsInArray {


    /**
     * Search for lower occurance value in array
     * @param array array of integers for searching
     * @return value of lower occurence number or null if array is null or empty
     */
    public Integer lowerNumberSeeker(int [] array){
        if(array == null || array.length < 1){
            return null;
        }
        Integer currentNumberOccurence = null;
        Map<Integer, Integer> mappedNumbers = new HashMap<Integer, Integer>();
        for (int i : array) {
            currentNumberOccurence = mappedNumbers.get(i);
            mappedNumbers.put(i, currentNumberOccurence == null ? 1 : currentNumberOccurence + 1);
        }

        int lowestOccurence = 0;
        Integer lowestNumber = null;
        for (Integer number : mappedNumbers.keySet()) {
            currentNumberOccurence = mappedNumbers.get(number);
            if(lowestOccurence == 0 || lowestOccurence > currentNumberOccurence){
                lowestOccurence = currentNumberOccurence;
                lowestNumber = number;
            }
        }
        System.out.println(mappedNumbers);
        return lowestNumber;
    }
}
