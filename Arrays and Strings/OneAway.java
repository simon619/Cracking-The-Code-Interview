public class OneAway {
    boolean check(String str1, String str2) {
        int checker[] = new int[128];
        int entropy = 0;
        for(int i = 0; i < str1.length(); i++) {
             checker[(int) str1.charAt(i)]++;
             entropy++;
        }

        for(int i = 0; i < str2.length(); i++) {
            if(checker[(int) str2.charAt(i)] == 1) {
                entropy--;
            }
        }

        return entropy <= 1 ? true : false; 

    }

    public static void main(String[] args) {
        String st1 = "pale", st2 = "bae";
        OneAway obj = new OneAway();
        boolean bol = obj.check(st1, st2);
        System.out.println(bol);
    }
}
