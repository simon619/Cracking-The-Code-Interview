public class QuickSort {

    public int [] quickSortDivision(int [] arr, int left, int right) {
        
        int midIndex = this.valueSwap(arr, left, right);
        if (left < midIndex - 1) {
            this.quickSortDivision(arr, left, midIndex - 1);
        }

        if (midIndex < right) {
            this.quickSortDivision(arr, midIndex, right);
        }
        
        return arr;

    }

    public int valueSwap(int [] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left < right) {

            while(arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int [] arr = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        int [] sortedArray = obj.quickSortDivision(arr, 0, arr.length - 1);
        obj.printArray(sortedArray);
    }
    
}
