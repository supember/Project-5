package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Accepts input from various files to create lists of Songs or responses,
 * based on which version of the constructor is used.
 * @author Liam Reilly lhreilly
 * @version 2016.11.13
 */
public class Input
{
    private static String songFileName;
    private static String studentFileName;
    public static void main(String[] args)
    {
        songFileName = args[1];
        studentFileName = args[0];
        SinglyLinkedList<Song> songs = readSongFile(songFileName);
        SinglyLinkedList<Student> students = readStudentFile(studentFileName);
        for (int i = 0; i < songs.size(); i++)
        {
            Song s = songs.get(i);
            int totalReading = 0;
            int totalSports = 0;
            int totalMusic = 0;
            int totalArt = 0;
            int readingHeard = 0;
            int sportsHeard = 0;
            int musicHeard = 0;
            int artHeard = 0;
            int readingLiked = 0;
            int sportsLiked = 0;
            int musicLiked = 0;
            int artLiked = 0;
            for (Student st: students)
            {
                if (st.getHobby() == HobbyEnum.READ)
                {
                    if (st.getHeardLiked(i) != null)
                    {
                        totalReading++;
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            readingHeard++;
                        }
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            readingLiked++;
                        }
                    }
                }
                if (st.getHobby() == HobbyEnum.SPORTS)
                {
                    if (st.getHeardLiked(i) != null)
                    {
                        totalSports++;
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            sportsHeard++;
                        }
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            sportsLiked++;
                        }
                    }
                }
                if (st.getHobby() == HobbyEnum.MUSIC)
                {
                    if (st.getHeardLiked(i) != null)
                    {
                        totalMusic++;
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            musicHeard++;
                        }
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            musicLiked++;
                        }
                    }
                }
                if (st.getHobby() == HobbyEnum.ART)
                {
                    if (st.getHeardLiked(i) != null)
                    {
                        totalArt++;
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            artHeard++;
                        }
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            artLiked++;
                        }
                    }
                }
            }
            System.out.println("Song Title: " + s.getTitle());
            System.out.println("Song Artist: " + s.getArtist());
            System.out.println("Song Genre: " + s.getGenre());
            System.out.println("Song Year: " + s.getYear());
            System.out.println("Heard");
            System.out.println("reading:" + (readingHeard * 100) /
                Math.max(1, totalReading) + " art:" + (artHeard * 100) /
                Math.max(1, totalArt) + " sports:" + (sportsHeard * 100) / 
                Math.max(1, totalSports) + " music:" + (musicHeard * 100) /
                Math.max(1, totalMusic));
            System.out.println("Likes");
            System.out.println("reading:" + (readingLiked * 100) /
                Math.max(1, totalReading) + " art:" + (artLiked * 100) /
                Math.max(1, totalArt) + " sports:" + (sportsLiked * 100) / 
                Math.max(1, totalSports) + " music:" + (musicLiked * 100) /
                Math.max(1, totalMusic));
        }
    }
    /**
     * Creates a new list of songs from a song file.
     * @param fileName to use for Song source
     * @return a new list of Songs
     */
    private static SinglyLinkedList<Song> readSongFile(String fileName)
    {
        SinglyLinkedList<Song> list = new SinglyLinkedList<Song>();
        try
        {
            Scanner file = new Scanner(new File(fileName));
            file.nextLine();
            while (file.hasNextLine())
            {
                String[] strings = file.nextLine().split(" *, *");
                list.add(new Song(strings[0], strings[1],
                    Integer.parseInt(strings[2]), strings[3]));
            }
            file.close();
        }
        catch (FileNotFoundException e)
        {
            //e.printStackTrace();
        }
        return list;
    }
    private static SinglyLinkedList<Student> readStudentFile(String fileName)
    {
        SinglyLinkedList<Student> list = new SinglyLinkedList<Student>();
        try
        {
            Scanner file = new Scanner(new File(fileName));
            file.nextLine();
            MajorEnum m = null;
            HobbyEnum h = null;
            RegionEnum r = null;
            SinglyLinkedList<String> responses = null;
            while (file.hasNextLine())
            {
                responses = new SinglyLinkedList<String>();
                String[] strings = file.nextLine().split(" *, *");
                if (strings.length > 2)
                {
                    switch (strings[2])
                    {
                        case "Math or CMDA":
                            m = MajorEnum.MATHCMDA;
                            break;
                        case "Computer Science":
                            m = MajorEnum.COMPSCI;
                            break;
                        case "Other Engineering":
                            m = MajorEnum.OTHERENG;
                            break;
                        case "Other":
                            m = MajorEnum.OTHER;
                            break;
                        default:
                            m = null;
                            break;
                    }
                    switch (strings[4])
                    {
                        case "sports":
                            h = HobbyEnum.SPORTS;
                            break;
                        case "reading":
                            h = HobbyEnum.READ;
                            break;
                        case "music":
                            h = HobbyEnum.MUSIC;
                            break;
                        case "art":
                            h = HobbyEnum.ART;
                            break;
                        default:
                            h = null;
                            break;
                    }
                    switch (strings[3])
                    {
                        case "Northeast":
                            r = RegionEnum.NORTHEAST;
                            break;
                        case "Southeast":
                            r = RegionEnum.SOUTHEAST;
                            break;
                        case
                        "United States (other than Southeast or Northwest)":
                            r = RegionEnum.OTHERUS;
                            break;
                        case "Outside of United States":
                            r = RegionEnum.OUTOFUS;
                            break;
                        default:
                            r = null;
                            break;
                    }
                    for (int i = 5; i < strings.length; i++)
                    {
                        responses.add(strings[i]);
                    }
                    Student s = new Student(m, h, r, responses);
                    list.add(s);
                }
            }
            file.close();
        }
        catch (FileNotFoundException e)
        {
            //e.printStackTrace();
        }
        return list;
    }
}
