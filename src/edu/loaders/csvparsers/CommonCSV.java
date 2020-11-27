package edu.loaders.csvparsers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * This class is the base class for CSV manipulation.
 */
public abstract class CommonCSV {
  private String delimiter;

  /**
   * This constructor stores new delimiter which is defaulted to a ','.
   */
  public CommonCSV() {
    this.delimiter = ",";
  }

  /**
   * This constructor stores new String delimiter.
   * @param delimiter : the new String delimiter (other than comma).
   */
  public CommonCSV(String delimiter) {
    this.delimiter = delimiter;
  }

  /**
   * This method retrieves String delimiter stored in the constructor
   * @return
   */
  public String getDelimiter() {
    return delimiter;
  }

  /**
   * Default method implementations to be used within related classes
   * @throws FileNotFoundException
   */
  public abstract List readCSV() throws FileNotFoundException;
  public abstract void printCSV();
  public abstract void writeCSV() throws IOException;

  // Method to be used to retrieve the header of the original CSV file
  protected abstract String[] getHeaders();
}
