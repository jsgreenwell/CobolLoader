package edu.loaders.csvparsers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class CommonCSV {
  // add comments on why "," as default and what delimiter means
  private String delimiter;

  public CommonCSV() {
    this.delimiter = ",";
  }

  public CommonCSV(String delimiter) {
    this.delimiter = delimiter;
  }

  public String getDelimiter() {
    return delimiter;
  }

  // abstract methods to always be overridden
  public abstract List readCSV() throws FileNotFoundException;
  public abstract void printCSV();
  public abstract void writeCSV() throws IOException;

  protected abstract String[] getHeaders();
}
