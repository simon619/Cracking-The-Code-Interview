public class BubbleSort {

    public void swap(int [] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int [] bubbleSort(int [] arr) {
       
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i- 1, i);
                    swap = true;
                }
            }
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
        int [] array = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        BubbleSort obj = new BubbleSort();
        int [] sortedArray = obj.bubbleSort(array);
        obj.printArray(sortedArray);
    }
    
}
