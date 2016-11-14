package prj5;
import student.TestCase;
/**
 * Tests the methods for Song.
 * @author Liam Reilly lhreilly
 * @version 2016.11.11
 */
public class SongTest extends TestCase
{
    private Song s1;
    private Song s2;
    private Song s3;
    private Song s4;
    /**
     * Sets up the variables used for this class.
     */
    public void setUp()
    {
        s1 = new Song("Nothing Left To Say/Rocks", "Imagine Dragons", 2011,
            "Alternative Rock");
        s2 = new Song("C'mon", "Panic! At The Disco", 2011, "Alternative");
        s3 = new Song("Neuanfang", "Clueso", 2016, "Alternative");
        s4 = new Song("Neuanfang", "Clueso", 2016, "Alternative");
    }
    /**
     * Tests the getArtist() method.
     */
    public void testGetArtist()
    {
        assertEquals("Imagine Dragons", s1.getArtist());
        assertEquals("Panic! At The Disco", s2.getArtist());
        assertEquals("Clueso", s3.getArtist());
        assertEquals("Clueso", s4.getArtist());
    }
    /**
     * Tests the getGenre() method.
     */
    public void testGetGenre()
    {
        assertEquals("Alternative Rock", s1.getGenre());
        assertEquals("Alternative", s2.getGenre());
        assertEquals("Alternative", s3.getGenre());
        assertEquals("Alternative", s4.getGenre());
    }
    /**
     * Tests the getTitle() method.
     */
    public void testGetTitle()
    {
        assertEquals("Nothing Left To Say/Rocks", s1.getTitle());
        assertEquals("C'mon", s2.getTitle());
        assertEquals("Neuanfang", s3.getTitle());
        assertEquals("Neuanfang", s4.getTitle());
    }
    /**
     * Tests the getYear() method.
     */
    public void testGetYear()
    {
        assertEquals(2011, s1.getYear());
        assertEquals(2011, s2.getYear());
        assertEquals(2016, s3.getYear());
        assertEquals(2016, s4.getYear());
    }
    /**
     * Tests the equals() method.
     */
    public void testEquals()
    {
        Song sNull = null;
        assertEquals(true, s1.equals(s1));
        assertEquals(false, s1.equals(s2));
        assertEquals(false, s1.equals(sNull));
        assertEquals(false, s1.equals(1));
        assertEquals(true, s3.equals(s4));
    }
    /**
     * Tests the toString() method.
     */
    public void testToString()
    {
        assertEquals("\"Nothing Left To Say/Rocks\" - Imagine Dragons (2011) :"
            + " Alternative Rock", s1.toString());
        assertEquals("\"C'mon\" - Panic! At The Disco (2011) : Alternative",
            s2.toString());
        assertEquals("\"Neuanfang\" - Clueso (2016) : Alternative",
            s3.toString());
        assertEquals("\"Neuanfang\" - Clueso (2016) : Alternative",
            s4.toString());
    }
}
