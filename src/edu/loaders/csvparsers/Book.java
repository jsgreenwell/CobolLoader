package edu.loaders.csvparsers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Book {
  /**
   * Defining the idenditifying features of each book and setting it to the default
   * characteristics (this is in case a certain characteristic is unknown or undefined).
   * This is private as the defaults will be kept internal until assigned to a book.
   */
  protected long isbn = 0;
  protected String title = "unknown";
  protected String author = "unknown";
  protected int pages = 0;
  protected String editor = "none";

  /* 
   * Setting GENRES as a hashset as it is an unordered collection containing unique
   * elements. These unique elements are the different genres that each book could
   * be classified under (ex. Fantasy, non-fiction, manga, etc.).
   */
  private String genre = "";
  private final Set<String> GENRES = new HashSet<>(Arrays.asList("fantasy", "non-fiction",
      "manga", "instructional", "scifi", "folktales", "romance", "high-fantasy", "mystery"));
  
  // internalPrice is private as it is only meant for internal company, not the public.
  private int internalPrice = 0;

  /* 
   * Setting each book with the previously defined indentifying features (altering the
   * default settings) and setting the correct genre and price.
   * This is public as this is what will be shown and allowed to be accessed by
   * customers.
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

  /*
   *  This allows the book to set information to it by accessing the information in the
   *  csvLine (sets isbn, title, author, pages, editor, genre, and price).
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

  /*
   * This allows for someone to pass the name of a book into this function and 
   * return other information and identifying features in order to learn more
   * about the book details or find it in the building.
   */
  public Book() {

  }

  // This operates to find the books author
  public String getAuthor() { return author; }

  // This operates to find get the internal price of the book
  public int getInternalPrice() {
    return internalPrice;
  }

  // This operates to find the external price of the book
  public double getPrice() {
    return internalPrice / 100.0;
  }

  // This operates to set the internal price of the book.
  public void setPrice(double price) {
    this.internalPrice = (int) (price * 100);
  }

  // This operates to set the genre of the book, or default to "other"
  public void setGenre(String genre) {
    if (GENRES.contains(genre)) {
      this.genre = genre;
    } else {
      this.genre = "other";
    }
  }

  // This formats the information in a legible way in order for both customer,
  // and employee to understand the information.
  @Override
  public String toString() {
    return isbn + ",'" + title + "','"
        + author + "'," + pages
        + ",'" + editor + "','"
        + genre + "'," + getPrice() + "\n";
  }

  // This operates to find the title of the book.
  public String getTitle() { return title;  }
}
