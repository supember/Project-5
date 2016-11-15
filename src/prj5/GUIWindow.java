package prj5;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Window for the MusicPreferenceVisualization
 * with all its functioning buttons displaying glyphs.
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
    private Shape hobbyLegend;
    private Shape majorLegend;
    private Shape regionLegend;
    //private Glyph glyph;
    
    /**
     * Creates a new GUIWindow object.
     */
    public GUIWindow()
    {
        window = new Window("lhrreilly hgong kaliang");
        
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
        
        //Temp Default Legend for Intermediate Submission
        Shape border = new Shape(610, 103, 110, 147);
        border.setForegroundColor(Color.BLACK);
        border.setBackgroundColor(Color.WHITE);
        TextShape legend = new TextShape(615, 106, "Hobby Legend", Color.BLACK);
        legend.setBackgroundColor(Color.WHITE);
        
        TextShape read = new TextShape(615, 125, "Read", Color.MAGENTA);
        read.setBackgroundColor(Color.WHITE);
        TextShape art = new TextShape(615, 140, "Art", Color.BLUE);
        art.setBackgroundColor(Color.WHITE);
        TextShape sports = new TextShape(615, 155, "Sports", Color.YELLOW);
        sports.setBackgroundColor(Color.WHITE);
        TextShape music = new TextShape(615, 170, "Music", Color.GREEN);
        music.setBackgroundColor(Color.WHITE);
        TextShape song = new TextShape(630, 190, "Song Title", Color.BLACK);
        song.setBackgroundColor(Color.WHITE);
        
        
        Shape divider = new Shape(665, 210, 5, 30);
        divider.setForegroundColor(Color.BLACK);
        divider.setBackgroundColor(Color.BLACK);
        TextShape heard = new TextShape(618, 215, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        TextShape likes = new TextShape(672, 215, "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        
        window.addShape(legend);
        window.addShape(read);
        window.addShape(art);
        window.addShape(sports);
        window.addShape(music);
        window.addShape(song);
        window.addShape(divider);
        window.addShape(heard);
        window.addShape(likes);
        window.addShape(border);
        
        //Temp Glyph for Intermediate Submission
        TextShape songtitle = new TextShape(100, 20, "All You Need Is Love", Color.BLACK);
        songtitle.setBackgroundColor(Color.WHITE);
        TextShape extra = new TextShape(120, 35, "by the Beatles", Color.BLACK);
        extra.setBackgroundColor(Color.WHITE);
        
        Shape bar = new Shape(165, 55, 7, 60);
        bar.setForegroundColor(Color.BLACK);
        bar.setBackgroundColor(Color.BLACK);
        
        Shape a = new Shape(90, 55, 150, 15);
        a.setForegroundColor(Color.MAGENTA);
        a.setBackgroundColor(Color.MAGENTA);
        Shape b = new Shape(100, 70, 130, 15);
        b.setForegroundColor(Color.BLUE);
        b.setBackgroundColor(Color.BLUE);
        Shape c = new Shape(80, 85, 165, 15);
        c.setForegroundColor(Color.YELLOW);
        c.setBackgroundColor(Color.YELLOW);
        Shape d = new Shape(115, 100, 100, 15);
        d.setForegroundColor(Color.GREEN);
        d.setBackgroundColor(Color.GREEN);
        
        window.addShape(songtitle);
        window.addShape(extra);
        window.addShape(bar);
        window.addShape(a);
        window.addShape(b);
        window.addShape(c);
        window.addShape(d);
    }
    
    /**
     * Gets the window for MusicPreferenceVisualization.
     * @return The window for MusicPreferenceVisualization
     */
    public Window getWindow()
    {
        return window;
    }
    
    /**
     * Quits out of the window when clicked.
     * @param button    Button pressed to quit
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
    
    /**
     * Displays the previous page of glyphs when clicked.
     * @param button    Button pressed to see prev
     */
    public void clickedPrev(Button button)
    {
        //TODO
    }
    
    /**
     * Displays the next page of glyphs when clicked.
     * @param button    Button pressed to see next
     */
    public void clickedNext(Button button)
    {
        //TODO
    }
    
    /**
     * Represents the data by student's categorized hobby.
     * The legend also changes to display a legend for hobbies.
     * @param button    Button pressed to represent by hobby
     */
    public void clickedHobby(Button button)
    {
        //TODO
        window.addShape(hobbyLegend);
    }
    
    /**
     * Represents the data by student's categorized major.
     * The legend also changes to display a legend for majors.
     * @param button    Button pressed to represent by major
     */
    public void clickedMajor(Button button)
    {
        //TODO
        window.addShape(majorLegend);
    }
    
    /**
     * Represents the data by student's categorized region.
     * The legend also changes to display a legend for regions.
     * @param button    Button pressed to represent by region
     */
    public void clickedRegion(Button button)
    {
        //TODO
        window.addShape(regionLegend);
    }
    
    /**
     * Sorts the songs by the artist's name.
     * @param artist
     */
    public void sortArtist(String artist)
    {
        //TODO
    }
    
    /**
     * Sorts the songs by the title.
     * @param title
     */
    public void sortTitle(String title)
    {
        //TODO
    }
    
    /**
     * Sorts the songs by genre.
     * @param genre
     */
    public void sortGenre(String genre)
    {
        //TODO
    }
    
    /**
     * Sorts the songs by the release year.
     * @param date
     */
    public void sortYear(String year)
    {
        //TODO
    }
    
    /**
     * Creates the displayed legend for when "Represent
     * Hobby" is clicked.
     * @return Legend for hobbies
     */
//    private Shape hobbyLegend()
//    {
//        //TODO
//    }
//    
//    /**
//     * Creates the displayed legend for when "Represent
//     * Major" is clicked.
//     * @return Legend for majors
//     */
//    private Shape majorLegend()
//    {
//        //TODO
//    }
//    
//    /**
//     * Creates the displayed legend for when "Represent
//     * Region" is clicked.
//     * @return Legend for regions
//     */
//    private Shape regionLegend()
//    {
//        //TODO
//    }
}
