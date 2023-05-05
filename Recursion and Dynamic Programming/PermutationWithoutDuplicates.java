import java.util.ArrayList;

class FindPermutations {
    
    ArrayList<String> arrayList = new ArrayList<String>(0);

    void findPermution(String str, String perf) {
        if (str.length() == 0) {
            this.arrayList.add(perf);
        }

        else {
            for(int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i) + str.substring(i + 1);
                this.findPermution(temp, perf + str.charAt(i));
            }
        }
    }

    void printArrayList() {
        for(int i = 0; i < this.arrayList.size(); i++) {
            System.out.println(this.arrayList.get(i) + ", ");
        }
    }

}

public class PermutationWithoutDuplicates {
    public static void main(String[] args) {
        FindPermutations obj = new FindPermutations();
        String st = "abc";
        obj.findPermution(st, "");
        obj.printArrayList();
    }
    
}
