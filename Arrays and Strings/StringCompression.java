public class StringCompression {

    String stringCompression(String str) {
        if(str.length() <= 0) {
            return str.charAt(0) + "1";
        }

        int index = 0, counter = 1;
        String res = "";
        char currentChar = str.charAt(index);
        index++;

        while(index < str.length()) {
             
            if(currentChar == str.charAt(index)) {
                counter++;
            }

            else {
                res += currentChar + Integer.toString(counter);
                currentChar = str.charAt(index);
                counter = 1;
            }
            index++;
        }
        res += currentChar + Integer.toString(counter);
        return res;

    }

    public static void main(String[] args) {
        String st = "aabcccccaaa";
        StringCompression obj = new StringCompression();
        System.out.println(obj.stringCompression(st));
    }
    
}
