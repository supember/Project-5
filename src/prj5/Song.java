package prj5;
/**
 * Represents a song and several of its attributes.
 * @author Liam Reilly lhreilly
 * @version 2016.11.11
 */
public class Song
{
    private int year;
    private String title;
    private String artist;
    private String genre;
    /**
     * Creates a new Song object.
     * @param title of the Song
     * @param artist of the Song
     * @param year of the Song
     * @param genre of the Song
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
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
    /**
     * Tells whether an object is equal to this Song object. Returns true if
     * the title, artist, year, and genre match, false if otherwise.
     * @param obj to be compared to this Song object
     * @return true if the title, artist, year, and genre match this Song's,
     *         false if otherwise
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() == this.getClass())
        {
            Song other = (Song)obj;
            return artist.equals(other.getArtist()) && year == other.getYear()
                && title.equals(other.getTitle()) &&
                genre.equals(other.getGenre());
        }
        return false;
    }
    /**
     * Returns a String representation of this Song object. Follows the format:
     * "Title" - Artist (Year) : Genre
     * @return a String representation of this Song
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("\"" + title + "\" - ");
        sb.append(artist + " (" + year + ") : " + genre);
        return sb.toString(); 
    }
}
