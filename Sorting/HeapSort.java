public class HeapSort {

    public void swap(int [] arr, int val1, int val2) {
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }

    public void heapify(int [] arr, int currentPointer, int len) {
        int currentLargestPointer = currentPointer;
        int left = 2 * currentPointer + 1;
        int right = 2 * currentPointer + 2;

        if ((left < len) && (arr[currentLargestPointer] < arr[left])) {
            currentLargestPointer = left;
        }

        if ((right < len) && (arr[currentLargestPointer] < arr[right])) {
            currentLargestPointer = right;
        }

        if (currentLargestPointer != currentPointer) {
            this.swap(arr, currentLargestPointer, currentPointer);
            this.heapify(arr, currentLargestPointer, len);
        }

    }
    
    public int [] heapSort(int [] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i > -1; i--) {
            this.heapify(arr, i, len);
        }

        for (int i = len - 1; i > -1; i--) {
            this.swap(arr, 0, i);
            this.heapify(arr, 0, i);
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
        HeapSort obj = new HeapSort();
        int [] arr = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        int [] sortedArray = obj.heapSort(arr);
        obj.printArray(sortedArray);
    }


}
