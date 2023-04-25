public class PowerOfTwo {

    int powerOfTwo(int n) {
        
        if (n < 0) {
            return 0;
        }

        else if (n == 1) {
            return 1;
        }

        else {
            int prev = this.powerOfTwo(n / 2);
            int number = prev * 2;
            System.out.println(number);
            return number;
        }

    }

    public static void main(String [] args) {
        PowerOfTwo obj = new PowerOfTwo();
        obj.powerOfTwo(25);
    }
    
}
