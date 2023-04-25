class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Partition {
    
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

    Node partitioning(Node head, int n) {
        Node headLeft = null, headRight = null, currentLeft = null, currentRight = null, currentNode = head;
        while(currentNode != null) {
            if (currentNode.data < n) {
                if (headLeft == null) {
                    headLeft = new Node(currentNode.data);
                    currentLeft = headLeft;
                }

                else {
                    currentLeft.next = new Node(currentNode.data);
                    currentLeft = currentLeft.next;
                }

            }

            else {

                if (headRight == null) {
                    headRight = new Node(currentNode.data);
                    currentRight = headRight;
                }

                else {
                    currentRight.next = new Node(currentNode.data);
                    currentRight = currentRight.next;
                }

            }
        currentNode = currentNode.next;
        
        }
        currentLeft.next = headRight;
        return headLeft;
    }


    public static void main(String[] args) {
        Node head = null;
        Partition obj = new Partition();

        int [] temp = {3, 5, 8, 5, 10, 2, 1};
        for(int i = 0; i < temp.length; i++) {
            head = obj.appendValue(head, temp[i]);
        }

        obj.printLinkedList(head);
        head = obj.partitioning(head, 5);
        obj.printLinkedList(head);
    }
}
