package prj5;

import student.TestCase;

/**
 * Tests the methods in Student.
 * 
 * @author Hyung Gong (hgong)
 * @version 2016.11.14
 */
public class StudentTest extends TestCase
{
    private Student student;
    
    /**
     * Set up for testing.
     */
    public void setUp()
    {
        SinglyLinkedList<String> responses = new SinglyLinkedList<String>();
        responses.add("true");
        responses.add("false");
        student = new Student(MajorEnum.COMPSCI, HobbyEnum.SPORTS, 
                RegionEnum.NORTHEAST, responses);
    }
    /**
     * Tests the getMajor() method.
     */
    public void testGetMajor()
    {
        assertEquals(student.getMajor(), MajorEnum.COMPSCI);
    }
    /**
     * Tests the getHobby() method.
     */
    public void testGetHobby()
    {
        assertEquals(student.getHobby(), HobbyEnum.SPORTS);
    }
    /**
     * Tests the getRegion() method.
     */
    public void testGetRegion()
    {
        assertEquals(student.getRegion(), RegionEnum.NORTHEAST);
    }
    /**
     * Tests the getResponses() method.
     */
    public void testGetResponses()
    {
        assertEquals(student.getResponses().size(), 2);
        assertEquals(student.getHeardLiked(0)[0], "true");
        assertEquals(student.getHeardLiked(0)[1], "false");
    }
}