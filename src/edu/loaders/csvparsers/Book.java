package edu.loaders.csvparsers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Book {
  // Uses unknown or none if the title, author, or editor is blank or not given
  protected long isbn = 0;
  protected String title = "unknown";
  protected String author = "unknown";
  protected int pages = 0;
  protected String editor = "none";

  private String genre = "";
  private final Set<String> GENRES = new HashSet<>(Arrays.asList("fantasy", "non-fiction",
      "manga", "instructional", "scifi", "folktales", "romance", "high-fantasy", "mystery"));

  private int internalPrice = 0;

 /** Constructor to create book objects with all arguments
 *   and calls the setGenre and setPrice methods to set 
 *   the genre and internal price.
 *   @param isbn the isbn number of the book
 *   @param title the title of the book
 *   @param author the first and last name of the author of the book
 *   @param pages the number of pages the book has
 *   @param eidtor the first and last name of the editor of the book
 *   @param genre the genre of the book
 *   @param price the price of the book in dollars and cents
 */
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
  
` /** Constructs a book object using a passed string array and
  *   sets each element in array to a clas variable and
  *   calls the setGenre mathod and setPrice method
  *   @param csvLine the comma seperated value which contains
  *   the isbn, title, author, pages, editor
  */
  public Book(String[] csvLine) {
    isbn = Long.parseLong(csvLine[0]);
    title = csvLine[1].substring(1, csvLine[1].length()-1);
    author = csvLine[2].substring(1, csvLine[2].length()-1);
    pages = Integer.parseInt(csvLine[3]);
    editor = csvLine[4].substring(1, csvLine[4].length()-1);
    setGenre(csvLine[5].substring(1, csvLine[5].length()-1));
    setPrice(Double.parseDouble(csvLine[6]));
  }

  /** Constructor to create Book object with no given arguments
  */
  public Book() {

  }
  
  /** Returns the stored author of the Book object
  *   @return the first and last name of the author of the book
  */
  public String getAuthor() { return author; }
  
  /** Returns the price of the book in cents
  *   @return the price of the book in cents
  */
  public int getInternalPrice() {
    return internalPrice;
  }
  
  /** Returns the price of the book as a double (dollars and cents) 
  *   @return the price of the book in dollars and cents
  */
  public double getPrice() {
    return internalPrice / 100.0;
  }
  
  /** Sets the internal price to the passed price of the book
  *   in cents
  *   @param price the price of the book in dollars and cents
  */
  public void setPrice(double price) {
    this.internalPrice = (int) (price * 100);
  }
  
  /** Sets the passed genre to one of the genres of the 
  *   GENRES set or "other" otherwise
  *   @param genre the genre of the book as a String
  */
  public void setGenre(String genre) {
    if (GENRES.contains(genre)) {
      this.genre = genre;
    } else {
      this.genre = "other";
    }
  }
  
  /** Returns all the class variables and the price
  *   of the book
  *   @return the isbn, title, author, pages, editor, genre, and price of the book as a string
  */
  @Override
  public String toString() {
    return isbn + ",'" + title + "','"
        + author + "'," + pages
        + ",'" + editor + "','"
        + genre + "'," + getPrice() + "\n";
  }
  
  /** Returns the title of the book
  *   @return the title of the book as a string
  */
  public String getTitle() { return title;  }
}
