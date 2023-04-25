import java.util.ArrayList;


public class ArrayListPlus {

    static void printArrayList(ArrayList<ArrayList<Integer>> arratList) {
        for(int i = 0; i < arratList.size(); i++) {
            for(int j = 0; j < arratList.get(i).size(); j++) {
                int val = arratList.get(i).get(j);
                System.out.print(val + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>(3);
        ArrayList<Integer> a1 = new ArrayList<Integer>(2);
        a1.add(5);
        a1.add(8);
        a1.add(13);
        arrayList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>(4);
        a2.add(15);
        a2.add(25);
        a2.add(89);
        arrayList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>(1);
        a3.add(45);
        a3.add(61);
        arrayList.add(a3);

        printArrayList(arrayList);
        arrayList.remove(2);
        printArrayList(arrayList);

    }
}