package amazprep.misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * курсеровский задание нумбер рас
 * Created by illia
 * 06.02.13 at 18:11
 */
public class Week1 {

    public static void main(String [] args){

        Week1 c = new Week1();
        int [] arr = {1,2,3,10,12,13,8,7,6,9};
       // System.out.println(arr);
        System.out.println(c.invCount(arr));
    }

    int [] reader(String filename){
        int arr [] = new int[100000];
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String curr;

            int i = 0;
            while((curr = br.readLine()) != null){
                if(i == 100000){
                    System.out.println("too long");
                    return null;
                }
                arr[i] = Integer.parseInt(curr);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return arr;
    }

    int merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

    long invCount(int[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);



        return invCount(left) + invCount(right) + merge(arr, left, right);
    }
}
