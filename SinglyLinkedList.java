package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import bag.Node;

public class SinglyLinkedList<T> implements Iterable<T>
{
    private static class Node<D> {

        private D data;
        private Node<D> next;

        public Node(D d) {
            data = d;
        }
        
        public Node(D d, Node<D> n)
        {
            data = d;
            next = n;
        }

        public void setNext(Node<D> n) {
            next = n;
        }
        
        public Node<D> next() {
            return next;
        }
        
        public D getData() {
            return data;
        }
    }
    
    private Node<T> head;
    private int size;
    
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }
    
    public int size()
    {
        return size;
    }
    
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
            while (current.next != null)
            {
                current = current.next();
            }
        }
        size++;
    }
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    public boolean remove(T obj)
    {
        Node<T> current = head;
        if ((obj.equals(current.data)) && (null != head))
        {
            head = head.next();
            size--;
            return true;
        }
        while ((current.next != null) && (size() >= 2))
        {
            if ((obj.equals(current.next.data)))
            {
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
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
                head = head.next;
                size--;
                return true;
            }

            while (current.next != null)
            { 
                if ((currentIndex + 1) == index)
                {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            return false;
        }
    }
    
    public T get(int index)
    {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        if (data == null)
        {
            throw new IndexOutOfBoundsException("Index is bigger than size");
        }
        return data;
    }
    
    public boolean contains(T obj)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }
    
    public void clear()
    {
        if (head != null) 
        {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }
    
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        else if(obj == null)
        {
            return false;
        }
        else if(this.getClass() == obj.getClass())
        {
            SinglyLinkedList<T> temp = (SinglyLinkedList<T>)obj;
            if (size == temp.size() && temp.get(0).getClass() == this.get(0).getClass())
            {
                boolean same = true;
                for(int i = 0; i < size; i++)
                {
                    if(!temp.get(i).equals(this.get(i)))
                    {
                        same = false;
                    }
                }
                return same;
            }
            
        }
        return false;
    }
    
    public String toString()
    {
        String result = "{";

        Node<T> current = head;
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
    
    public Iterator<T> iterator()
    {
        return new SLListIterator();
    }
    
    public class SLListIterator implements Iterator<T>
    {
        private Node<T> nextNode;
        private boolean nextCalled;

        public SLListIterator()
        {
            nextNode = head.next();
        }

        
        public boolean hasNext()
        {
            return nextNode != null;
        }

        
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
    }
}
