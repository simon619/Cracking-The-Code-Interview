public class PalindromePermuation {

    boolean check(String str) {
        int checker[] = new int[128];
        int oddNumber = 0;
        for(int i = 0; i < str.length(); i++) {
            int n = str.charAt(i);
            checker[n]++;
            if (checker[n] % 2 == 1) {
                oddNumber++;
            }
            else {
                oddNumber--;
            }
        }

        return (oddNumber <= 1) ? true : false;

    }

    public static void main(String[] args) {
        String st = "taco cat".toLowerCase().replaceAll("\\s", "");
        System.out.println(st);
        PalindromePermuation obj = new PalindromePermuation();
        boolean bl = obj.check(st);
        System.out.println(bl);
    }
    
}
