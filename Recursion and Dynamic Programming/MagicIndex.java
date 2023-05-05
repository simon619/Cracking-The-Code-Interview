class FindMagicIndex {
    int findMagicIndex(int arr[], int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == mid) return mid;
        if(arr[mid] > mid) {
            return this.findMagicIndex(arr, left, mid - 1);
        }
        else {
            return this.findMagicIndex(arr, mid + 1, right);
        }
    }
}

public class MagicIndex {
    public static void main(String[] args) {
        FindMagicIndex obj = new FindMagicIndex();
        int arr[] = {-10, -5, 2, 0, 1, 3, 5, 7, 15};
        int x = obj.findMagicIndex(arr, 0, arr.length - 1);
        System.out.println(x);
    }
}
