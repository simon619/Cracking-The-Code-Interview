import java.util.ArrayList;

class GetPowerSet {
    ArrayList<ArrayList<Integer>> getPowerSet(int [] arr, int pointer) {
        
        if (pointer > arr.length - 1) {
            ArrayList<Integer> emptySet = new ArrayList<Integer>(0);
            emptySet.add(null);
            ArrayList<ArrayList<Integer>> origin =  new ArrayList<ArrayList<Integer>>(1);
            origin.add(emptySet);
            return origin;

        }

        else {

            ArrayList<ArrayList<Integer>> prevData = this.getPowerSet(arr, pointer + 1);
            int data = arr[pointer];
            ArrayList<ArrayList<Integer>> newData = new ArrayList<ArrayList<Integer>>(0);
            for(int i = 0; i < prevData.size(); i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(0);
                temp.addAll(prevData.get(i));
                temp.add(data);
                newData.add(temp);
            }

            for(int i = 0; i < prevData.size(); i++) {
                newData.add(prevData.get(i));
            }
            return newData;
        }

    }

    void printArrayList(ArrayList<ArrayList<Integer>> arrList) {
        System.out.println("Size: " + arrList.size());
        for(int i = 0; i < arrList.size(); i++) {
            ArrayList<Integer> temp = arrList.get(i);
            for(int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + ", ");
            }
            System.out.println(" ");
        }
    }
}

public class PowerSet {
    public static void main(String[] args) {
        GetPowerSet obj = new GetPowerSet();
        int [] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = obj.getPowerSet(arr, 0);
        obj.printArrayList(res);    
    }
}
