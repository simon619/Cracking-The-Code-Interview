class Node<anyType> {
    anyType data;
    int level;
    Node<anyType> next;

    public Node(anyType data, int level) {
        this.data = data;
        this.level = level;
        this.next = null;
    }
}

class LinkedList<anyType> {

    void printLinkedList(Node<anyType> head) {
        Node<anyType> currNode = head;

        while(currNode != null) {
            System.out.print("[" + "Node: " + currNode.data + " " + "Level: " + currNode.level + "]" + "->");
            currNode = currNode.next;
        }
    }

}

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

class MinimalTree<anyType> {

    Node<anyType> findTailNode(Node<anyType> head) {
        Node<anyType> currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        return currNode;
    }

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

    Node<anyType> traverse(TreeNode<anyType> currNode, int level) {
        if (currNode == null) {
            return null;
        }
        Node<anyType> node = new Node<anyType>(currNode.data, level);
        Node<anyType> leftHead = this.traverse(currNode.left, level + 1);
        Node<anyType> rightHead = this.traverse(currNode.right, level + 1);
        if(leftHead != null && rightHead != null) {
            node.next = leftHead;
            Node<anyType> tailOfLeft = this.findTailNode(leftHead); 
            tailOfLeft.next = rightHead;
        }
        else {
            if(rightHead == null) {
                node.next = leftHead;
            }
            if(leftHead == null);{
                node.next = rightHead;
            }
        }
        return node;   
    }
}

public class ListsOfDepthTest {
    public static void main(String[] args) {
        MinimalTree<Integer> treeObj = new MinimalTree<Integer>();
        TreeNode<Integer> root = null;
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        root = treeObj.buildBST(root, arr, 0, arr.length - 1);
        Node<Integer> head = treeObj.traverse(root, 0);
        LinkedList<Integer> linkedlistObj = new LinkedList<Integer>();
        linkedlistObj.printLinkedList(head);
    }
    
}
