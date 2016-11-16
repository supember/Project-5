package prj5;

import student.TestCase;

/**
 * Tests the methods in SinglyLinkedList.
 * 
 * @author Kali Liang (kaliang)
 * @version 2016.11.13
 */
public class SinglyLinkedListTest extends TestCase
{
    private SinglyLinkedList<String> list;
    private SinglyLinkedList<String> list2;

    /**
     * Set up for testing
     */
    public void setUp()
    {
        list = new SinglyLinkedList<String>();
        list2 = new SinglyLinkedList<String>();
        list.add("glasses");
        list.add(0, "necklace");
    }

    /**
     * Tests the size() method.
     */
    public void testSize()
    {
        assertEquals(list.size(), 2, 0.01);
        list.add("glasses");
        assertEquals(list.size(), 3, 0.01);
    }

    /**
     * Tests the add(int index, T obj) method.
     */
    public void testAdd()
    {
        SinglyLinkedList<String> tList = new SinglyLinkedList<String>();
        tList.add(0, "phone");
        assertEquals(tList.get(0), "phone");
        assertEquals(list.get(0), "necklace");
        assertEquals(list.size(), 2, 0.01);
        list.add(1, "pillow");
        assertEquals(list.get(1), "pillow");
        assertEquals(list.get(2), "glasses");
        assertEquals(list.size(), 3, 0.01);
        list.add(3, "bag");
        assertEquals(list.get(3), "bag");
        assertEquals(list.size(), 4, 0.01);
    }

    /**
     * Tests the add(int index, T obj) method.
     */
    public void testAddException()
    {
        Exception exception = null;
        String nullTest = null;
        try
        {
            list.add(1, nullTest);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests the add(int index, T obj) method.
     */
    public void testAddException2()
    {
        Exception exception = null;
        try
        {
            list.add(-1, "phone");
            list.add(45, "phone");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        @SuppressWarnings("unused")
        Exception exception2 = null;
        try
        {
            list.add(45, "phone");
        }
        catch (Exception e)
        {
            exception2 = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests the add(T obj).
     */
    public void testAdd2()
    {
        list.add("phone");
        assertEquals(list.get(2), "phone");
        assertEquals(list.size(), 3, 0.01);
    }

    /**
     * Tests the add( obj) method.
     */
    public void testAdd2Exception()
    {
        Exception exception = null;
        String nullTest = null;
        try
        {
            list.add(nullTest);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty()
    {
        assertFalse(list.isEmpty());
        assertEquals(list.size(), 2, 0.01);
        list.clear();
        assertEquals(list.size(), 0, 0.01);
        assertTrue(list.isEmpty());
    }

    /**
     * Tests the get(T obj) method.
     */
    public void testRemove()
    {
        SinglyLinkedList<String> tList = new SinglyLinkedList<String>();
        tList.add("blob");
        tList.add("bloop");
        assertTrue(tList.remove("blob"));
        SinglyLinkedList<String> tList2 = new SinglyLinkedList<String>();
        assertFalse(tList2.remove("blob"));
        list.add("dog"); 
        assertTrue(list.remove("glasses"));
        assertEquals(list.size(), 2, 0.01);
        assertEquals(list.get(1), "dog");
        assertFalse(list.remove("phone"));
        assertEquals(list.size(), 2, 0.01);
    }

    /**
     * Tests the remove(int index) method.
     */
    public void testRemove2()
    {
        SinglyLinkedList<String> tList = new SinglyLinkedList<String>();
        tList.add("a");
        assertTrue(tList.remove(0));
        assertTrue(list.remove(1)); 
        assertEquals(list.size(), 1, 0.01);
        assertEquals(list.get(0), "necklace");
        list.add("asdf");
        assertTrue(list.remove(0));
    }

    /**
     * Tests the remove(int index) method.
     */
    public void testRemove2Exception()
    {
        SinglyLinkedList<String> tList = new SinglyLinkedList<String>();
        Exception exception = null;
        try
        {
            tList.remove(0);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);

        @SuppressWarnings("unused")
        Exception exception2 = null;
        try
        {
            list.remove(-1);
        }
        catch (Exception e)
        {
            exception2 = e;
        }
        assertNotNull(exception);
        
        @SuppressWarnings("unused")
        Exception exception3 = null;
        try
        {
            list.remove(45);
        }
        catch (Exception e)
        {
            exception3 = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests the get(int index) method.
     */
    public void testGet()
    {
        assertEquals(list.get(0), "necklace");
        assertEquals(list.get(1), "glasses");
    }

    /**
     * Tests the get(int index) method.
     */
    public void testGetException()
    {
        Exception exception = null;
        try
        {
            list.get(2);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests the contains(T obj) method.
     */
    public void testContains()
    {
        assertTrue(list.contains("glasses"));
        assertFalse(list.contains("phone"));
        list.remove("glasses");
        assertFalse(list.contains("glasses"));
        list.add("blob");
        assertTrue(list.contains("blob"));
        list.remove(1);
        assertFalse(list.contains("blob"));
    }

    /**
     * Tests the clear() method.
     */
    public void testClear()
    {
        assertEquals(list2.size(), 0, 0.01);
        list2.clear();
        assertEquals(list2.size(), 0, 0.01);
        assertEquals(list.size(), 2, 0.01);
        list.clear();
        assertEquals(list.size(), 0, 0.01);
        assertEquals(list.toString(), "{}");
    }
    
    /**
     * Tests the equals() method.
     */
    public void testEquals()
    {
        list2.add("glasses");
        list2.add(0, "necklace");
        assertTrue(list.equals(list));
        assertTrue(list.equals(list2));
        
        SinglyLinkedList<String> test = null;
        SinglyLinkedList<String> test2 = new SinglyLinkedList<String>();
        SinglyLinkedList<Integer> test3 = new SinglyLinkedList<Integer>();
        double d = 0.5;
        
        assertFalse(list.equals(test));
        assertFalse(list.equals(test2));
        assertFalse(list.equals(test3));
        assertFalse(list.equals(d));
    }

    /**
     * Tests the toString() method.
     */
    public void testToString()
    {
        assertEquals(list.toString(), "{necklace, glasses}");
        list.remove("glasses");
        assertEquals(list.toString(), "{necklace}");
    }
}