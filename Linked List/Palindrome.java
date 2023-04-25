class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Palindrome {
 
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

    Node reverse(Node currNode, Node prevNode) {
        
        if (currNode == null) {
            return prevNode;
        }

        else {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            return this.reverse(currNode, prevNode);
        }

    }

    Boolean isPalindrome(Node left, Node right) {

        while(left != null && right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    boolean goToMiddle(Node head) {

        Node slow = head, fast = head.next, headLeft = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node forLeft = slow;
        Node forRight = slow.next;
        forLeft.next = null;
        Node headRight = this.reverse(forRight, null);
        return this.isPalindrome(headLeft, headRight);

    }

    public static void main(String[] args) {
        int [] ch = {1, 2, 2, 1};
        Node head = null;
        Palindrome obj = new Palindrome();

        for(int i = 0; i < ch.length; i++) {
            head = obj.appendValue(head, ch[i]);
        }

        boolean b = obj.goToMiddle(head);
        System.out.println(b);
        
    }

}
