import edu.loaders.csvparsers.*;
import edu.loaders.textparsers.CobolParser;
import java.io.IOException;

public class CSVParsers {
  public static void main(String args[]) throws IOException {
    BookCSV books = new BookCSV("./data/books.csv");
    for (Book b : books.readCSV()) {
      System.out.printf(".......");
      System.out.printf(b.getAuthor());
      System.out.printf(".......");
    };
    System.out.printf(books.books.get(0).getTitle());

    books.printCSV();
    books.writeCSV();

    CobolParser cp = new CobolParser("legacyHorror.cob");
    // cp.printCurrentLines();
    System.out.printf("data file is: " + cp.getDataFileNoRegex());
    System.out.printf("\tand with regex still: " + cp.getDataFileRegex());

  }

}
