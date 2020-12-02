import edu.loaders.csvparsers.*;
import edu.loaders.textparsers.CobolParser;
import java.io.IOException;

// CVSParsers class creates instance of BookCSV class and calls several of its methods.
public class CSVParsers {
  // Main method
  public static void main(String args[]) throws IOException {
    // Instance of the BookCSV class with CSV file directory in argument.
    BookCSV books = new BookCSV("./data/books.csv");
    // Enchanced for loop runs through CSV file and prints lines.
    for (Book b : books.readCSV()) {
      System.out.println(".......");
      System.out.println(b.getAuthor());
      System.out.println(".......");
    };
    // Print book title.
    System.out.println(books.books.get(0).getTitle());

    // Calls the printCSV and writeCSV methods.
    books.printCSV();
    books.writeCSV();

    // New instance of CobolParser class.
    CobolParser cp = new CobolParser("legacyHorror.cob");
    
    // Print data file with and without regex.
    System.out.println("data file is: " + cp.getDataFileNoRegex());
    System.out.println("\tand with regex still: " + cp.getDataFileRegex());

  }

}
