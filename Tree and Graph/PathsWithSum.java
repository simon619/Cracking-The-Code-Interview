import java.util.ArrayList;
import java.util.NoSuchElementException;

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

    TreeNode planatation(TreeNode currNode, int pointer, Integer [] arr, int Level) {
        if(arr.length == 0 || arr[pointer] == null) {
            return null;
        }
        
        int leftPointer = 2 * pointer + 1, rightPointer = 2 * pointer + 2;
        currNode = new TreeNode(arr[pointer], Level);
        if (leftPointer < arr.length) currNode.left = this.planatation(currNode.left, leftPointer, arr, Level + 1);   
        if (rightPointer < arr.length) currNode.right = this.planatation(currNode.right, rightPointer, arr, Level + 1);
        return currNode;
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

class NumberOfRoutes {

    int currentNode(TreeNode curNode, Integer target) {

        if (curNode == null) {
            return 0;
        }

        int curCount = this.countRoutes(curNode, target, 0);

        int leftNodeCount = this.currentNode(curNode.left, target);
        int rightNodeCount = this.currentNode(curNode.right, target);

        return curCount + leftNodeCount + rightNodeCount;

    }


    int countRoutes(TreeNode curNode, Integer target, Integer curSum) {
        if (curNode == null) {
            return 0;
        }

        int totalPath = 0;

        curSum = curSum + curNode.data;
        if (curSum == target) {
            totalPath++;
        }
        totalPath += this.countRoutes(curNode.left, target, curSum);
        totalPath += this.countRoutes(curNode.right, target, curSum);
        return totalPath;      
        
    }

}



class Seed {

    void seeding() {

        // Create Tree
        Integer arr [] = {8, 5, 2, 1, 3, 4, 10, 1, null, 0, -2};
        TreePlantation treeObj = new TreePlantation(); 
        TreeNode root = treeObj.planatation(null, 0, arr, 1);
        
        // Show Tree
        PrintTree printObj = new PrintTree();
        MyQueue queue = new MyQueue();
        queue.add(root);
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> res = printObj.insertIntoQueue(queue, nodes);
        System.out.println("The Tree: ");
        printObj.print(res);

        // Count Path
        NumberOfRoutes routesObj = new NumberOfRoutes();
        int paths = routesObj.currentNode(root, 8);
        System.out.println(paths);
    }

}


public class PathsWithSum {
    public static void main(String[] args) {
        Seed obj = new Seed();
        obj.seeding();
    }
    
}
