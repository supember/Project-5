package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a singly linked list.
 * 
 * @author Kali Liang (kaliang)
 * @version 2016.11.10
 * @param <T> Parameter type
 */
public class SinglyLinkedList<T> implements Iterable<T>
{
    /**
     * A node in SLL that stores data and points
     * you to the next node.
     * @param <T> Parameter type
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        /**
         * Creates a new node object.
         * @param d Data for the node
         */
        public Node(T d) {
            data = d;
        }
        
        /**
         * Creates a new node object.
         * @param d Data for the node
         * @param n Node to be next node
         */
        @SuppressWarnings("unused")
        public Node(T d, Node<T> n)
        {
            data = d;
            next = n;
        }

        /**
         * Sets the next node.
         * @param n Node to be set
         */
        public void setNext(Node<T> n) {
            next = n;
        }
        
        /**
         * Gets the next node.
         * @return  Next node
         */
        public Node<T> next() {
            return next;
        }
        
        /**
         * Gets the node's data.
         * @return  Data in the node
         */
        public T getData() {
            return data;
        }
    }
    
    private Node<T> head;
    private int size;
    
    /**
     * Creates a new SLL object.
     */
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Gets the size of the list.
     * @return The number of elements
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Adds an object to a position in the list.
     * @param index Where the object will be added
     * @param obj Object to be added
     * @throws IllegalArgumentException if object is null
     * @throws IndexOutOfBoundsException if index is < 0 or > size
     */
    public void add(int index, T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("obj is null");
        }
        if ((index > size()) || (index < 0))
        {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        Node<T> current = head;
        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else if (index == 0)
        {
            Node<T> n = head;
            head = new Node<T>(obj);
            head.setNext(n);
        }
        else
        {
            int currentIndex = 0;
            while (current != null)
            {
                if ((currentIndex + 1) == index)
                {
                    Node<T> next2 = current.next();
                    Node<T> newNode = new Node<T>(obj);
                    current.setNext(newNode);
                    newNode.setNext(next2);
                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }
    
    /**
     * Adds an object to the end of the list.
     * @param obj Object to be added
     * @throws IllegalArgumentException if object is null
     */
    public void add(T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("obj is null");
        }
        Node<T> current = head;
        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else
        {
            Node<T> newNode = new Node<T>(obj);
            while (current.next() != null)
            {
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
    }
    
    /**
     * Sees if the list is empty.
     * @return True if list is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    /**
     * Removes an object in the list.
     * @param obj Object to be removed
     * @return True if successfully removed
     */
    public boolean remove(T obj)
    {
        Node<T> current = head;
        if (current != null && obj.equals(current.getData()))
        {
            head = head.next();
            size--;
            return true;
        }
        while (size() >= 2 && (current.next() != null))
        {
            if ((obj.equals(current.next().getData())))
            {
                current.setNext(current.next().next());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }
    
    /**
     * Removes the object at a position in the list.
     * @param index Position of object to be removed
     * @return True if successfully removed
     * @throws IndexOutOfBoundsException if no element at index
     */
    public boolean remove(int index)
    {
        if (head == null || index < 0 || (index >= size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } 
        else
        {

            Node<T> current = head;
            int currentIndex = 0;

            if ((index == 0))
            {
                head = head.next();
                size--;
                return true;
            }

            while (current.next() != null)
            { 
                if ((currentIndex + 1) == index)
                {
                    Node<T> newNext = current.next().next();
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next();
                currentIndex++;
            }
            return false;
        }
    }
    
    /**
     * Gets the object at a position in the list
     * @param index Position of object
     * @return Object at position index
     * @throws IndexOutOfBoundsException if no node at index
     */
    public T get(int index)
    {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.getData();
            }
            currentIndex++;
            current = current.next();
        }

        if (data == null)
        {
            throw new IndexOutOfBoundsException("Index is bigger than size");
        }
        return data;
    }
    
    /**
     * Sees if the list has a certain object.
     * @param obj Object to be checked for
     * @return True if the list contains the object
     */
    public boolean contains(T obj)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (obj.equals(current.getData()))
            {
                return true;
            }
            current = current.next();
        }

        return false;
    }
    
    /**
     * Removes elements in the list.
     */
    public void clear()
    {
        if (head != null) 
        {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }
    
    /**
     * Checks if an object is equal to SLL.
     * @return True if they are the same
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        else if (obj == null)
        {
            return false;
        }
        else if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> temp = (SinglyLinkedList<T>)obj;
            if (size == temp.size() && temp.get(0).getClass()
                    == this.get(0).getClass())
            {
                boolean same = true;
                for (int i = 0; i < size; i++)
                {
                    if (!temp.get(i).equals(this.get(i)))
                    {
                        same = false;
                    }
                }
                return same;
            }
            
        }
        return false;
    }
    
    /**
     * Returns the list as a string in {}.
     * @return A string of the list
     */
    @Override
    public String toString()
    {
        String result = "{";

        Node<T> current = head;
        while (current != null)
        {
            result += "" + current.getData();
            current = current.next();
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
    
    /**
     * Creates an iterator for SLL.
     * @return SLListIterator for SLL
     */
    public Iterator<T> iterator()
    {
        return new SLListIterator();
    }
    
    /**
     * Nested SLListIterator in SLL that implements
     * iterator.
     */
    public class SLListIterator implements Iterator<T>
    {
        private Node<T> nextNode;
        private boolean nextCalled;

        /**
         * Creates an iterator.
         */
        public SLListIterator()
        {
            nextNode = head.next();
        }

        /**
         * Checks if there are more elements
         * in the list.
         * @return True if there are more elements
         */
        @Override
        public boolean hasNext()
        {
            return nextNode != null;
        }

        /**
         * Goes to the next element of the list.
         * @return Data of next element
         * @throws NoSuchElementException if there aren't any nodes left
         */
        public T next()
        {
            if (hasNext())
            {
                nextCalled = true;
                Node<T> n = nextNode;
                nextNode = nextNode.next();
                return n.getData();
            }
            else
            {
                throw new NoSuchElementException(
                        "Illegal next() call; No nodes left in list");
            }
        }
        
        /**
         * Removes an object from the list.
         * @throws IllegalStateException if not called or already removed
         */
        public void remove()
        {
            if (nextCalled && nextNode != null)
            {
                Node<T> previous = head;
                Node<T> current = head;
                int i = 1;
                while (current.next() != nextNode)
                {
                    if (i != 1)
                    {
                        previous = previous.next();
                    }
                    current = current.next();
                    i++;
                }
                previous.setNext(current.next());
                size--;
                nextCalled = false;
            }
            else
            {
                throw new IllegalStateException(
                        "not called or already removed");
            }
        }
    }
}