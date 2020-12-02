import edu.loaders.csvparsers.*;
import edu.loaders.textparsers.CobolParser;
import java.io.IOException
/** This is the  method which makes up the data of the book
*@param args unused
*@return Nothing
*exception IOException on input
*/
public class CSVParsers {
  public static void main(String args[]) throws IOException {
    BookCSV books = new BookCSV("./data/books.csv");
    for (Book b : books.readCSV()) {
      System.out.println(".......");
      System.out.println(b.getAuthor());
      System.out.println(".......");
    /**
    * Print the author of the book
    /
    };
  
    System.out.println(books.books.get(0).getTitle());
    /**
    *Prints book and the title
    /

    books.printCSV();
    books.writeCSV();

    CobolParser cp = new CobolParser("legacyHorror.cob");
    // cp.printCurrentLines();
    System.out.println("data file is: " + cp.getDataFileNoRegex());
    System.out.println("\tand with regex still: " + cp.getDataFileRegex());

  }

}
