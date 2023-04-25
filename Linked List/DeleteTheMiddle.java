class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class DeleteTheMiddle {
    
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

    Node deleteTheMiddle(Node head) {

        if (head.next.next == null) {
            return head.next;
        }

        Node slow = head;
        Node fast = head.next;
        Node prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;

    }

    public static void main(String[] args) {
        Node head = null;
        DeleteTheMiddle obj = new DeleteTheMiddle();

        int [] temp = {1, 2};
        for(int i = 0; i < temp.length; i++) {
            head = obj.appendValue(head, temp[i]);
        }

        obj.printLinkedList(head);
        head = obj.deleteTheMiddle(head);
        obj.printLinkedList(head);
    }
}
