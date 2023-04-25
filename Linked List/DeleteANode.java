class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteANode {
    
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

    Node deleteANode(Node head, int target) {
        
        if(head.data ==  target) {
            head = head.next;
            return head;
        }

        Node currentNode = head;
        Node prevNode = null;

        while(currentNode != null) {
            if(currentNode.data == target) {
                prevNode.next = currentNode.next;
                return head;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return head;
        
    }

    public static void main(String[] args) {
        Node head = null;
        DeleteANode obj = new DeleteANode();

        int [] temp = {1, 2, 3, 4, 5, 6};
        for(int i = 0; i < temp.length; i++) {
            head = obj.appendValue(head, temp[i]);
        }

        obj.printLinkedList(head);
        head = obj.deleteANode(head, 1);
        System.out.println("");
        obj.printLinkedList(head);

    }
}
