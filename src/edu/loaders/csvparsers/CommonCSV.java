package edu.loaders.csvparsers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class CommonCSV {
  private String delimiter;
  
  /** Sets the delimiter to a comma for
  *   comma seperated values
  */
  public CommonCSV() {
    this.delimiter = ",";
  }
  
  /** Sets the delimiter to the passed string 
  *   @param delimiter the String that will be used as a delimiter
  */
  public CommonCSV(String delimiter) {
    this.delimiter = delimiter;
  }
  
  /** Returns the delimiter
  *   @return returns the delimiter as a String 
  */
  public String getDelimiter() {
    return delimiter;
  }

  public abstract List readCSV() throws FileNotFoundException;
  public abstract void printCSV();
  public abstract void writeCSV() throws IOException;

  protected abstract String[] getHeaders();
}
