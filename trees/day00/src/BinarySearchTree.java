import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public List<T> inOrderTraversal() {
        List<T> res = new LinkedList<>();
        TreeNode<T> currNode = findMin(root);

        if(currNode == null) {
            return res;
        }

        else {
            while(!(findSuccessor(currNode) == null)) {
                res.add(currNode.key);
                currNode = findSuccessor(currNode);
            }
            res.add(currNode.key);
        }

        /**for(Comparable<T> pls: res){
            System.out.println(pls);
        }**/

        return res;
    }

    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        TreeNode<T> deleted = delete(toDelete);
        if (toDelete == root) {
            root = deleted;
        }
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;

        TreeNode<T> replacement;

        if (n.isLeaf()) {
            // Case 1: no children
            replacement = null;
        }
        else if (n.hasRightChild() != n.hasLeftChild()) {
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
        }
        else {
            // Case 3: two children
            // TODO
            replacement = findSuccessor(n);
            delete(replacement);
            replacement.moveChildrenFrom(n);
        }

        // Put the replacement in its correct place, and set the parent.
        n.replaceWith(replacement);
        return replacement;
    }

    public T findPredecessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> predecessor = findPredecessor(n);
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> successor = findSuccessor(n);
            if (successor != null)
                return successor.key;
        }
        return null;
    }

    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        if (n.hasLeftChild()) {
            return findMax(n.leftChild);
        }

        TreeNode<T> temp = n.parent;
        while(temp != null && n == temp.leftChild) {
            n = temp;
            temp = temp.parent;
        }

        return temp;
    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        if (n.hasRightChild()) {
            return findMin(n.rightChild);
        }

        TreeNode<T> temp = n.parent;
        while(temp != null && n == temp.rightChild) {
            n = temp;
            temp = temp.parent;
        }

        return temp;
    }

    private TreeNode<T> findMin (TreeNode<T> n) {
        TreeNode<T> temp = n;

        if(n == null) {
            return null;
        }

        while(temp.leftChild != null) {
            temp = temp.leftChild;
        }

        return temp;
    }

    private TreeNode<T> findMax (TreeNode<T> n) {
        TreeNode<T> temp = n;

        while(temp.rightChild != null) {
            temp = temp.rightChild;
        }

        return temp;
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
