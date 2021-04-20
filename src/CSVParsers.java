import edu.loaders.csvparsers.*;
import edu.loaders.textparsers.CobolParser;
import java.io.IOException;

public class CSVParsers {
  public static void main(String args[]) throws IOException {
    // TODO: Add comments
    BookCSV books = new BookCSV("./data/books.csv");
    for (Book b : books.readCSV()) {
      System.out.println(".......");
      System.out.println(b.getAuthor());
      System.out.println(".......");
    };
    System.out.println(books.books.get(0).getTitle());

    books.printCSV();
    books.writeCSV();

    CobolParser cp = new CobolParser("legacyHorror.cob");
    // cp.printCurrentLines();
    System.out.println("data file is: " + cp.getDataFileNoRegex());
    System.out.println("\tand with regex still: " + cp.getDataFileRegex());

  }

}
