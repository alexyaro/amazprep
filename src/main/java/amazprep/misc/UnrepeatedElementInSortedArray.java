package amazprep.misc;

/**
 * we have array with sorted elements
 * each number repeats twice except one
 * find unrepeated element in this sorted array
 * Created by illia
 * 04.02.13 at 19:31
 */
public class UnrepeatedElementInSortedArray {

    public Integer seekArr(int [] arr){
        if(arr == null || arr.length < 1 || arr.length % 2 == 0){
            return null;
        }
        int arrLength = arr.length;
        if(arrLength == 1 || arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[arrLength - 1] != arr[arrLength - 2]){
            return arr[arrLength - 1];
        }
        return seek(0, arrLength - 1, arr);
    }


    private int seek(int startElement, int endElement, int [] arr){
        if(startElement == endElement){
            return arr[startElement];
        }

        int m = (startElement + endElement) / 2;

        if(arr[m] == arr[m+1]){
            if(m%2 == 0){
                return seek(m, endElement, arr);
            } else {
                return seek(startElement, m, arr);
            }
        }else if(arr[m] == arr[m-1]){
            if(m%2 == 0){
                return seek(startElement, m, arr);
            } else {
                return seek(m, endElement, arr);
            }
        } else {
            return arr[m];
        }
    }
}
