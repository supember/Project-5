package prj5;

public class Student
{
    private String major;
    private String hobby;
    private String state;
    private SinglyLinkedList<Boolean> responses;
    
    public Student(String major, String hobby, String state, SinglyLinkedList<Boolean> responses)
    {
        this.major = major;
        this.hobby = hobby;
        this.state = state;
        this.responses = responses;
    }
    public String getMajor()
    {
        return major;
    }
    public String getHobby()
    {
        return hobby;
    }
    public String getState()
    {
        return state;
    }
    public Boolean getResponses()
    {
        return responses;
    }
}
