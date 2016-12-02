package prj5;

public class Song
{
    private String title;
    private String artist;
    private String genre;
    private int year;
    
    private int heard1;
    private int heard2;
    private int heard3;
    private int heard4;
    private int likes1;
    private int likes2;
    private int likes3;
    private int likes4;
    
    private int heard1Size;
    private int heard2Size;
    private int heard3Size;
    private int heard4Size;
    private int likes1Size;
    private int likes2Size;
    private int likes3Size;
    private int likes4Size;
    
    private SinglyLinkedList<Integer> heardResp;
    private SinglyLinkedList<Integer> likesResp;
    private SinglyLinkedList<Student> student;
    
    public Song(String songTitle, String songArtist,
            int songYear, String songGenre)
    {
        this.heardResp = new SinglyLinkedList<Integer>();
        this.likesResp = new SinglyLinkedList<Integer>();
        this.student = new SinglyLinkedList<Student>();
        
        title = songTitle;
        artist = songArtist;
        genre = songGenre;
        year = songYear;
    }
    
    public SinglyLinkedList<Integer> getHeardResp()
    {
        return heardResp;
    }
    
    public SinglyLinkedList<Integer> getLikesResp()
    {
        return likesResp;
    }
    
    public SinglyLinkedList<Student> getStudents()
    {
        return student;
    }
    
    public void addHeardEntry(int entry)
    {
        this.heardResp.add(entry);
    }
    
    public void addLikesEntry(int entry)
    {
        this.likesResp.add(entry);
    }
    
    public void addStudentEntry(Student student)
    {
        this.student.add(student);
    }
    /**
     * Returns the artist of this Song.
     * @return artist of this Song
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * Returns the title of this Song.
     * @return title of this Song
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Returns the genre of this Song.
     * @return genre of this Song
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Returns the year of this Song.
     * @return year of this Song
     */
    public int getYear()
    {
        return year;
    }
        
    public void updateRepresent(String represent)
    {
        heard1 = 0;
        likes1 = 0;
        heard1Size = 0;
        likes1Size = 0;
        
        heard2 = 0;
        likes2 = 0;
        heard2Size = 0;
        likes2Size = 0;
        
        heard3 = 0;
        likes3 = 0;
        heard3Size = 0;
        likes3Size = 0;
        
        heard4 = 0;
        likes4 = 0;
        heard4Size = 0;
        likes4Size = 0;
        
        if (represent.equals("hobby"))
        {
            for (int i = 0; i < student.size(); i++)
            {
                if (student.get(i).getHobby().equals(HobbyEnum.READ))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard1Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard1++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes1Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes1++;
                        }
                    }
                }
                else if (student.get(i).getHobby().equals(HobbyEnum.ART))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard2Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard2++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes2Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes2++;
                        }
                    }
                }
                else if (student.get(i).getHobby().equals(HobbyEnum.SPORTS))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard3Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard3++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes3Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes3++;
                        }
                    }
                }
                else
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard4Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard4++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes4Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes4++;
                        }
                    }
                }
            }
        }
        else if (represent.equals("major"))
        {
            for (int i = 0; i < student.size(); i++)
            {
                if (student.get(i).getMajor().equals(MajorEnum.COMPSCI))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard1Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard1++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes1Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes1++;
                        }
                    }
                }
                else if (student.get(i).getMajor().equals(MajorEnum.OTHERENG))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard2Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard2++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes2Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes2++;
                        }
                    }
                }
                else if (student.get(i).getMajor().equals(MajorEnum.MATHCMDA))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard3Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard3++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes3Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes3++;
                        }
                    }
                }
                else
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard4Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard4++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes4Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes4++;
                        }
                    }
                }
            }
        }
        else if (represent.equals("region"))
        {
            for (int i = 0; i < student.size(); i++)
            {
                if (student.get(i).getRegion().equals(RegionEnum.NORTHEAST))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard1Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard1++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes1Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes1++;
                        }
                    }
                }
                else if (student.get(i).getRegion().equals(RegionEnum.SOUTHEAST))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard2Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard2++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes2Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes2++;
                        }
                    }
                }
                else if (student.get(i).getRegion().equals(RegionEnum.OTHERUS))
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard3Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard3++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes3Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes3++;
                        }
                    }
                }
                else
                {
                    if (heardResp.get(i) != 0)
                    {
                        heard4Size++;
                        if (heardResp.get(i) == 1)
                        {
                            heard4++;
                        }
                    }
                    if (likesResp.get(i) != 0)
                    {
                        likes4Size++;
                        if (likesResp.get(i) == 1)
                        {
                            likes4++;
                        }
                    }
                }
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    
    public int getAvgHeard(int group)
    {
        if (group == 1)
        {
            return (int) (100 * (heard1 * 1.0) / heard1Size);
        }
        else if (group == 2)
        {
            return (int) (100 * (heard2 * 1.0) / heard2Size);
        }
        else if (group == 3)
        {
            return (int) (100 * (heard3 * 1.0) / heard3Size);
        }
        else if (group == 4)
        {
            return (int) (100 * (heard4 * 1.0) / heard4Size);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    
    public int getAvgLikes(int group)
    {
        if (group == 1)
        {
            return (int) (100 * (likes1 * 1.0) / likes1Size);
        }
        else if (group == 2)
        {
            return (int) (100 * (likes2 * 1.0) / likes2Size);
        }
        else if (group == 3)
        {
            return (int) (100 * (likes3 * 1.0) / likes3Size);
        }
        else if (group == 4)
        {
            return (int) (100 * (likes4 * 1.0) / likes4Size);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    
    @Override
    public String toString()
    {
        return ("Song Title: " + title + "\nSong Artist: " + artist
                + "\nSong Genre: " + genre + "\nSong Year: " + year);
    }
}
