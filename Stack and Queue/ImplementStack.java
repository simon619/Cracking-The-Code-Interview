import java.util.EmptyStackException;

class StackNode<anyType> {
        
    anyType data;
    StackNode<anyType> next;

    public StackNode(anyType data) {
        this.data = data;
        this.next = null; 
    }

}

class MyStack<anyType> {
    
    StackNode<anyType> top;

    anyType pop() {
        if(this.top == null) {
            throw new EmptyStackException();
        }

        anyType val = top.data;
        top = top.next;
        return val;
    }

    anyType peak() {
        anyType val = top.data;
        return val;
    }

    void push(anyType val) {
        
        if (this.top == null) {
            this.top = new StackNode<anyType>(val);
        }

        else {
            StackNode<anyType> newNode = new StackNode<anyType>(val);
            newNode.next = this.top;
            this.top = newNode;
        } 
    }

    boolean isEmpty() {
        return (this.top == null) ? true : false; 
    }

    void printStack() {
        StackNode<anyType> curNode = this.top;
        
        while(curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }

        System.out.println("");
    }

}

public class ImplementStack {

    public static void main(String[] args) {
        
        // For Integer Value
        System.out.println("For Integer Value:");
        MyStack<Integer> objInt = new MyStack<Integer>();
        System.out.println("Is Empty " + objInt.isEmpty());
        objInt.push(1);
        objInt.push(2);
        objInt.push(3);
        objInt.printStack();
        System.out.println("Peak " + objInt.peak());
        System.out.println("Pop " + objInt.pop());
        System.out.println("Peak " + objInt.peak());
        objInt.printStack();

        System.out.println("For Character Value:");
        MyStack<Character> objChar = new MyStack<Character>();
        System.out.println("Is Empty " + objChar.isEmpty());
        objChar.push('a');
        objChar.push('b');
        objChar.push('c');
        objChar.printStack();
        System.out.println("Peak " + objChar.peak());
        System.out.println("Pop " + objChar.pop());
        System.out.println("Peak " + objChar.peak());
        objChar.printStack();


    }
    
}
