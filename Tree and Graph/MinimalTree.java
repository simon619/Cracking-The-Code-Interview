import java.util.ArrayList;
import java.util.NoSuchElementException;

class TreeNode<anyType> {
    anyType data;
    TreeNode<anyType> left;
    TreeNode<anyType> right;

    public TreeNode(anyType data) {
        this.data = data;
        this.left = null;
        this.right = null;
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

public class MinimalTree<anyType> {

    TreeNode<anyType> buildBST(TreeNode<anyType> currNode, anyType [] arr, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode<anyType> newNode = new TreeNode<anyType>(arr[mid]);
        newNode.left = this.buildBST(currNode, arr, left, mid - 1);
        newNode.right = this.buildBST(currNode, arr, mid + 1, right);
        return newNode; 
    }

    ArrayList<anyType> printBST(MyQueue<anyType> queue, ArrayList<anyType> arr) {
        
        if(!queue.isEmpty()) {
            TreeNode<anyType> temp = queue.remove();
            arr.add(temp.data);
            
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

            arr = this.printBST(queue, arr);
        }

        return arr;
    }

    void print(ArrayList<anyType> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " -> ");
        }
    }

    public static void main(String[] args) {
        MinimalTree<Integer> obj = new MinimalTree<Integer>();
        TreeNode<Integer> root = null;
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6};
        root = obj.buildBST(root, arr, 0, arr.length - 1);
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(root);
        ArrayList<Integer> nodes = new ArrayList<Integer>(0);
        ArrayList<Integer> res = obj.printBST(queue, nodes);
        obj.print(res);
        
    }
    
}
