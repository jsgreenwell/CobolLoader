import edu.loaders.csvparsers.*;
import edu.loaders.textparsers.CobolParser;
import java.io.IOException;

public class CSVParsers {
  public static void main(String args[]) throws IOException {
    //Instance call of the object BookCSV.
    BookCSV books = new BookCSV("./data/books.csv");
    /**
    * This for each loop places a book that is read by the file reader
    * into the readCSV method located in the BookCvs method. It also places
    * two sets of dotted lines with the author located in the center of the lines into a file.
    */
    for (Book b : books.readCSV()) {
      System.out.println(".......");
      System.out.println(b.getAuthor());
      System.out.println(".......");
    };
    //After the author is printed, then the book title is displayed as well.
    System.out.println(books.books.get(0).getTitle());
    
    //Calls the printCSV and writeCSV method.
    books.printCSV();
    books.writeCSV();

    CobolParser cp = new CobolParser("legacyHorror.cob");
    System.out.println("data file is: " + cp.getDataFileNoRegex());
    System.out.println("\tand with regex still: " + cp.getDataFileRegex());

  }

}
