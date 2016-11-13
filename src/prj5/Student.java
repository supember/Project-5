package prj5;

public class Student
{
    private String major;
    private String hobby;
    private String region;
    private SinglyLinkedList<Boolean> responses;
    /**
     * Creates a new Student object.
     * 
     * @param major of the Student
     * @param hobby of the Student
     * @param region of the Student
     * @param responses of the Student
     */
    public Student(String major, String hobby, String region, SinglyLinkedList<Boolean> responses)
    {
        this.major = major;
        this.hobby = hobby;
        this.region = region;
        this.responses = responses;
    }
    /**
     * Returns the major of the Student.
     * @return major of the Student
     */
    public String getMajor()
    {
        return major;
    }
    /**
     * Returns the hobby of the Student.
     * @return hobby of the Student
     */
    public String getHobby()
    {
        return hobby;
    }
    /**
     * Returns the region of the Student. 
     * @return region of the Student
     */
    public String getregion()
    {
        return region;
    }
    /**
     * Returns the responses of the Student.
     * @return responses of the Student
     */
    public SinglyLinkedList<Boolean> getResponses()
    {
        return responses;
    }
}
