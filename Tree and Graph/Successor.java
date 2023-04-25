import java.util.ArrayList;
import java.util.NoSuchElementException;

class TreeNode<anyType> {
    anyType data;
    int level;
    TreeNode<anyType> parents;
    TreeNode<anyType> left;
    TreeNode<anyType> right;

    public TreeNode(anyType data, int level, TreeNode<anyType> parents) {
        this.data = data;
        this.level = level;
        this.parents = parents;
        this.left = null;
        this.right = null;
    }

}

class Node<anyType> {
    anyType data;
    int level;
    anyType parents;
    TreeNode<anyType> treeNode;
    
    public Node(anyType data, int level, anyType parents, TreeNode<anyType> treeNode) {
        this.data = data;
        this.level = level;
        this.parents = parents;
        this.treeNode = treeNode;
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

class TreePlantation<anyType> {

    TreeNode<anyType> planatation(anyType arr[], int left, int right, int level, TreeNode<anyType> parents) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode<anyType> newNode = new TreeNode<anyType>(arr[mid], level, parents);
        newNode.left = this.planatation(arr, left, mid - 1, level + 1, newNode);
        newNode.right = this.planatation(arr, mid + 1, right, level + 1, newNode);
        return newNode;
    }
}

class PrintTree<anyType> {
    
    ArrayList<Node<anyType>> insertIntoQueue(MyQueue<anyType> queue, ArrayList<Node<anyType>> arr) {
        
        if(!queue.isEmpty()) {
            TreeNode<anyType> temp = queue.remove();
            arr.add((temp.parents != null) ? 
                new Node<anyType>(temp.data, temp.level, temp.parents.data, temp) : 
                new Node<anyType>(temp.data, temp.level, null, temp));
            
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
            System.out.print("[" + arr.get(i).data + ", " + arr.get(i).level +  ", " + arr.get(i).parents + "]"+ " -> ");
        }
        System.out.println("");
    }
}

class SuccessorFinding<anyType> {

    TreeNode<anyType> findSucceNode(TreeNode<anyType> currNode) {

        if(currNode.right != null) {
            return this.mostleftNode(currNode.right);
        }
        else {
            TreeNode<anyType> cur = currNode;
            TreeNode<anyType> par = cur.parents;

            while(par.parents != null && par.left != cur) {
                cur = par;
                par = par.parents;
            }
            return par;
        }

    }

    TreeNode<anyType> mostleftNode(TreeNode<anyType> currNode) {
        if (currNode.left == null ) {
            return currNode;
        }
        return this.mostleftNode(currNode.left);
    }

}


class Seed {
    void seeding() {
        // Create Tree
        Integer arr [] = {15, 30, 31, 32, 35, 37, 40, 42, 52, 56, 60, 65, 67};
        TreePlantation<Integer> treeNode = new TreePlantation<Integer>();
        TreeNode<Integer> root = treeNode.planatation(arr, 0, arr.length - 1, 1, null);
        
        // Show Tree
        PrintTree<Integer> printObj = new PrintTree<Integer>();
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(root);
        ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>(0);
        ArrayList<Node<Integer>> listOfTreeDetail = printObj.insertIntoQueue(queue, nodes);
        System.out.println("The Tree: ");
        printObj.print(listOfTreeDetail);

        // Find Successor
        SuccessorFinding<Integer> succObj = new SuccessorFinding<Integer>();
        for(int i = 0; i < listOfTreeDetail.size(); i++) {
            Node<Integer> temp = listOfTreeDetail.get(i);
            if (temp.data == 37) {
                TreeNode<Integer> res = succObj.findSucceNode(temp.treeNode);
                System.out.println(res.data);
            }
        }



    }
}

public class Successor {
    public static void main(String[] args) {
        Seed obj = new Seed();
        obj.seeding(); 
    }
}
