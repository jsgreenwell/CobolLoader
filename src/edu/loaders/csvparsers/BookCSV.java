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

// BookCSV class extends and creates a child of CommonCSV class as well as its methods. 
public class BookCSV extends CommonCSV {

  //Main method that's used for the book
  private String bookCSVFile = "";
  //Has the book put into a list (ArrayList)
  public List<Book> books = new ArrayList<>();
  
  public BookCSV(String file) {
    super();
    bookCSVFile = file;
  }

  @Override
  // The book in the list is used from an import and gets denoted.
  public List<Book> readCSV() throws FileNotFoundException {
    // The file of BookCSV will be read based on what's currently on the list.
    FileReader reader = new FileReader(bookCSVFile);
    
    
   // The exception (try and catch) will have the Buffered reader go through the file and test for errors. 
   try(BufferedReader BookReader = new BufferedReader(reader)) {
     String line;
     int headers = 0;

     //The headers based on the BookReader will be skipped if it equals to 0
     while ((line = BookReader.readLine()) != null) {
       if (headers == 0) {
         // Skip first line
         headers++;
       } else {
         books.add(new Book(line.toLowerCase().split(getDelimiter())));
       }
     }
   } catch (IOException ex) {
     //An error of the file not loading
     System.out.println("Could not load file <" + bookCSVFile + ">\n" + ex);
   }
   //The book file going through the else statement is returned at this point if the file can't load.
   return books;
  }

  //The size of the book will be measured if it's greater than 0, which will lead it to be printed out
  @Override
  public void printCSV() {
    if (books.size() > 0) {
      for (Book book : books) {
        //Prints book out as a string
        System.out.print(book.toString());
      }
    } else {
      //Prints out "No books loaded" if the else statement is used.  
      System.out.println("No books loaded.");
    }

  }

  // The file of the book that's written will be outputted if the file itself exists 
  @Override
  public void writeCSV() throws IOException {
    File outFile = new File("./data/newBooks.csv");
    if (!outFile.exists()) {
      outFile.createNewFile();
    }
    
    // A new BufferedWriter will cause a new FileWriter to be outputted for the title of the book
    BufferedWriter writer = new BufferedWriter(
        new FileWriter(outFile));
    for (Book book : books) {
      writer.write(book.toString());
    }
    //The file that was written ends up closing
    writer.close();
  }

  // Method not used for this implementation
  @Override
  protected String[] getHeaders() { return new String[0]; }
}
