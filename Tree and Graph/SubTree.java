import java.util.ArrayList;
import java.util.NoSuchElementException;

class Node<anyType> {
    anyType data;
    int level;
    
    public Node(anyType data, int level) {
        this.data = data;
        this.level = level;
    }
}

class QueueNode<anyType> {

    TreeNode<anyType> data;
    QueueNode<anyType> next;

    public QueueNode(TreeNode<anyType> data) {
        this.data = data;
        this.next = null;
    }

}

class TreeNode<anyType> {
    anyType data;
    int level;
    TreeNode<anyType> left;
    TreeNode<anyType> right;

    public TreeNode(anyType data, int level) {
        this.data = data;
        this.level = level;
        this.left = null;
        this.right = null;
    }
}

class MyQueue<anyType> {

    QueueNode<anyType> first = null;
    QueueNode<anyType> last = null;

    TreeNode<anyType> remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        TreeNode<anyType> val = first.data;
        first = first.next;
        if (first == null) {
            last = first;
        }

        return val;
    }

    TreeNode<anyType> peak() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        else {
            return first.data;
        }
    }

    void add(TreeNode<anyType> val) {
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

}

class TreePlantation<anyType> {

    TreeNode<anyType> planatation(TreeNode<anyType> currNode, int pointer, anyType [] arr, int Level) {
        if(arr.length == 0 || arr[pointer] == null) {
            return null;
        }
        
        int leftPointer = 2 * pointer + 1, rightPointer = 2 * pointer + 2;
        currNode = new TreeNode<anyType>(arr[pointer], Level);
        if (leftPointer < arr.length) currNode.left = this.planatation(currNode.left, leftPointer, arr, Level + 1);   
        if (rightPointer < arr.length) currNode.right = this.planatation(currNode.right, rightPointer, arr, Level + 1);
        return currNode;
    }
}

class PrintTree<anyType> {
    
    ArrayList<Node<anyType>> insertIntoQueue(MyQueue<anyType> queue, ArrayList<Node<anyType>> arr) {
        
        if(!queue.isEmpty()) {
            TreeNode<anyType> temp = queue.remove();
            arr.add(new Node<anyType>(temp.data, temp.level));
            
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

    void print(ArrayList<Node<anyType>> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print("[" + arr.get(i).data + ", " + arr.get(i).level + "]"+ " -> ");
        }
        System.out.println("");
    }
}

class SubTreeFind<anyType> {

    boolean finding(TreeNode<anyType> mainTree, TreeNode<anyType> subTree) {
        if (subTree == null) {
            return true;
        }
        if (mainTree == null) {
            return false;
        }
        if(this.isSubTree(mainTree, subTree)) {
            return true;
        }
        return (this.finding(mainTree.left, subTree) || this.finding(mainTree.right, subTree));

    }

    boolean isSubTree(TreeNode<anyType> mainTree, TreeNode<anyType> subTree) {
        if (mainTree == null && subTree == null) {
            return true;
        }
        if (mainTree != null && subTree != null && mainTree.data == subTree.data) {
            return isSubTree(mainTree.left, subTree.left) && isSubTree(mainTree.right, subTree.right);
        }
        return false;
    }

    

}

class Seed {
    
    void seeding() {

        // Create Tree 1
        Integer arr1 [] = {5, 6, 9, 1, 0, 3, 12};
        TreePlantation<Integer> treeObj1 = new TreePlantation<Integer>(); 
        TreeNode<Integer> root1 = treeObj1.planatation(null, 0, arr1, 1);

        // 
        Integer arr2[] = {6, 1, 0};
        TreePlantation<Integer> treeObj2 = new TreePlantation<Integer>(); 
        TreeNode<Integer> root2 = treeObj2.planatation(null, 0, arr2, 1);
        
        // Show Tree
        PrintTree<Integer> printObj = new PrintTree<Integer>();
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(root1);
        ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>(0);
        ArrayList<Node<Integer>> res = printObj.insertIntoQueue(queue, nodes);
        System.out.println("The Tree: ");
        printObj.print(res);

        // Check tree
        SubTreeFind<Integer> subObj = new SubTreeFind<Integer>();
        boolean b = subObj.finding(root1, root2);
        System.out.println(b);

    }

}

public class SubTree {
    public static void main(String[] args) {
        Seed obj = new Seed();
        obj.seeding();
    }
    
}
