package edu.loaders.csvparsers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class CommonCSV {
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

  public abstract List readCSV() throws FileNotFoundException;
  public abstract void printCSV();
  public abstract void writeCSV() throws IOException;

  protected abstract String[] getHeaders();
}
