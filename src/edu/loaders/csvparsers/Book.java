package edu.loaders.csvparsers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Book {
    protected long isbn = 0;
    protected String title = "unknown";
    protected String author = "unknown";
    protected int pages = 0;
    protected String editor = "none";

    private String genre = "";
    private final Set<String> GENRES = new HashSet<>(Arrays.asList("fantasy", "non-fiction",
            "manga", "instructional", "scifi", "folktales", "romance", "high-fantasy", "mystery"));

    private int internalPrice = 0;

    public Book(long isbn, String title, String author, int pages, String editor,
                String genre, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.editor = editor;
        setGenre(genre);
        setPrice(price);
    }

    public Book(String[] csvLine) {
        isbn = Long.parseLong(csvLine[0]);
        title = csvLine[1].substring(1, csvLine[1].length()-1);
        author = csvLine[2].substring(1, csvLine[2].length()-1);
        pages = Integer.parseInt(csvLine[3]);
        editor = csvLine[4].substring(1, csvLine[4].length()-1);
        setGenre(csvLine[5].substring(1, csvLine[5].length()-1));
        setPrice(Double.parseDouble(csvLine[6]));
    }

    /** A constructor for the Book class. (isbn, title, author)
     *
     * the constructor for the Book class if
     * ISBN, Title, and, Author are passed into the class.
     * All of other class fields are set to default values
     * or calculated later.
     *
     * @param isbn
     *  The International Standard Book Number, of the book.
     *  (Example: 9783161484100)
     * @param title
     *  The title of the book.
     * @param author
     *  The Last name of the Author of the book.
     */
    public Book(long isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    /** A constructor for the Book class (isbn, title, author, price)
     *
     * the constructor for the Book class if
     * ISBN, Title, Author,and Price are passed into the class.
     * All of other class fields are set to default values
     * or calculated later.
     *
     * @param isbn
     *  The International Standard Book Number, of the book.
     *  (Example: 9783161484100)
     * @param title
     *  The title of the book.
     * @param author
     *  the last name of the author of the book.
     * @param price
     *  The price of the books in dollars and cents (i.e. 19.99)
     *  needs to be converted to cents (i.e. 1999)
     *  to do any sort of calculations on the price,
     *  like calculating taxes.
     */
    public Book(long isbn, String title, String author, double price){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        // convert to cents for more accurate calculations
        // and stores it in internalPrice
        setPrice(price);

    }

    /** A constructor for the Book class. (isbn, title, author, genre)
     *
     * the constructor for the Book class if
     * ISBN, Title, Author,and Genre are passed into the class.
     * All of other class fields are set to default values
     * or calculated later.
     *
     * @param isbn
     * The International Standard Book Number, of the book.
     * (Example: 9783161484100)
     * @param title
     *  The title of the book.
     * @param author
     *  The last name of the author of the book.
     * @param genre
     *  The genre of the book.
     */
    public Book(long isbn, String title, String author, String genre){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        // to ensure they set a standard genre (i.e. SCI-FI, Romance, etc.),
        // if not then the genre will be set to "other"
        setGenre(genre);
    }

    /** A constructor for the Book class (isbn, title, price)
     *
     * the constructor for the Book class if
     * ISBN, Title, and Price are passed into the class.
     * All of other class fields are set to default values
     * or calculated later.
     *
     * @param isbn
     * The International Standard Book Number, of the book.
     * (Example: 9783161484100)
     * @param title
     * The title of the book.
     * @param price
     *  The price of the books in dollars and cents (i.e. 19.99)
     *  needs to be converted to cents (i.e. 1999)
     *  to do any sort of calculations on the price,
     *  like calculating taxes.
     */
    public Book(long isbn, String title, double price){
        this.isbn = isbn;
        this.title = title;
        // convert to cents for more accurate calculations
        // and stores it in internalPrice
        setPrice(price);

    }

    public Book() {

    }

    public String getAuthor() { return author; }

    public int getInternalPrice() {
        return internalPrice;
    }

    public double getPrice() {
        return internalPrice / 100.0;
    }

    public void setPrice(double price) {
        this.internalPrice = (int) (price * 100);
    }

    public void setGenre(String genre) {
        if (GENRES.contains(genre)) {
            this.genre = genre;
        } else {
            this.genre = "other";
        }
    }

    @Override
    public String toString() {
        return isbn + ",'" + title + "','"
                + author + "'," + pages
                + ",'" + editor + "','"
                + genre + "'," + getPrice() + "\n";
    }

    public String getTitle() { return title;  }
}
