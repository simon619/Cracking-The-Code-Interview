class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class ImplementLinkedList {

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
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        ImplementLinkedList obj = new ImplementLinkedList();

        int [] temp = {1, 2, 3, 4, 5, 6};
        for(int i = 0; i < temp.length; i++) {
            head = obj.appendValue(head, temp[i]);
        }

        obj.printLinkedList(head);
    }

}