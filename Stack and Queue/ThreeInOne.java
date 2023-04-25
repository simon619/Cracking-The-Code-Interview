import java.util.EmptyStackException;

public class ThreeInOne {
    
    int numberOfStacks;
    int value[];
    int size[];
    int sizeOfStack;

    public ThreeInOne(int sizeOfStack) {
        this.numberOfStacks = 3;
        this.value = new int[numberOfStacks * sizeOfStack];
        this.size = new int[numberOfStacks];
        this.sizeOfStack = sizeOfStack;
    }

    boolean isFull(int theStack) {
        return (this.size[theStack] == this.sizeOfStack) ? true : false; 
    }

    boolean isEmpty(int theStack) {
        return (this.size[theStack] == 0) ? true : false;
    }

    int targetIndex(int whichStack) {
        int offset = whichStack * numberOfStacks;
        return offset + this.size[whichStack] - 1;
    }

    void push(int whichStack, int data) {

        if (isFull(whichStack)) {
            System.out.println("Stack Full");
        }

        this.size[whichStack]++;
        this.value[this.targetIndex(whichStack)] = data;

    }

    int peek(int whichStack) {

        int offset = whichStack * numberOfStacks;
        int index = offset + this.size[whichStack] - 1;
        return value[index];

    }

    int pull(int whichStack) {
        if (this.isEmpty(whichStack)) {
            throw new EmptyStackException();
        }
        int target = this.targetIndex(whichStack);
        int data = this.value[target];
        this.value[target] = 0;
        size[whichStack]--;
        return data;
    }

    void printStack() {
        for(int i = 0; i < value.length; i++) {
            System.out.print(this.value[i] + " -> ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ThreeInOne obj = new ThreeInOne(3);
        obj.push(0, 26);
        obj.push(1, 19);
        obj.push(2, 7);
        obj.printStack();

        obj.push(1, 32);
        obj.push(0, 9);
        obj.push(0, 8);
        obj.push(0, 22);
        System.out.println("Peeked " + obj.peek(0));
        obj.printStack();

        obj.pull(2);
        // obj.pull(2);
        obj.printStack();
    }

}
