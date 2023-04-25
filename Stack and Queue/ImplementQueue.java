import java.util.NoSuchElementException;

class QueueNode<anyType> {

    anyType data;
    QueueNode<anyType> next;

    public QueueNode(anyType data) {
        this.data = data;
        this.next = null;
    }

}

class MyQueue<anyType> {

    QueueNode<anyType> first = null;
    QueueNode<anyType> last = null;

    anyType remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        anyType val = first.data;
        first = first.next;
        if (first == null) {
            last = first;
        }

        return val;
    }

    anyType peak() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        else {
            return first.data;
        }
    }

    void add(anyType val) {
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

    void printQueue() {
        QueueNode<anyType> curNode = this.first;
        
        while(curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }

        System.out.println("");
    }

}

public class ImplementQueue {

    public static void main(String[] args) {
        
        // For Integer Value
        System.out.println("For Integer Value:");
        MyQueue<Integer> objInt = new MyQueue<Integer>();
        System.out.println("Is Empty " + objInt.isEmpty());
        objInt.add(1);
        objInt.add(2);
        objInt.add(3);
        objInt.printQueue();
        System.out.println("Peak " + objInt.peak());
        System.out.println("Pop " + objInt.remove());
        System.out.println("Peak " + objInt.peak());
        objInt.printQueue();

        System.out.println("For Character Value:");
        MyQueue<Character> objChar = new MyQueue<Character>();
        System.out.println("Is Empty " + objChar.isEmpty());
        objChar.add('a');
        objChar.add('b');
        objChar.add('c');
        objChar.printQueue();
        System.out.println("Peak " + objChar.peak());
        System.out.println("Pop " + objChar.remove());
        System.out.println("Peak " + objChar.peak());
        objChar.printQueue();

    }
    
}
