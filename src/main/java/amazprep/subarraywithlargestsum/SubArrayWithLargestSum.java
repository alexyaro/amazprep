package amazprep.subarraywithlargestsum;

public class SubArrayWithLargestSum {

    private int startingIndex;
    private int endIndex;
    private int sum;

    public void searchForSum(int [] array){
        int [][] computArray = new int[array.length][2];
        computArray[0][1] = array[0];
        for(int i = 1; i < array.length; i++){
            if(computArray[i - 1][1] > 0){
                computArray[i][0] = computArray[i - 1][0];
                computArray[i][1] = computArray[i - 1][1] + array[i];
            } else {
                computArray[i][0] = i;
                computArray[i][1] = array[i];
            }
        }

        sum = computArray[0][1];
        startingIndex = 0;
        endIndex = 0;
        for(int i = 1; i < array.length; i++){
            if(computArray[i][1] > sum){
                sum = computArray[i][1];
                startingIndex = computArray[i][0];
                endIndex = i;
            }
        }
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getSum() {
        return sum;
    }
}
