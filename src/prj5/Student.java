package prj5;

public class Student
{
    private MajorEnum major;
    private HobbyEnum hobby;
    private RegionEnum region;
    private SinglyLinkedList<Boolean> responses;
    /**
     * Creates a new Student object.
     * 
     * @param major of the Student
     * @param hobby of the Student
     * @param region of the Student
     * @param responses of the Student
     */
    public Student(MajorEnum major, HobbyEnum hobby, RegionEnum region,
    		SinglyLinkedList<Boolean> responses)
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
    public MajorEnum getMajor()
    {
        return major;
    }
    /**
     * Returns the hobby of the Student.
     * @return hobby of the Student
     */
    public HobbyEnum getHobby()
    {
        return hobby;
    }
    /**
     * Returns the region of the Student. 
     * @return region of the Student
     */
    public RegionEnum getRegion()
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
    /**
     * Returns the two Booleans indicating whether or not a student heard and
     * liked a Song of a certain ID.
     * @param songID ID of song to return from list of responses
     * @return a Boolean array of {heard, liked}, representing whether the
     *         Student heard and/or liked the song.
     */
    public Boolean[] getHeardLiked(int songID)
    {
        Boolean heard;
        Boolean liked;
        heard = responses.get(songID * 2);
        liked = responses.get((songID * 2) + 1);
        Boolean[] heardLiked = {heard, liked};
        return heardLiked;
    }
}
