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


class Node<anyType> {
    anyType data;
    Node<anyType> next;
    
    public Node(anyType data) {
        this.data = data;
        this.next = null;
    }
}


class TheSearch<anyType> {
    Node<anyType> search(Vertex<anyType> v, Node<anyType> top) {

        v.visited = true;
        if (top == null) {
            top = new Node<anyType>(v.data);
        }

        else {
            Node<anyType> newNode = new Node<anyType>(v.data);
            newNode.next = top;
            top = newNode;
        }

        for(int i = 0; i < v.nodeAdj.size(); i++) {
            if (!v.nodeAdj.get(i).visited) {
                top = this.search(v.nodeAdj.get(i), top);
            }
        }
        return top;
    
    } 

    Node<anyType> reverse(Node<anyType> currNode, Node<anyType> prevNode) {
        
        if (currNode == null) {
            return prevNode;
        }

        else {
            Node<anyType> nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            return this.reverse(currNode, prevNode);
        }

    }

    void printLinkedList(Node<anyType> head) {
        
        Node<anyType> currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("");
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
        TheSearch<Integer> dfsObj = new TheSearch<Integer>();
        Node<Integer> revTop = null;
        revTop = dfsObj.search(this.nodeCollection.get(0), revTop);
        Node<Integer> top = dfsObj.reverse(revTop, null);
        dfsObj.printLinkedList(top);

    }

}

public class DepthFirstSearch {
    public static void main(String[] args) {
        int numberOfVertex = 5;
        CreateTheGraph<Integer> G = new CreateTheGraph<Integer>(numberOfVertex);
        G.createTheGraph();    
    }
    
}
