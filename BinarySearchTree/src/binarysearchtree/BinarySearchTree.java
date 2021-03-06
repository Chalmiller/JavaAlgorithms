package binarysearchtree;


public class BinarySearchTree < T extends Comparable < ? super T >>
{
    
    private BinaryNode<T> root;
    
    public BinarySearchTree () {
	root = null;
    } 
    
    public BinarySearchTree (T rootData) {
		root = new BinaryNode<T>(rootData);
    } 
    
    public T get(T entry) {
        return getEntry (root, entry);
    } 

    private T getEntry (BinaryNode<T> rootNode, T entry) {
        T result = null;
        if (rootNode != null) {
            T rootEntry = rootNode.getData ();
            if (entry.compareTo(rootEntry) == 0)
                result = rootEntry;
            else if (entry.compareTo(rootEntry) < 0)
                result = getEntry(rootNode.getLeftChild (), entry);
            else
                result = getEntry(rootNode.getRightChild (), entry);
        } 
        return result;
    }

    public boolean contains (T entry) {
        return get(entry) != null;
    }
    
    // Adds newEntry to the nonempty subtree rooted at rootNode.
    private T addEntry (BinaryNode< T > rootNode, T newEntry) {
        // assume that rootNode is NOT null
        T result = null;
        int comparison = newEntry.compareTo (rootNode.getData ());
        if (comparison == 0) { // duplicates NOT allowed
            result = rootNode.getData ();
            rootNode.setData (newEntry);
        }
        else if (comparison < 0) {
            if (rootNode.hasLeftChild ())
                result = addEntry (rootNode.getLeftChild (), newEntry);
            else
                rootNode.setLeftChild (new BinaryNode < T > (newEntry));
        }
        else {
            if (rootNode.hasRightChild ())
                result = addEntry (rootNode.getRightChild (), newEntry);
            else
                rootNode.setRightChild (new BinaryNode < T > (newEntry));
        } // end if
        return result;
    } // end addEntry


    public T add (T newEntry) {
        T result = null;
        if (root == null)
            root = new BinaryNode<T>(newEntry);
        else
            result = addEntry (root, newEntry);
        return result;
    } // end add

    class ReturnObject {
	T data;
	public void set(T newData) { data = newData; }
	public T get() { return data; }
    }

    public T remove (T entry) {
        ReturnObject oldEntry = new ReturnObject();
        BinaryNode<T> newRoot = removeEntry (root, entry, oldEntry);
        root = newRoot;
        return oldEntry.get ();
    } // end remove
    
    // Removes an entry from the tree rooted at a given node.
    // rootNode is a reference to the root of a tree.
    // entry is the object to be removed.
    // oldEntry is an object whose data field is null.
    // Returns the root node of the resulting tree; if entry matches
    // an entry in the tree, oldEntry's data field is the entry
    // that was removed from the tree; otherwise it is null.
	// 
	// Why removeEntry returns BinaryNode<T>
	//    Answer: To return a new modified tree: example root node removed so root of tree will change
    private BinaryNode<T> removeEntry (BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
        if (rootNode != null) {
            T rootData = rootNode.getData ();
            int comparison = entry.compareTo (rootData);
            if (comparison == 0) { // entry == root entry
                oldEntry.set (rootData);
                rootNode = removeFromRoot (rootNode);
            }
            else if (comparison < 0) { // entry < root entry
                BinaryNode<T> leftChild = rootNode.getLeftChild ();
                BinaryNode<T> newLeftChild = removeEntry(leftChild, entry, oldEntry);
                rootNode.setLeftChild (newLeftChild);
            }
            else { // entry > root entry
                BinaryNode< T > rightChild = rootNode.getRightChild ();
				BinaryNode<T> newRightChild = removeEntry (rightChild, entry, oldEntry);
				rootNode.setRightChild (newRightChild);
            } 
        } 
        return rootNode;
    } 
    
    // Removes the entry in a given root node of a subtree.
    // rootNode is the root node of the subtree.
    // Returns the root node of the revised subtree.
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
        // Case 1: rootNode has two children
        if (rootNode.hasLeftChild () && rootNode.hasRightChild ())
        {
            // find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild ();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            // replace entry in root
            rootNode.setData (largestNode.getData ());
            // remove node with largest entry in left subtree
            rootNode.setLeftChild (removeLargest(leftSubtreeRoot));
        } // end if
        // Case 2: rootNode has at most one child
        else if (rootNode.hasRightChild ())
            rootNode = rootNode.getRightChild ();
        else
            rootNode = rootNode.getLeftChild ();
        return rootNode;
    }
    
    // Finds the node containing the largest entry in a given tree.
    // rootNode is the root node of the tree.
    // Returns the node containing the largest entry in the tree.
    private BinaryNode<T> findLargest (BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild ())
            rootNode = findLargest (rootNode.getRightChild ());
        return rootNode;
    } 
    
    // Removes the node containing the largest entry in a given tree.
    // rootNode is the root node of the tree.
    // Returns the root node of the revised tree.
    private BinaryNode<T> removeLargest (BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild()) {
	    BinaryNode<T> rightChild = rootNode.getRightChild ();
	    BinaryNode<T> root = removeLargest (rightChild);
	    rootNode.setRightChild (root);
        }
        else
            rootNode = rootNode.getLeftChild ();
        return rootNode;
    }
    class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
// A wrapper class used to modify height across 
// recursive calls. 
class Height 
{ 
    int height = 0; 
} 
  
class BinaryTree { 
  
    Node root; 
  
    boolean isBalanced(Node root, Height height) { 
        if (root == null) 
        { 
            height.height = 0; 
            return true; 
        } 
  
        Height lheight = new Height(), rheight = new Height(); 
        boolean l = isBalanced(root.left, lheight); 
        boolean r = isBalanced(root.right, rheight); 
        int lh = lheight.height, rh = rheight.height; 
  
        height.height = (lh > rh? lh: rh) + 1; 
  
        if ((lh - rh >= 2) || 
            (rh - lh >= 2)) 
            return false; 
  
        else return l && r; 
    } 
  
    int height(Node node) { 
        if (node == null) 
            return 0; 
            return 1 + Math.max(height(node.left), height(node.right)); 
        } 
  
     
    }
    public boolean isBST(Node root) {
        return isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }

    public boolean isBST(Node p, double min, double max){
        if(p==null) 
            return true;

        if(p.data <= min || p.data >= max)
            return false;

        return isBST(p.left, min, p.data) && isBST(p.right, p.data, max);
    }
    
    private int getPredecessor(Node root, Node pre, Node suc, T Entry)  { 
        if (root == null) {
            return 0;
        } 

        if (root == Entry) { 
            if (root.left != null) 
            { 
                Node tmp = root.left; 
                while (tmp.right != null) 
                    tmp = tmp.right; 
                pre = tmp; 
            } 

            if (root.right != null) { 
                Node tmp = root.right ; 
                while (tmp.left != null) 
                    tmp = tmp.left ; 
                suc = tmp ; 
            } 
            return pre.data; 
        } 
  
        if (root.data > pre.data) { 
            suc = root ; 
            getPredecessor(root.left, pre, suc, Entry) ; 
        } 
        else { 
            pre = root ; 
            getPredecessor(root.right, pre, suc, Entry) ; 
        } 
        return root.data;
    }
}
