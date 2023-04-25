public class Fib_On {

    void printFib(int n) {
        int store [] = new int[n + 1];
        for(int i = 0; i < store.length; i++) {
            System.out.println(i + "th :" + this.fib(i, store));
        }
    }

    int fib(int n, int [] st) {
        
        if (n <= 0) {
            return 0;
        }

        else if (n == 1) {
            return 1;
        }

        st[n] = this.fib(n - 1, st) + this.fib(n - 2, st);
        return st[n]; 

    }

    public static void main(String [] args) {
        Fib_On obj = new Fib_On();
        obj.printFib(10);
    }

    
}
