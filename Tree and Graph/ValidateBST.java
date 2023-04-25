import java.util.ArrayList;
import java.util.NoSuchElementException;

class TreeNode {
    int data;
    int level;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, int level) {
        this.data = data;
        this.level = level;
        this.left = null;
        this.right = null;
    }

}

class Node {
    int data;
    int level;
    
    public Node(int data, int level) {
        this.data = data;
        this.level = level;
    }
}

class QueueNode {

    TreeNode data;
    QueueNode next;

    public QueueNode(TreeNode data) {
        this.data = data;
        this.next = null;
    }

}

class MyQueue {

    QueueNode first = null;
    QueueNode last = null;

    TreeNode remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        TreeNode val = first.data;
        first = first.next;
        if (first == null) {
            last = first;
        }

        return val;
    }

    TreeNode peak() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        else {
            return first.data;
        }
    }

    void add(TreeNode val) {
        if (last == null) {
            last = new QueueNode(val);
        }

        if (last != null) {
            last.next = new QueueNode(val);
            last = last.next;
        }

        if (first == null) {
            first = last;
        }
    }

    boolean isEmpty() {
        return (first == null) ? true : false; 
    }

}

class TreePlantation {

    TreeNode planatation(int arr[], int left, int right, int level) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode newNode = new TreeNode(arr[mid], level);
        newNode.left = this.planatation(arr, left, mid - 1, level + 1);
        newNode.right = this.planatation(arr, mid + 1, right, level + 1);
        return newNode;
    }
}

class PrintTree {
    
    ArrayList<Node> insertIntoQueue(MyQueue queue, ArrayList<Node> arr) {
        
        if(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            arr.add(new Node(temp.data, temp.level));
            
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

            arr = this.insertIntoQueue(queue, arr);
        }

        return arr;
    }

    void print(ArrayList<Node> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print("[" + arr.get(i).data + ", " + arr.get(i).level + "]"+ " -> ");
        }
        System.out.println("");
    }
}

class Validation {

    boolean validation(TreeNode currNode) {
        if (currNode == null) {
            return true;
        }
        if (currNode.left != null && currNode.right != null) {
            if (!(currNode.left.data < currNode.data) || !(currNode.right.data > currNode.data)) {
                return false;
            }
        }   
        return this.validation(currNode.left) && this.validation(currNode.right);
    }

}

class Seed {
    void seeding() {
        // Create Tree
        int arr [] = {5, 6, 8, 10, 12, 15, 17, 20, 25, 30};
        TreePlantation treeNode = new TreePlantation();
        TreeNode root = treeNode.planatation(arr, 0, arr.length - 1, 1);
        
        // Show Tree
        PrintTree printObj = new PrintTree();
        MyQueue queue = new MyQueue();
        queue.add(root);
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> res = printObj.insertIntoQueue(queue, nodes);
        System.out.println("The Tree: ");
        printObj.print(res);

        // Validation Check
        Validation valObj = new Validation();
        boolean b = valObj.validation(root);
        System.out.println(b);
    }
}

public class ValidateBST {
    public static void main(String[] args) {
        Seed obj = new Seed();
        obj.seeding(); 
    }
    
}
