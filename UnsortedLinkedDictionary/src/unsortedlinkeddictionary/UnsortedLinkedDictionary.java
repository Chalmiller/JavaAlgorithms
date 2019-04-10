
package unsortedlinkeddictionary;


import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class UnsortedLinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>  {
    private int numberOfEntries;
    private Node firstNode; // reference to first node of chain private int numberOfEntries;

    public UnsortedLinkedDictionary() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor
	
    public V add(K key, V value) {
        V result = null;
        // search chain until you either find a node containing key // or pass the point where it should be
        Node currentNode = firstNode;
        Node nodeBefore = null;
        while ( (currentNode != null) && key.compareTo(currentNode.getKey()) > 0 ) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        if ( (currentNode != null) && key.equals(currentNode.getKey()) ) {
            result = currentNode.getValue();
            currentNode.setValue(value); // replace value
        } else {
            Node newNode = new Node(key, value); 
            if (nodeBefore == null) { // add at beginning (includes empty chain)
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else {
                newNode.setNextNode(currentNode); // currentNode is after new // node
                nodeBefore.setNextNode(newNode); // nodeBefore is before new
                } // end if
             } // end if
        return result;
    } // end add

    public V remove(K key) {
        V result = null;
        
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while ( (currentNode != null) && key.compareTo(currentNode.getKey()) > 0 ) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } if ( (currentNode != null) && key.equals(currentNode.getKey()) ) {
            result = currentNode.getValue();
            currentNode.setValue(null); // replace value
        } 
        
        return result;
    } // end remove

    public V getValue(K key) {
        V result = null;
        Node currentNode = firstNode;
        Node nodeBefore = null;
        while ( (currentNode != null) && key.compareTo(currentNode.getKey()) > 0 ) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        if ( (currentNode != null) && key.equals(currentNode.getKey()) ) {
            result = currentNode.getValue();
        }
        
        return result;
    } // end getValue

    public boolean contains(K key) {
        boolean result = false;
        
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while ( (currentNode != null) && key.compareTo(currentNode.getKey()) > 0 ) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        if ( (currentNode != null) && key.equals(currentNode.getKey()) ) {
            result = true;
        }
        
        return result;
    } // end contains

    public boolean isEmpty() {
        boolean result = false;
        
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while (currentNode == null) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        if (currentNode != null) {
            result = true;
        }
        
        return result;
    } // end isEmpty

    public int getSize() {
        int count = 0;
        
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while (currentNode != null) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
            count++;
        } // end while
        
        return count;
    } // end getSize

    public final void clear() { 
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while (currentNode != null) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
            currentNode.setValue(null);
        } // end while
    } // end clear

    private class getKeyIterator implements Iterator<K> {
        private Node nextNode; // node containing next entry in iteration
        
        private getKeyIterator() {
              nextNode = firstNode;
           } // end default constructor
        
        public boolean hasNext() {
            return nextNode != null; 
        } // end hasNext
        
        public K next() {
            K result;
            if (hasNext()) {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException();
            }
            
            return result; 
            } // end next
        public void remove() {
            throw new UnsupportedOperationException(); 
        } // end remove
    } // end KeyIterator

    private class getValueIterator implements Iterator<V> {
        private Node nextNode; // node containing next entry in iteration
        
        private getValueIterator() {
              nextNode = firstNode;
           } // end default constructor
        
        public boolean hasNext() {
            return nextNode != null; 
        } // end hasNext
        
        public V next() {
            V result;
            if (hasNext()) {
                result = nextNode.getValue();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException();
            }
            
            return result; 
            } // end next
        public void remove() {
            throw new UnsupportedOperationException(); 
        } // end remove
    } // end getValueIterator

    private class Node {
            private K key;
            private V value;
            private Node next;

            private Node(K searchKey, V dataValue) {
                    key = searchKey;
                    value = dataValue;
                    next = null;	
            } // end constructor

            private Node(K searchKey, V dataValue, Node nextNode) {
                    key = searchKey;
                    value = dataValue;
                    next = nextNode;	
            } // end constructor

            private K getKey() {
                    return key;
            } // end getKey

            private V getValue() {
                    return value;
            } // end getValue

            private void setValue(V newValue) {
                    value = newValue;
            } // end setValue

            private Node getNextNode()
            {
                    return next;
            } // end getNextNode

            private void setNextNode(Node nextNode) {
                    next = nextNode;
            } // end setNextNode
    } // end Node
} // end UnsortedLinkedDictionary
		

