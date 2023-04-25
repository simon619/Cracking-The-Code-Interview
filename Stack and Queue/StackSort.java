import java.util.EmptyStackException;

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    StackNode top;

    void push(int val) {
        if(this.top == null) {
            this.top = new StackNode(val);
        }

        else {
            StackNode newNode = new StackNode(val);
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    boolean isEmpty() {
        return (this.top == null) ? true : false;
    }

    int pop() {
        if(this.top == null) {
            throw new EmptyStackException();
        }
        else {
            int val = this.top.data;
            this.top = this.top.next;
            return val;
        }
    }

    int peek() {
        if(this.top == null) {
            throw new EmptyStackException();
        }
        else {
            return this.top.data;
        }
    }

    void printStack() {
        StackNode curNode = this.top;
        
        while(curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }

        System.out.println("");
    }
    
}

class StackSort {

    Stack realStack;
    Stack tempStack = new Stack();

    public StackSort(Stack st) {
        this.realStack = st;
    }

    void stackSort() {
        while(!realStack.isEmpty()) {
            int temp = realStack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > temp) {
                realStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
    
        while(!tempStack.isEmpty()) {
            realStack.push(tempStack.pop());
        }
        realStack.printStack();
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        int arr [] = {2, 1, 0, 3};
        for(int i = 0; i < arr.length; i++) {
            st.push(arr[i]);
        }
        StackSort obj = new StackSort(st);
        st.printStack();
        obj.stackSort();
    }
}



    
    


