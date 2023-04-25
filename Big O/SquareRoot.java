public class SquareRoot {

    int squareRoot(int n, int min, int max) {
        
        if (min > max) {
            return 111;
        }
        
        int guess = (min + max) / 2;
        
        if (guess * guess == n) {
            return guess;
        }

        else if (guess * guess < n) {
            return this.squareRoot(n, guess + 1, max);
        }

        else {
            return this.squareRoot(n, min, guess - 1);
        }
        
    }

    public static void main(String [] args) {
        SquareRoot obj = new SquareRoot();
        int n = obj.squareRoot(100, 1, 100);
        System.out.println(n);
    }
    
}
