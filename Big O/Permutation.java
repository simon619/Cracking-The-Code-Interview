class Permutation {

    void permutation(String str, String pref) {
        if (str.length() == 0) {
            System.out.println(pref);
        }

        else {
            for(int i = 0; i < str.length(); i++) {
                String remaining = str.substring(0, i) + str.substring(i + 1);
                this.permutation(remaining, pref + str.charAt(i));
            }
        }
    }

    public static void main(String [] args) {
        String s = "saiful pagla";
        Permutation obj = new Permutation();
        obj.permutation(s, "");

    }
}