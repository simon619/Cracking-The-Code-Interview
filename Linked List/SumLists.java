class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SumLists {
    
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

    Node[] checking(Node headResult, Node currentNode, int number) {
        
        if (headResult == null) {
            headResult = new Node(number);
            currentNode = headResult;
        }

        else {
            currentNode.next = new Node(number);
            currentNode = currentNode.next;
        }
        return new Node[] {headResult, currentNode}; 
    }

    Node sumList(Node firstList, Node secondList) {
        Node headResult = null, currentNode = null;
        int remains = 0;
        while(firstList != null && secondList != null) {
            
            int sum = firstList.data + secondList.data + remains;
            firstList = firstList.next;
            secondList = secondList.next;
            int number = sum % 10;
            remains = sum / 10;

            Node [] nodes = this.checking(headResult, currentNode, number);
            headResult = nodes[0];
            currentNode = nodes[1];
            
        }

        while(firstList != null) {
            int sum = firstList.data + remains;
            firstList = firstList.next;
            int number = sum % 10;
            remains = sum / 10;

            Node [] nodes = this.checking(headResult, currentNode, number);
            headResult = nodes[0];
            currentNode = nodes[1];

        }

        while(secondList != null) {
            int sum = secondList.data + remains;
            secondList = secondList.next;
            int number = sum % 10;
            remains = sum / 10;

            Node [] nodes = this.checking(headResult, currentNode, number);
            headResult = nodes[0];
            currentNode = nodes[1];
            
        }

        if (remains != 0) {
            currentNode.next = new Node(remains);
            currentNode = currentNode.next;
        }

        return headResult;

    }

    public static void main(String[] args) {
        Node head1 = null, head2 = null;
        SumLists obj = new SumLists();
        // int [] forHead1 = {5, 9, 7}, forHead2 = {6, 3, 9};
        int [] forHead1 = {1, 4}, forHead2 = {0, 7, 9};
        
        for (int i = 0;  i < forHead1.length; i++) {
            head1 = obj.appendValue(head1, forHead1[i]);
        }

        for (int i = 0;  i < forHead2.length; i++) {
            head2 = obj.appendValue(head2, forHead2[i]);
        }

        System.out.println("First Linked List");
        obj.printLinkedList(head1);

        System.out.println("Second Linked List");
        obj.printLinkedList(head2);

        System.out.println("Sumation");
        Node sumResult = obj.sumList(head1, head2);
        obj.printLinkedList(sumResult);
                
    }

}
