/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

//package TreePackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack ; // for Stack

public class BinaryTree<T>
{
    protected BinaryNode<T> root;
    
    public BinaryTree() {
	     root = null;
    } // end default constructor
    
    public BinaryTree(T rootData) {
	     root = new BinaryNode<T>(rootData);
    } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, 
                                 BinaryTree<T> rightTree) {
       privateSetTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData)
   {
      root = new BinaryNode<T>(rootData);
   } // end setTree
   
   public void setTree(T rootData, BinaryTree<T> leftTree,
		       BinaryTree<T> rightTree)
   {
      privateSetTree(rootData, leftTree, rightTree);
   } // end setTree

   private void privateSetTree(T rootData, BinaryTree<T> leftTree, 
                                          BinaryTree<T> rightTree)
   {
    
      root = new BinaryNode<T>(rootData);

      if (leftTree != null)
	       root.setLeftChild(leftTree.root);
         
      if (rightTree != null)
         root.setRightChild(rightTree.root);
   } 

   public T getRootData () {
        T rootData = null;
        if (root != null)
            rootData = root.getData();
        return rootData;
   }
   public boolean isEmpty () {
       return root == null;
   }
   public void clear (){
       root = null;
   }
   // getHeight and getNumberOfNodes call same functions in BinaryNode<T>
   public int getHeight () {
       return root.getHeight ();
   } 
   public int getNumberOfNodes () {
       return root.getNumberOfNodes ();
   }
   
   public void inorderTraversal() {
       Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
       BinaryNode<T> currentNode = root;
       
       while (!nodeStack.empty() || currentNode != null) {
      	   while(currentNode != null) {
      	       nodeStack.push(currentNode);
      	       currentNode = currentNode.getLeftChild();
      	   }
      	   if(!nodeStack.empty()) {
      	       BinaryNode<T> nextNode = nodeStack.pop();
      	       System.out.println(nextNode.getData());
      	       currentNode = nextNode.getRightChild();
      	   }
       }
   }
   
   public Iterator<T> getPreorderIterator() {
       return new PreorderIterator();
   }
   
   public Iterator<T> getInorderIterator() {
       return new InorderIterator();
   }
   
   private class PreorderIterator implements Iterator<T> {
       private Stack<BinaryNode<T>> nodeStack;
       
       public PreorderIterator() {
	   nodeStack = new Stack<BinaryNode<T>>();
	   if (root != null)
	       nodeStack.push(root);
       } // end default constructor
       
       public boolean hasNext()  {
	   return !nodeStack.isEmpty();
       } // end hasNext
       
       public T next() {
	   BinaryNode<T> nextNode;
	   
	   if (hasNext()) {
	       nextNode = nodeStack.pop();
	       BinaryNode<T> leftChild = nextNode.getLeftChild();
	       BinaryNode<T> rightChild = nextNode.getRightChild();
	       
	       // push into stack in reverse order of recursive calls
	       if (rightChild != null)
		   nodeStack.push(rightChild);
	       
	       if (leftChild != null)
		   nodeStack.push(leftChild);
	   }
	   else {
	       throw new NoSuchElementException();
	   }
	   return nextNode.getData();
       } // end next
       
       public void remove() {
	   throw new UnsupportedOperationException();
       } // end remove
   } // end PreorderIterator
    
   private class InorderIterator implements Iterator < T >
   {
       private Stack< BinaryNode < T >> nodeStack;
       private BinaryNode< T > currentNode;
       public InorderIterator () {
	   nodeStack = new Stack < BinaryNode< T >> ();
	   currentNode = root;
       } // end default constructor


       public boolean hasNext () {
	   return !nodeStack.isEmpty () || (currentNode != null);
       } // end hasNext


       public T next ()
       {
	   BinaryNode< T > nextNode = null;
	   // find leftmost node with no left child
	   while (currentNode != null) {
	       nodeStack.push (currentNode);
	       currentNode = currentNode.getLeftChild ();
	   } // end while
	   // get leftmost node, then move to its right subtree
	   if (!nodeStack.isEmpty ()) {
	       nextNode = nodeStack.pop ();
	       currentNode = nextNode.getRightChild ();
	   }
	   else
	       throw new NoSuchElementException ();
	   return nextNode.getData ();
       } // end next
       
       
       public void remove () {
	   throw new UnsupportedOperationException ();
       } // end remove

   } // end InorderIterator
   
   public int count1(T anObject) {
        BinaryNode<T> rootNode = root;
        
        return count1(rootNode, anObject);
   }
   
   private int count1(BinaryNode<T> rootNode, T anObject) {
       int count = 0;
        // if it's null, it doesn't exist, return 0 
        while (rootNode.getData() != null) {
            if (rootNode.getData() == anObject) {
                count = 1 + count1(rootNode.getLeftChild(), anObject) + count1(rootNode.getRightChild(), anObject);
            } else {
                return 0;
            }
        }
        return count;
   }
   
   public int count2(T anObject) {
       BinaryNode<T> rootNode = root;
       Iterator<T> iterator = getPreorderIterator();
       int count = 0;
       int nodeHeight = rootNode.getNumberOfNodes() -1; 
       
       while (nodeHeight != 0) {
           if (root == anObject) {
               count += 1;
           } else if (iterator.next() == anObject) {
               count += 1;
           } else {
               nodeHeight -= 1;
           }
       }
       return count;
   }
   
   public boolean isIsomorphic(BinaryTree<T> otherTree) {
       BinaryTree<T> newTree1 = new BinaryTree();
       
       return isIsomorphic(otherTree, newTree1);
   }
   
   private boolean isIsomorphic(BinaryTree<T> otherTree, BinaryTree<T> thisTree) {
        Iterator<T> iterator = getPreorderIterator();
        BinaryTree<T> newTree = new BinaryTree(iterator.next());
        
        if (iterator.next() == null || otherTree.getRootData() == null)
            return root == otherTree.root;  // i.e. both null

        if (root.getData() != otherTree.getRootData())
            return false;

        return isIsomorphic(newTree);
   }
} // end BinaryTree

