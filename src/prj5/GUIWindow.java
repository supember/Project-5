package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Window for the MusicPreferenceVisualization with all its functioning buttons
 * displaying glyphs.
 * 
 * @author Kali Liang (kaliang)
 * @version 2016.11.13
 */
public class GUIWindow
{
    private Window window;
    private Button quit;
    private Button prev;
    private Button next;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button sortArtist;
    private Button sortTitle;
    private Button sortYear;
    private Button sortGenre;

    private GUIGlyph[] glyph;
    private GUILegend legend;
    private int first;
    private int last;

    @SuppressWarnings("unused")
    private SinglyLinkedList<Song> songs;
    @SuppressWarnings("unused")
    private SinglyLinkedList<Student> students;
    private SinglyLinkedList<Song> sortedSongs;

    /**
     * Creates a new GUIWindow object.
     */
    public GUIWindow(SinglyLinkedList<Song> songs,
            SinglyLinkedList<Student> students)
    {
        this.songs = songs;
        this.students = students;

        sortedSongs = new SinglyLinkedList<Song>();
        for (int i = 0; i < songs.size(); i++)
        {
            sortedSongs.add(songs.get(i));
        }

        window = new Window("Project 5: lhrreilly hgong kaliang");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        representHobby = new Button("Represent Hobby");
        representHobby.onClick(this, "clickedHobby");
        representMajor = new Button("Represent Major");
        representMajor.onClick(this, "clickedMajor");
        representRegion = new Button("Represent Region");
        representRegion.onClick(this, "clickedRegion");

        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);

        prev = new Button("\u2190 Prev");
        prev.onClick(this, "clickedPrev");
        next = new Button("Next \u2192");
        next.onClick(this, "clickedNext");

        sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "sort(Artist)");
        sortTitle = new Button("Sort by Song Title");
        sortTitle.onClick(this, "sort(Title)");
        sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "sort(Year)");
        sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "sort(Genre)");

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortYear, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        legend = new GUILegend();

        glyph = new GUIGlyph[9];
        first = 0;
        last = 9;
        update();
    }

    /**
     * Gets the window for MusicPreferenceVisualization.
     * 
     * @return The window for MusicPreferenceVisualization
     */
    public Window getWindow()
    {
        return window;
    }

    /**
     * Quits out of the window when clicked.
     * 
     * @param button
     *            Button pressed to quit
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }

    public void update()
    {
        if (first == 0)
        {
            prev.disable();
        }
        else
        {
            prev.enable();
        }

        if (last >= sortedSongs.size() - 9)
        {
            next.disable();
        }
        else
        {
            next.enable();
        }
        
        sortTitle.enable();
        sortArtist.enable();
        sortGenre.enable();
        sortYear.enable();
        
        final int xIncrease = 200;
        final int yIncrease = 100;
        final int xStart = 25;
        int x = xStart;
        int y = 45;

        for (int i = first; i < last; i++)
        {
            if (this.glyph[i - first] != null)
            {
                this.glyph[i - first].clear();
            }

            this.glyph[i - first] = new GUIGlyph(x, y, sortedSongs.get(i));
            x += xIncrease;

            if (x - 3 * xIncrease == xStart)
            {
                x = xStart;
                y += yIncrease;
            }
        }
    }

    /**
     * Displays the previous page of glyphs when clicked.
     * 
     * @param button
     *            Button pressed to see prev
     */
    public void clickedPrev(Button button)
    {
        first = first - 9;
        last = last - 9;
        if (first < 0)
        {
            first = 0;
        }
        update();
    }

    /**
     * Displays the next page of glyphs when clicked.
     * 
     * @param button
     *            Button pressed to see next
     */
    public void clickedNext(Button button)
    {
        first = first + 9;
        last = last + 9;
        update();
    }
    
    public void represent(String str)
    {
        for (int i = 0; i < sortedSongs.size(); i++)
        {
            sortedSongs.get(i).updateRepresent(str);
        }
    }

    /**
     * Represents the data by student's categorized hobby. The legend also
     * changes to display a legend for hobbies.
     * 
     * @param button
     *            Button pressed to represent by hobby
     */
    public void clickedHobby(Button button)
    {
        this.represent("hobby");
        if (legend == null)
        {
            legend = new GUILegend();
        }
        legend.toHobby();
        update();
    }

    /**
     * Represents the data by student's categorized major. The legend also
     * changes to display a legend for majors.
     * 
     * @param button
     *            Button pressed to represent by major
     */
    public void clickedMajor(Button button)
    {
        this.represent("major");
        if (legend == null)
        {
            legend = new GUILegend();
        }
        legend.toMajor();
        update();
    }

    /**
     * Represents the data by student's categorized region. The legend also
     * changes to display a legend for regions.
     * 
     * @param button
     *            Button pressed to represent by region
     */
    public void clickedRegion(Button button)
    {
        this.represent("region");
        if (legend == null)
        {
            legend = new GUILegend();
        }
        legend.toRegion();
        update();
    }

    /**
     * Sorts the songs by the title.
     * 
     * @param title
     */
    public void sortTitle(String title)
    {
        SinglyLinkedList<Song> newList = new SinglyLinkedList<Song>();
        while (sortedSongs.size() > 0)
        {
            int smallIndex = 0;
            for (int i = 0; i < sortedSongs.size(); i++)
            {
                if (sortedSongs.get(i).getTitle()
                        .compareTo(sortedSongs.get(smallIndex).getTitle()) < 0)
                {
                    smallIndex = i;
                }
            }
            newList.add(sortedSongs.get(smallIndex));
            sortedSongs.remove(smallIndex);
        }
        sortedSongs = newList;
        update();
    }

    /**
     * Sorts the songs by the artist's name.
     * 
     * @param artist
     */
    public void sortArtist(String artist)
    {
        SinglyLinkedList<Song> newList = new SinglyLinkedList<Song>();
        while (sortedSongs.size() > 0)
        {
            int smallIndex = 0;
            for (int i = 0; i < sortedSongs.size(); i++)
            {
                if (sortedSongs.get(i).getArtist()
                        .compareTo(sortedSongs.get(smallIndex).getArtist()) < 0)
                {
                    smallIndex = i;
                }
            }
            newList.add(sortedSongs.get(smallIndex));
            sortedSongs.remove(smallIndex);
        }
        sortedSongs = newList;
        update();
    }

    /**
     * Sorts the songs by genre.
     * 
     * @param genre
     */
    public void sortGenre(String genre)
    {
        SinglyLinkedList<Song> newList = new SinglyLinkedList<Song>();
        while (sortedSongs.size() > 0)
        {
            int smallIndex = 0;
            for (int i = 0; i < sortedSongs.size(); i++)
            {
                if (sortedSongs.get(i).getGenre()
                        .compareTo(sortedSongs.get(smallIndex).getGenre()) < 0)
                {
                    smallIndex = i;
                }
            }
            newList.add(sortedSongs.get(smallIndex));
            sortedSongs.remove(smallIndex);
        }
        sortedSongs = newList;
        update();
    }

    /**
     * Sorts the songs by the release year.
     * 
     * @param date
     */
    public void sortYear(String year)
    {
        SinglyLinkedList<Song> newList = new SinglyLinkedList<Song>();
        while (sortedSongs.size() > 0)
        {
            int smallIndex = 0;
            for (int i = 0; i < sortedSongs.size(); i++)
            {
                if (sortedSongs.get(i).getYear() < sortedSongs.get(smallIndex).getYear())
                {
                    smallIndex = i;
                }
            }
            newList.add(sortedSongs.get(smallIndex));
            sortedSongs.remove(smallIndex);
        }
        sortedSongs = newList;
        update();
    }

    /**
     * Helper class that creates the legend.
     */
    private class GUILegend
    {
        private Shape border;
        private TextShape legend;
        private TextShape group1;
        private TextShape group2;
        private TextShape group3;
        private TextShape group4;
        private TextShape song;
        private Shape divider;
        private TextShape heard;
        private TextShape likes;

        private GUILegend()
        {
            border = new Shape(610, 103, 110, 147);
            border.setForegroundColor(Color.BLACK);
            border.setBackgroundColor(Color.WHITE);
            legend = new TextShape(615, 106, "Hobby Legend", Color.BLACK);
            legend.setBackgroundColor(Color.WHITE);

            group1 = new TextShape(615, 125, "Read", Color.MAGENTA);
            group1.setBackgroundColor(Color.WHITE);
            group2 = new TextShape(615, 140, "Art", Color.BLUE);
            group2.setBackgroundColor(Color.WHITE);
            group3 = new TextShape(615, 155, "Sports", Color.YELLOW);
            group3.setBackgroundColor(Color.WHITE);
            group4 = new TextShape(615, 170, "Music", Color.GREEN);
            group4.setBackgroundColor(Color.WHITE);
            song = new TextShape(630, 190, "Song Title", Color.BLACK);
            song.setBackgroundColor(Color.WHITE);

            divider = new Shape(665, 210, 5, 30);
            divider.setForegroundColor(Color.BLACK);
            divider.setBackgroundColor(Color.BLACK);
            heard = new TextShape(618, 215, "Heard", Color.BLACK);
            heard.setBackgroundColor(Color.WHITE);
            likes = new TextShape(672, 215, "Likes", Color.BLACK);
            likes.setBackgroundColor(Color.WHITE);

            window.addShape(legend);
            window.addShape(group1);
            window.addShape(group2);
            window.addShape(group3);
            window.addShape(group4);
            window.addShape(song);
            window.addShape(divider);
            window.addShape(heard);
            window.addShape(likes);
            window.addShape(border);
        }
        
        public void toHobby()
        {
            legend.setText("Hobby Legend");
            group1.setText("Read");
            group2.setText("Art");
            group3.setText("Sports");
            group4.setText("Music");
        }

        public void toMajor()
        {
            legend.setText("Major Legend");
            group1.setText("Comp Sci");
            group2.setText("Other Enge");
            group3.setText("Math/CMDA");
            group4.setText("Other");
        }

        public void toRegion()
        {
            legend.setText("Region Legend");
            group1.setText("Northeast US");
            group2.setText("Southeast US");
            group3.setText("Rest of US");
            group4.setText("Outside US");
        }
    }

    /**
     * Helper class that creates a glyph.
     */
    private class GUIGlyph
    {
        private TextShape title;
        private TextShape artist;
        private Shape divider;

        private Shape heard1;
        private Shape heard2;
        private Shape heard3;
        private Shape heard4;
        private Shape likes1;
        private Shape likes2;
        private Shape likes3;
        private Shape likes4;
        private static final int BAR_HEIGHT = 10;
        private static final int DIVIDER_WIDTH = 4;

        private GUIGlyph(int x, int y, Song song)
        {
            int heard1Width = song.getAvgHeard(1) / 2;
            int heard2Width = song.getAvgHeard(2) / 2;
            int heard3Width = song.getAvgHeard(3) / 2;
            int heard4Width = song.getAvgHeard(4) / 2;
            int likes1Width = song.getAvgLikes(1) / 2;
            int likes2Width = song.getAvgLikes(2) / 2;
            int likes3Width = song.getAvgLikes(3) / 2;
            int likes4Width = song.getAvgLikes(4) / 2;

            divider = new Shape(x + 50, y, DIVIDER_WIDTH, BAR_HEIGHT * 4,
                    Color.black);

            title = new TextShape(x + 50 - 3 * song.getTitle().length(), y - 40,
                    song.getTitle());
            artist = new TextShape(x + 50 - 3 * song.getArtist().length(),
                    y - 20, song.getArtist());

            title.setBackgroundColor(Color.white);
            artist.setBackgroundColor(Color.white);

            heard1 = new Shape(x + 50 - heard1Width, y, heard1Width, BAR_HEIGHT,
                    Color.MAGENTA);
            heard2 = new Shape(x + 50 - heard2Width, y + BAR_HEIGHT,
                    heard2Width, BAR_HEIGHT, Color.BLUE);
            heard3 = new Shape(x + 50 - heard3Width, y + 2 * BAR_HEIGHT,
                    heard3Width, BAR_HEIGHT, Color.YELLOW);
            heard4 = new Shape(x + 50 - heard4Width, y + 3 * BAR_HEIGHT,
                    heard4Width, BAR_HEIGHT, Color.GREEN);

            likes1 = new Shape(x + 50 + DIVIDER_WIDTH, y, likes1Width,
                    BAR_HEIGHT, Color.MAGENTA);
            likes2 = new Shape(x + 50 + DIVIDER_WIDTH, y + BAR_HEIGHT,
                    likes2Width, BAR_HEIGHT, Color.BLUE);
            likes3 = new Shape(x + 50 + DIVIDER_WIDTH, y + 2 * BAR_HEIGHT,
                    likes3Width, BAR_HEIGHT, Color.YELLOW);
            likes4 = new Shape(x + 50 + DIVIDER_WIDTH, y + 3 * BAR_HEIGHT,
                    likes4Width, BAR_HEIGHT, Color.GREEN);

            window.addShape(title);
            window.addShape(artist);
            window.addShape(divider);
            window.addShape(heard1);
            window.addShape(heard2);
            window.addShape(heard3);
            window.addShape(heard4);
            window.addShape(likes1);
            window.addShape(likes2);
            window.addShape(likes3);
            window.addShape(likes4);
        }

        public void clear()
        {
            window.removeShape(title);
            window.removeShape(artist);
            window.removeShape(divider);
            window.removeShape(heard1);
            window.removeShape(heard2);
            window.removeShape(heard3);
            window.removeShape(heard4);
            window.removeShape(likes1);
            window.removeShape(likes2);
            window.removeShape(likes3);
            window.removeShape(likes4);
        }
    }
}
