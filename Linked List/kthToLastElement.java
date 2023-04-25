class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class kthToLastElement {

    Node appendValue(Node head, int data) {
        
        if(head == null) {
            return new Node(data);
        }

        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);
        return head;

    }

    void printLinkedList(Node head) {
        
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    int returnValue(Node currentNode, int k) {

        if (currentNode == null) {
            return 0;
        }
        int index = 1 + returnValue(currentNode.next, k);
        if (index == k) {
            System.out.println(k + " th element is " + currentNode.data);
        }
        
        return index;

    }

    public static void main(String[] args) {
        Node head = null;
        kthToLastElement obj = new kthToLastElement();

        int [] temp = {1, 2, 3, 4, 5};
        for(int i = 0; i < temp.length; i++) {
            head = obj.appendValue(head, temp[i]);
        }

        obj.printLinkedList(head);
        obj.returnValue(head, 4);
    }
}
