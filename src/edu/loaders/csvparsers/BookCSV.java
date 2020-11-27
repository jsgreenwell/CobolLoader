package edu.loaders.csvparsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to read, print, and write CSV file.
 */
public class BookCSV extends CommonCSV {

  private String bookCSVFile = "";
  public List<Book> books = new ArrayList<>();

  public BookCSV(String file) {
    super();
    bookCSVFile = file;
  }

  /**
   * This method reads the given CSV file in the constructor, converts every line into Book object,
   * and saves it into a list of Book objects declared above.
   * @return the list of Book objects.
   * @throws FileNotFoundException if the file is not present in the file/wrongly inputted.
   */
  @Override
  public List<Book> readCSV() throws FileNotFoundException {
    FileReader reader = new FileReader(bookCSVFile);

   try(BufferedReader bBookReader = new BufferedReader(reader)) {
     String line;
     int headers = 0;

     while ((line = bBookReader.readLine()) != null) {
       if (headers == 0) {
         // Skip first line
         headers++;
       } else {
         // To avoid case-sensitivity problems, toLowerCase() is used
         books.add(new Book(line.toLowerCase().split(getDelimiter())));
       }
     }
   } catch (IOException ex) {
     System.out.printf("Could not load file <" + bookCSVFile + ">\n" + ex);
   }
   return books;
  }

  /**
   * This method prints the content of Book objects from the list provided in the constructor, if list is not empty.
   */
  @Override
  public void printCSV() {
    if (books.size() > 0) {
      for (Book book : books) {
        System.out.print(book.toString());
      }
    } else {
      System.out.printf("No books loaded.");
    }
  }

  /**
   * This methods writes a CSV file called newBooks with the content of Book objects
   * from the list provided in the constructor.
   * @throws IOException.
   */
  @Override
  public void writeCSV() throws IOException {
    File outFile = new File("./data/newBooks.csv");
    if (!outFile.exists()) {
      outFile.createNewFile();
    }

    BufferedWriter writer = new BufferedWriter(
        new FileWriter(outFile));
    for (Book book : books) {
      writer.write(book.toString());
    }
    writer.close();
  }

  // Method not used for this implementation
  @Override
  protected String[] getHeaders() { return new String[0]; }
}
