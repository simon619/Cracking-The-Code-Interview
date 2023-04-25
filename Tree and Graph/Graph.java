import java.util.ArrayList;

class Node<anyType> {
    anyType data;
    ArrayList<Node<anyType>> nodeAdj = new ArrayList<Node<anyType>>(0);

    public Node(anyType data) {
        this.data = data;
    }
}


public class Graph {

    public static ArrayList<Node<Integer>> nodeCollection;
    static int numberOfVertex;


    static void createTheGraph(ArrayList<Integer []> adj) {
        if (nodeCollection.size() == adj.size()) {
            
            for (int i = 0; i < numberOfVertex; i++) {
                Integer [] temp = adj.get(i);
                for (int j = 0; j < temp.length; j++) {
                    nodeCollection.get(i).nodeAdj.add(nodeCollection.get(temp[j]));
                }
            }
  
        }
    }

    static void printNode() {
        for(int i = 0; i < nodeCollection.size(); i++) {
            System.out.print(nodeCollection.get(i).data + " -> ");
                for(int j = 0; j < nodeCollection.get(i).nodeAdj.size(); j++) {
                    System.out.print(nodeCollection.get(i).nodeAdj.get(j).data + ", ");
                }
                System.out.println("");
        }
    }

    public static void main(String[] args) {


        numberOfVertex = 5;
        nodeCollection = new ArrayList<Node<Integer>>(5);
        
        for(int i = 0; i < numberOfVertex; i++) {
            nodeCollection.add(new Node<Integer>(i));
        }

        ArrayList<Integer []> adj = new ArrayList<Integer []>(5);
        Integer[] temp0 = {1, 2, 3};
        adj.add(temp0);
        Integer temp1 [] = {};
        adj.add(temp1);
        Integer temp2 [] = {1};
        adj.add(temp2);
        Integer temp3 [] = {1, 2};
        adj.add(temp3);     
        Integer temp4 [] = {3};
        adj.add(temp4); 
        
        createTheGraph(adj);
        printNode();
    }

}
