public class URLify {
    
    public char[] urlIfy(char[] ch, int trueLenght) {
        int index, numberOFNull = 0;
        for (int i = 0; i < trueLenght; i++) {
            if(ch[i] == ' ') {
                numberOFNull++;
            }
        }
        
        index = trueLenght + numberOFNull * 2;
        for(int i = trueLenght - 1; i >= 0;  i--) {
            if(ch[i] == ' ') {
                ch[index - 1] = '0';
                ch[index - 2] = '2';
                ch[index - 3] = '%';
                index -= 3;
            }

            else{
                ch[index - 1] = ch[i];
                index--;
            }
        }

        return ch;

    }

    public static void main(String[] args) {
        String s = "I HIT YOU    ";
        char c[] = s.toCharArray();
        URLify obj = new URLify();
        System.out.println(obj.urlIfy(c, 9)); 
    }
}
