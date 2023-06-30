public class SelectionSort {

    public void swap(int [] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public int [] selectionSort(int [] arr) {
        int currentPointer = 0;
        while (currentPointer < arr.length) {
            for (int i = currentPointer; i < arr.length; i++) {
                if (arr[currentPointer] > arr[i]) {
                    this.swap(arr, currentPointer, i);
                }
            }
            currentPointer++;
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
        SelectionSort obj = new SelectionSort();
        int [] arr = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        int [] sortedArray = obj.selectionSort(arr);
        obj.printArray(sortedArray);
    }
}
