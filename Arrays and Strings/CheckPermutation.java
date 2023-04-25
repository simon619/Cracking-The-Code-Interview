public class CheckPermutation {

    public boolean checkingPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int [] checker = new int[128];
        for(int i = 0; i < str1.length(); i++) {
            checker[(int) str1.charAt(i)]++;
        }

        for(int i = 0; i < str2.length(); i++) {
            int n = (int) str2.charAt(i);
            checker[n]--;
            if (checker[n] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String st1 = "SIMON";
        String st2 = "MNSOK";
        CheckPermutation obj = new CheckPermutation();
        boolean flag = obj.checkingPermutation(st1, st2);
        System.out.println(flag);
    }
    
}
