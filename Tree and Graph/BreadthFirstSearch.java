import java.util.ArrayList;
import java.util.NoSuchElementException;

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

class QueueNode<anyType> {
    Vertex<anyType> data;
    QueueNode<anyType> next;

    public QueueNode(Vertex<anyType> val) {
        this.data = val;
        this.next = null;
    }

}

class Queue<anyType> {
    QueueNode<anyType> first = null;
    QueueNode<anyType> last = null;

    Vertex<anyType> dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        Vertex<anyType> val = first.data;
        first = first.next;
        if (first == null) {
            last = first;
        }

        return val;
    }

    Vertex<anyType> peak() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        else {
            return first.data;
        }
    }

    void enqueue(Vertex<anyType> val) {
        if (last == null) {
            last = new QueueNode<anyType>(val);
        }

        if (last != null) {
            last.next = new QueueNode<anyType>(val);
            last = last.next;
        }

        if (first == null) {
            first = last;
        }
    }

    boolean isEmpty() {
        return (first == null) ? true : false; 
    }

    
}

class TheSearch<anyType> {

    Node<anyType> head;

    Node<anyType> search(Vertex<anyType> v) {
        
        Queue<anyType> queue = new Queue<anyType>();
        queue.enqueue(v);
        
        v.visited = true;

        while(!queue.isEmpty()) {
            Vertex<anyType> visitingVertex = queue.dequeue();
            System.out.println(visitingVertex.data);
            if(head == null) {
                head = new Node<anyType>(v.data);
            }
            else {
                Node<anyType> newNode = new Node<anyType>(visitingVertex.data);
                newNode.next = head;
                head = newNode;
            }

            for(int i = 0; i < visitingVertex.nodeAdj.size(); i++) {

                Vertex<anyType> temp = visitingVertex.nodeAdj.get(i);
                if(!temp.visited) {
                    temp.visited = true;
                    queue.enqueue(temp);
                }
            }

        }

        return head;

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
        TheSearch<Integer> bfsObj = new TheSearch<Integer>();
        Node<Integer> revTop = bfsObj.search(this.nodeCollection.get(0));
        Node<Integer> top = bfsObj.reverse(revTop, null);
        bfsObj.printLinkedList(top);

    }

}

public class BreadthFirstSearch {
    
    public static void main(String[] args) {
        int numberOfVertex = 5;
        CreateTheGraph<Integer> G = new CreateTheGraph<Integer>(numberOfVertex);
        G.createTheGraph();    
    }

}
