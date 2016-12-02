package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Accepts input from various files to create lists of Songs or responses, based
 * on which version of the constructor is used.
 * 
 * @author Liam Reilly lhreilly
 * @version 2016.11.13
 */
public class Input
{
    private static String songFileName;
    private static String studentFileName;

    public static void main(String[] args)
    {
        songFileName = "SongList.csv";
        studentFileName = "MusicSurveyData.csv";
        SinglyLinkedList<Song> songs = readSongFile(songFileName);
        SinglyLinkedList<Student> students = readStudentFile(studentFileName);

        GUIWindow window = new GUIWindow(songs, students);
        
        for (int i = 0; i < songs.size(); i++)
        {
            Song s = songs.get(i);
            int totalReadingHeard = 0;
            int totalSportsHeard = 0;
            int totalMusicHeard = 0;
            int totalArtHeard = 0;

            int totalReadingLiked = 0;
            int totalSportsLiked = 0;
            int totalMusicLiked = 0;
            int totalArtLiked = 0;

            int readingHeard = 0;
            int sportsHeard = 0;
            int musicHeard = 0;
            int artHeard = 0;

            int readingLiked = 0;
            int sportsLiked = 0;
            int musicLiked = 0;
            int artLiked = 0;
            
			int totalMathcmdaHeard = 0;
            int totalCompsciHeard = 0;
            int totalOtherengHeard = 0;
            int totalOtherHeard = 0;

            int totalMathcmdaLiked = 0;
            int totalCompsciLiked = 0;
            int totalOtherengLiked = 0;
            int totalOtherLiked = 0;

            int mathcmdaHeard = 0;
            int compsciHeard = 0;
            int otherengHeard = 0;
            int otherHeard = 0;

            int mathcmdaLiked = 0;
            int compsciLiked = 0;
            int otherengLiked = 0;
            int otherLiked = 0;
            
			int totalNortheastHeard = 0;
            int totalSoutheastHeard = 0;
            int totalOutofususHeard = 0;
            int totalOutofusHeard = 0;

            int totalNortheastLiked = 0;
            int totalSoutheastLiked = 0;
            int totalOutofususLiked = 0;
            int totalOutofusLiked = 0;

            int northeastHeard = 0;
            int southeastHeard = 0;
            int outofususHeard = 0;
            int outofusHeard = 0;

            int northeastLiked = 0;
            int southeastLiked = 0;
            int outofususLiked = 0;
            int outofusLiked = 0;
            
            for (Student st : students)
            {
                if (st.getHobby() == HobbyEnum.READ)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            readingHeard++;
                        }
                        totalReadingHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            readingLiked++;
                        }
                        totalReadingLiked++;
                    }
                }
                if (st.getHobby() == HobbyEnum.SPORTS)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            sportsHeard++;
                        }
                        totalSportsHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            sportsLiked++;
                        }
                        totalSportsLiked++;
                    }
                }
                if (st.getHobby() == HobbyEnum.MUSIC)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            musicHeard++;
                        }
                        totalMusicHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            musicLiked++;
                        }
                        totalMusicLiked++;
                    }
                }
                if (st.getHobby() == HobbyEnum.ART)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            artHeard++;
                        }
                        totalArtHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            artLiked++;
                        }
                        totalArtLiked++;
                    }
                }
                if (st.getHobby() == MajorEnum.MATHCMDA)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            mathcmdaHeard++;
                        }
                        totalMathcmdaHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            mathcmdaLiked++;
                        }
                        totalMathcmdaLiked++;
                    }
                }
                if (st.getHobby() == MajorEnum.COMPSCI)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            compsciHeard++;
                        }
                        totalCompsciHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            compsciLiked++;
                        }
                        totalCompsciLiked++;
                    }
                }
                if (st.getHobby() == MajorEnum.OTHERENG)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            otherengHeard++;
                        }
                        totalOtherengHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            otherengLiked++;
                        }
                        totalOtherengLiked++;
                    }
                }
                if (st.getHobby() == MajorEnum.OTHER)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            otherHeard++;
                        }
                        totalOtherHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            otherLiked++;
                        }
                        totalOtherLiked++;
                    }
                }
                if (st.getHobby() == RegionEnum.NORTHEAST)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            northeastHeard++;
                        }
                        totalNortheastHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            northeastLiked++;
                        }
                        totalNortheastLiked++;
                    }
                }
                if (st.getHobby() == RegionEnum.SOUTHEAST)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            southeastHeard++;
                        }
                        totalSoutheastHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            southeastLiked++;
                        }
                        totalSoutheastLiked++;
                    }
                }
                if (st.getHobby() == RegionEnum.OUTOFUSUS)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            outofususHeard++;
                        }
                        totalOutofususHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            outofususLiked++;
                        }
                        totalOutofususLiked++;
                    }
                }
                if (st.getHobby() == RegionEnum.OUTOFUS)
                {
                    if (!st.getHeardLiked(i)[0].equals(""))
                    {
                        if (st.getHeardLiked(i)[0].equals("Yes"))
                        {
                            outofusHeard++;
                        }
                        totalOutofusHeard++;
                    }
                    if (!st.getHeardLiked(i)[1].equals(""))
                    {
                        if (st.getHeardLiked(i)[1].equals("Yes"))
                        {
                            outofusLiked++;
                        }
                        totalOutofusLiked++;
                    }
                }
            }
            System.out.println("Song Title: " + s.getTitle());
            System.out.println("Song Artist: " + s.getArtist());
            System.out.println("Song Genre: " + s.getGenre());
            System.out.println("Song Year: " + s.getYear());
            System.out.println("Heard");
            System.out.println("reading:"
                    + (readingHeard * 100) / Math.max(1, totalReadingHeard)
                    + " art:" + (artHeard * 100) / Math.max(1, totalArtHeard)
                    + " sports:"
                    + (sportsHeard * 100) / Math.max(1, totalSportsHeard)
                    + " music:"
                    + (musicHeard * 100) / Math.max(1, totalMusicHeard));
            System.out.println("compsci:"
                    + (compsciHeard * 100) / Math.max(1, totalCompsciHeard)
                    + " othereng:" + (otherengHeard * 100) / Math.max(1, totalOtherengHeard)
                    + " mathcmda:"
                    + (mathcmdaHeard * 100) / Math.max(1, totalMathcmdaHeard)
                    + " other:"
                    + (otherHeard * 100) / Math.max(1, totalOtherHeard));
            System.out.println("northeast:"
                    + (northeastHeard * 100) / Math.max(1, totalNortheastHeard)
                    + " southeast:" + (southeastHeard * 100) / Math.max(1, totalSoutheastHeard)
                    + " outofusus:"
                    + (outofususHeard * 100) / Math.max(1, totalOutofususHeard)
                    + " outofus:"
                    + (outofusHeard * 100) / Math.max(1, totalOutofusHeard));
            System.out.println("Likes");
            System.out.println("reading:"
                    + (readingLiked * 100) / Math.max(1, totalReadingLiked)
                    + " art:" + (artLiked * 100) / Math.max(1, totalArtLiked)
                    + " sports:"
                    + (sportsLiked * 100) / Math.max(1, totalSportsLiked)
                    + " music:"
                    + (musicLiked * 100) / Math.max(1, totalMusicLiked));
            System.out.println("compsci:"
                    + (compsciLiked * 100) / Math.max(1, totalCompsciLiked)
                    + " othereng:" + (otherengLiked * 100) / Math.max(1, totalOtherengLiked)
                    + " mathcmda:"
                    + (mathcmdaLiked * 100) / Math.max(1, totalMathcmdaLiked)
                    + " other:"
                    + (otherLiked * 100) / Math.max(1, totalOtherLiked));
            System.out.println("northeast:"
                    + (northeastLiked * 100) / Math.max(1, totalNortheastLiked)
                    + " southeast:" + (southeastLiked * 100) / Math.max(1, totalSoutheastLiked)
                    + " outofusus:"
                    + (outofususLiked * 100) / Math.max(1, totalOutofususLiked)
                    + " outofus:"
                    + (outofusLiked * 100) / Math.max(1, totalOutofusLiked));
            System.out.println();
            
        }
    }

    /**
     * Creates a new list of songs from a song file.
     * 
     * @param fileName
     *            to use for Song source
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
        } catch (FileNotFoundException e)
        {
            // e.printStackTrace();
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
            MajorEnum m;
            HobbyEnum h;
            RegionEnum r;
            SinglyLinkedList<String> responses = null;
            while (file.hasNextLine())
            {
                m = null;
                h = null;
                r = null;
                responses = new SinglyLinkedList<String>();
                String[] strings = file.nextLine().split(",");
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
                    case "United States (other than Southeast or Northwest)":
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
            // e.printStackTrace();
        }
        return list;
    }
}
