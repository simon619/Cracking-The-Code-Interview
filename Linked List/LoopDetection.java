class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopDetection {

    Node fifthNode = null;

    Node appendValue(Node head, int data) {
        
        if(head == null) {
            return new Node(data);
        }

        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);
        if (data == 5) {
            this.fifthNode = currentNode.next;
        }
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

    Node getTail(Node currNode) {
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        return currNode;
    }

    Node findLoop(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }

        if (fast.next == null || fast == null) {
            return null;
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
     
        int n = 10;
        LoopDetection obj = new LoopDetection();
        Node head = null;
        for(int i = 1; i < n + 1; i++) {
            head = obj.appendValue(head, i);
        }

        obj.printLinkedList(head);
        Node tail = obj.getTail(head);
        tail.next = obj.fifthNode;
        Node loopNode = obj.findLoop(head);
        System.out.println(loopNode.data);
        

    }
    
}
