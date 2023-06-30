public class CountingSort {

    public int findLargestValue(int [] arr) {
        
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
    
    public int [] countingSort(int [] arr) {

        int largestValue = this.findLargestValue(arr);
        int [] helperArray = new int [largestValue + 1];
        
        for (int i = 0; i < arr.length; i++) {
            helperArray[arr[i]]++;
        }

        for (int i = 1; i < helperArray.length; i++) {
            helperArray[i] = helperArray[i] + helperArray[i - 1];
        }

        int temp1 =  helperArray[0];
        for (int i = 1; i < helperArray.length; i++) {
            int temp2 = helperArray[i];
            helperArray[i] = temp1;
            temp1 = temp2;
        }

        int [] sortedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int valuePosition = helperArray[value];
            sortedArray[valuePosition] = value;
            helperArray[value]++;
        } 

        return sortedArray;
    }

    public void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int [] arr = {1, 0, 3, 1, 3, 1};
        int [] sortedArray = obj.countingSort(arr);
        obj.printArray(sortedArray);
    }

}
