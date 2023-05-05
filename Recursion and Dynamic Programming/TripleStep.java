public class TripleStep {

    static int countStep(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        else {
            return countStep(n - 1) + countStep(n - 2) + countStep(n - 3);
        }
    }

    public static void main(String[] args) {
        int x = countStep(8);
        System.out.println(x);
    }
}