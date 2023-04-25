import java.util.EmptyStackException;

class StackNode<anyType> {
    anyType data;
    StackNode<anyType> next;

    public StackNode(anyType data) {
        this.data = data;
        this.next = null;
    }

}

class Stack<anyType> {
    StackNode<anyType> top;

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

    anyType pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            anyType val = this.top.data;
            this.top = this.top.next;
            return val;
        }
    }

    anyType peek() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return this.top.data;
        }  
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

class FakeQueue<anyType> {
    Stack<anyType> tempStack = new Stack<anyType>();
    Stack<anyType> realStack = new Stack<anyType>();

    void add(anyType val) {
        this.tempStack.push(val);
    }

    void refactorizing() {
        if(realStack.isEmpty()) {
            while(!this.tempStack.isEmpty()) {
                this.realStack.push(this.tempStack.pop());
            }
        }
    }

    anyType remove() {
        this.refactorizing();
        return this.realStack.pop();
    }

    anyType peek() {
        this.refactorizing();
        return this.realStack.peek();
    }

    void printQueue() {
        System.out.println("Temp Stack");
        this.tempStack.printStack();
        System.out.println("Real Stack");
        this.realStack.printStack();
    }

    

}

public class QueueViaStack {
    public static void main(String[] args) {
        FakeQueue<Integer> obj = new FakeQueue<Integer>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.printQueue();
        System.out.println(obj.peek());
        obj.printQueue();


    }
}
