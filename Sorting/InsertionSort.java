public class InsertionSort {

    public int [] insertionSort(int [] arr) {

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j = i - 1;

            while (j > -1 && currentValue < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }

        return arr;

    }

    public void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int [] arr = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        int [] sortedArray = obj.insertionSort(arr);
        obj.printArray(sortedArray);
    }

}
