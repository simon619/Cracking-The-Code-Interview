public class IsUnique {

    public boolean check(String str) {
        boolean [] checkList =  new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int charASCIIValue = str.charAt(i);
            if (checkList[charASCIIValue]) {
                return false;
            }
            checkList[charASCIIValue] = true;
        }
        return true;
    }

    public static void main(String [] args) {
        String st = "Simon";
        IsUnique obj = new IsUnique();
        boolean b = obj.check(st);
        System.out.println(b);
    }
    
}