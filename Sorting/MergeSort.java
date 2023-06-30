public class MergeSort {

    public int [] mergeSort(int [] unsortedArray, int left, int right) {
        if (left >= right) {
            int [] temp = {unsortedArray[left]};
            return temp;
        }

        else {
            int mid = (left + right) / 2;
            int [] leftArray = this.mergeSort(unsortedArray, left, mid);
            int [] rightArray = this.mergeSort(unsortedArray, mid + 1, right);
            return this.merging(leftArray, rightArray);
         }
    }

    public int [] merging(int [] leftArray, int [] rightArray) {
        int mergeArrayPointer = 0, leftArrayPointer = 0, rightArrayPointer = 0;
        int [] mergeArray = new int[leftArray.length + rightArray.length];

        while (leftArrayPointer < leftArray.length && rightArrayPointer < rightArray.length) {
            if (leftArray[leftArrayPointer] < rightArray[rightArrayPointer]) {
                mergeArray[mergeArrayPointer] = leftArray[leftArrayPointer];
                leftArrayPointer++;
            }
            
            else {
                mergeArray[mergeArrayPointer] = rightArray[rightArrayPointer];
                rightArrayPointer++;
            }
            mergeArrayPointer++;
        }

        while (leftArrayPointer < leftArray.length) {
            mergeArray[mergeArrayPointer] = leftArray[leftArrayPointer];
            leftArrayPointer++;
            mergeArrayPointer++;
        }

        while (rightArrayPointer < rightArray.length) {
            mergeArray[mergeArrayPointer] = rightArray[rightArrayPointer];
            rightArrayPointer++;
            mergeArrayPointer++;
        }

        return mergeArray;

    }

    public void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int [] array = {5, 2, 0, 4, 6, 1, 11, 7};
        int [] sortedArray = obj.mergeSort(array, 0, array.length - 1);
        obj.printArray(sortedArray); 
    }
    
}