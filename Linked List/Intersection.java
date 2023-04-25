class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NodePlus {
    Node node;
    int size;

    public NodePlus(Node node, int size) {
        this.node = node;
        this.size = size;
    }
}

public class Intersection {

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

    Node[] newBigLinkedList(Node l1, Node l2, Node l3) {
        
        Node newHead1 = l1, newHead2 = l2;
        while(l1.next != null) {
            l1 = l1.next;
        }
        l1.next = l3;

        while(l2.next != null) {
            l2 = l2.next;
        }
        l2.next = l3;

        return new Node[] {newHead1, newHead2};
    }

    NodePlus getTheSizeAndTail(Node currentNode) {
        
        int size = 0;
        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }

        return new NodePlus(currentNode, size);

    }

    Node kthToEnd(Node longer, int n) {

        while(n > 0 && longer != null) {
            n--;
            longer = longer.next;
        }
        return longer;
    }

    Node findIntersection(Node head1, Node head2) {
        
        if (head1 == null && head2 ==  null) {
            return null;
        }

        NodePlus forHead1 = this.getTheSizeAndTail(head1);
        NodePlus forHead2 = this.getTheSizeAndTail(head2);

        if (forHead1.node != forHead2.node) {
            return null;
        }

        Node longer = forHead1.size > forHead2.size ? head1 : head2;
        Node shorter = forHead1.size > forHead2.size ? head2 : head1;

        Node newLonger = this.kthToEnd(longer, Math.abs(forHead1.size - forHead2.size));

        while(newLonger != shorter) {
            newLonger = newLonger.next;
            shorter = shorter.next;
        }

        return shorter;


    }

    



    public static void main(String[] args) {
        Node head1 = null, head2 = null, head3 = null;
        int [] a = {1, 2, 3, 4}, b = {75, 25}, c = {5, 6, 7};
        Intersection obj = new Intersection();

        for(int i = 0;  i < a.length; i++) {
            head1 = obj.appendValue(head1, a[i]);
        }

        for(int i = 0;  i < b.length; i++) {
            head2 = obj.appendValue(head2, b[i]);
        }

        for(int i = 0;  i < c.length; i++) {
            head3 = obj.appendValue(head3, c[i]);
        }

        // obj.printLinkedList(head1);
        // obj.printLinkedList(head2);
        // obj.printLinkedList(head3);

        Node newLists [] = obj.newBigLinkedList(head1, head2, head3);

        Node newHead1 = newLists[0], newHead2 = newLists[1];
        obj.printLinkedList(newHead1);
        obj.printLinkedList(newHead2);

        Node intersectNode = obj.findIntersection(newHead1, newHead2);
        System.out.println(intersectNode.data);

    }

    
}
