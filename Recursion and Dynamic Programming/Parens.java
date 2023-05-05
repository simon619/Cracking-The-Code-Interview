import java.util.EmptyStackException;
import java.util.HashSet;

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

class GetParens {

    HashSet<String> hashSet = new HashSet<String>();

    boolean isValid(String str) {
        MyStack<Character> stack = new MyStack<Character>();
        if (str.charAt(0) == ')') return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return (stack.isEmpty()) ? true : false;
    }

    void getParens(String str, String perf) {
        if (str.length() == 0) {
            if (isValid(perf)) {
                hashSet.add(perf);
            }
        }
        else {
            for(int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i) + str.substring(i + 1);
                this.getParens(temp, perf + str.charAt(i)); 
            }
        }
    }

    void printArrayList() {
        for(String i : this.hashSet) {
            System.out.println(i + ", ");
        }
    }

}

public class Parens {
    public static void main(String[] args) {
        GetParens obj = new GetParens();
        String str = "()()()";
        obj.getParens(str, "");
        obj.printArrayList();
    }
}
