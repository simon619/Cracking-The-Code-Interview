import java.util.ArrayList;

class Vertex<anyType> {
    anyType data;
    ArrayList <Vertex<anyType>> nodeAdj = new ArrayList <Vertex<anyType>>(0);
    boolean visited;

    public Vertex(anyType data) {
        this.data = data;
        this.visited = false;
    }
}

class FindingConnection<anyType> {

    boolean find(Vertex<anyType> currVertex, Vertex<anyType> targetVertex) {
        if (currVertex == targetVertex) {
            return true;
        }
        currVertex.visited = true;
        for(int i = 0; i < currVertex.nodeAdj.size(); i++) {
            Vertex<anyType> temp = currVertex.nodeAdj.get(i);
            if(!temp.visited) {
                return this.find(temp, targetVertex);
            }
        }
        return false;
    }

}

class CreateTheGraph<anyType> {
   
    ArrayList<Vertex<Integer>> nodeCollection;
    int numberOfVertex;

    public CreateTheGraph(int n) {
        this.numberOfVertex = n;
    }

    void addAdjacency(ArrayList<Integer []> adj) {
        if (nodeCollection.size() == adj.size()) {
            
            for (int i = 0; i < numberOfVertex; i++) {
                Integer [] temp = adj.get(i);
                for (int j = 0; j < temp.length; j++) {
                    nodeCollection.get(i).nodeAdj.add(nodeCollection.get(temp[j]));
                }
            }
  
        }

    }

    void printNode() {

        for(int i = 0; i < nodeCollection.size(); i++) {
            System.out.print(nodeCollection.get(i).data + " -> ");
                for(int j = 0; j < nodeCollection.get(i).nodeAdj.size(); j++) {
                    System.out.print(nodeCollection.get(i).nodeAdj.get(j).data + ", ");
                }
                System.out.println("");
        }

    }

    void createTheGraph() {

        this.nodeCollection = new ArrayList<Vertex<Integer>>(this.numberOfVertex);
        
        for(int i = 0; i < numberOfVertex; i++) {
            this.nodeCollection.add(new Vertex<Integer>(i));
        }

        ArrayList<Integer []> adj = new ArrayList<Integer []>(this.numberOfVertex);
        Integer[] temp0 = {4, 2, 3};
        adj.add(temp0);
        Integer temp1 [] = {};
        adj.add(temp1);
        Integer temp2 [] = {1};
        adj.add(temp2);
        Integer temp3 [] = {1, 2};
        adj.add(temp3);     
        Integer temp4 [] = {3};
        adj.add(temp4); 
        
        this.addAdjacency(adj);
        this.printNode();
        
    }

}


public class RouteBetweenNodes {

    public static void main(String[] args) {
        int numberOfVertex = 5;
        CreateTheGraph<Integer> G = new CreateTheGraph<Integer>(numberOfVertex);
        G.createTheGraph();
        FindingConnection<Integer> obj = new FindingConnection<Integer>();
        boolean res = obj.find(G.nodeCollection.get(0), G.nodeCollection.get(4));
        // boolean res = obj.find(G.nodeCollection.get(0), new Vertex<Integer>(10));
        System.out.println(res);
    }

}
