package edu.loaders.csvparsers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is to create Book object
 */
public class Book {

  /**
   * These are the field variables in the class Book.
   */
  protected long isbn = 0;
  protected String title = "unknown";
  protected String author = "unknown";
  protected int pages = 0;
  protected String editor = "none";

  private String genre = "";
  private final Set<String> GENRES = new HashSet<>(Arrays.asList("fantasy", "non-fiction",
      "manga", "instructional", "scifi", "folktales", "romance", "high-fantasy", "mystery"));

  private int internalPrice = 0;

  /**
   * This is the constructor of the class Book that contains parameters of:
   * @param isbn of type long.
   * @param title of type String.
   * @param author of type String.
   * @param pages of type int.
   * @param editor of type String.
   * @param genre of type String.
   * @param price of type double.
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

  /**
   * This is an overloaded constructor  that has parameter:
   * @param csvLine of type String[].
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

  /**
   * This is an overloaded constructor that has no parameter nor content.
   */
  public Book() {

  }

  /**
   * This method retrieves String author from constructor.
   * @return the name of the author.
   */
  public String getAuthor() { return author; }

  /**
   * This method retrieves int internalPrice from the field variable.
   * @return internalPrice that is stored in the field variable.
   */
  public int getInternalPrice() {
    return internalPrice;
  }

  /**
   * This method manipulates internalPrice.
   * @return the internalPrice that has been divided by 100.
   */
  public double getPrice() {
    return internalPrice / 100.0;
  }

  /**
   * This method overrides the internalPrice with new price that has been multiplied by 100.
   * @param the new price
   */
  public void setPrice(double price) {
    this.internalPrice = (int) (price * 100);
  }

  /**
   * This method overrides genre with the new genre. If genre is not listed in GENRES field variable set, then
   * it overrides String genre field variable with "other".
   * @param genre
   */
  public void setGenre(String genre) {
    if (GENRES.contains(genre)) {
      this.genre = genre;
    } else {
      this.genre = "other";
    }
  }

  /**
   * This method presents an object as String when its printed.
   * @return the desired presentation of the object in String.
   */
  @Override
  public String toString() {
    return isbn + ",'" + title + "','"
        + author + "'," + pages
        + ",'" + editor + "','"
        + genre + "'," + getPrice() + "\n";
  }

  /**
   * This method retrieves title from the constructor.
   * @return the title of the book.
   */
  public String getTitle() { return title;  }
}
