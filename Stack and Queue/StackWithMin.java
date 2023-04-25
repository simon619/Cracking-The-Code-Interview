import java.util.EmptyStackException;

class StackNodeX {
    int data;
    StackNodeX next;

    public StackNodeX(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    StackNodeX head;

    void push(int val) {
        if (this.head == null) {
            this.head = new StackNodeX(val);
            System.out.println(this.head.data);
        }
        else {
            StackNodeX newNode = new StackNodeX(val);
            newNode.next = this.head;
            this.head = newNode;
        }

    }

    int pop() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        int val = this.head.data;
        this.head = this.head.next;
        return val;
    }

    int peek() {
        
        return this.head.data;
    }

    boolean isEmpty() {
        return (this.head == null) ? true : false;
    }

    void printStack() {
        StackNodeX curNode = this.head;
        
        while(curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }

        System.out.println("");
    }

}

class MinStackController extends Stack {
    public Stack mainStackObj;
    public Stack minStackObj;

    public MinStackController(Stack stack1, Stack stack2) {
        mainStackObj = stack1;
        minStackObj = stack2;
    }

    int min() {
        return (minStackObj.head == null) ? 99999 : minStackObj.peek();
    }

    void minpush(int val) {
        if(val <= this.min()) {
            System.out.println("si");
            minStackObj.push(val);
        }
        mainStackObj.push(val);
    }

    int minpeek() {
        if (minStackObj.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStackObj.peek();
    }

    int minpop() {
        int val = mainStackObj.pop();
        if(val == this.min()) {
            minStackObj.pop();
        }
        return val;
    }   
}

public class StackWithMin {
    public static void main(String[] args) {
        int arr[] = {7, 5, 8, 1, 6, 0};
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        MinStackController minObj = new MinStackController(stack1, stack2);
        for(int i = 0; i < arr.length; i++) {
            minObj.minpush(arr[i]);
        }
        stack1.printStack();
        stack2.printStack();

        System.out.println(minObj.minpop());
        stack1.printStack();
        stack2.printStack();
        
    }
}
