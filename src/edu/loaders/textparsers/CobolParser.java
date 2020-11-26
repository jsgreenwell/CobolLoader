package edu.loaders.textparsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CobolParser {
  // a property called filename which is set in constructor
  private Path cobFile;
  private List<String> parsedLines = new ArrayList<>();

  public CobolParser() throws IOException {
    cobFile = Paths.get("data/legacyHorror.cob");
    loadFile();
  }

  public CobolParser(String filename) throws IOException {
    cobFile = Paths.get("data/" + filename);
    loadFile();
  }

  protected void loadFile() throws IOException {
    // You can use a BufferedReader here but to show the Stream way:
    Stream<String> stream = Files.lines(cobFile);
    parsedLines = stream
        .filter(l -> !l.equals("")) // ignore blank lines
        .filter(l -> !l.startsWith("*")) // ignore comments
        .map(String::toLowerCase) // make everything lowercase
        .collect(Collectors.toList());
  }

  public String getDataFileNoRegex() {
    /* old way with no regex
        Problem with this way is what if there are only 2 spaces (you can use \\s+ with regex)
        What if the lowercase wasn't done (if someone inhereted this and overloaded)
        we cannot use contains because we need an exact match
          remember I ran this over many files so lots of audit.dat, audit.1783783.dat, rev.8371.dat
     */

    for (int i=0; i<parsedLines.size(); i++) {
      if (parsedLines.get(i).startsWith("    select")) {
        /* match exact start of line because we cannot match randomword.dat
         matching .dat would be problematic too (what if variable set for file extension)
         happened: had infileextension = ".dat" outfileextension = ".csv" so lots of bad results
         */

        String[] words = parsedLines.get(i).split(" ");
        // luckily in this case the exact word is the last word in this list
        // note the substring is to get rid of double quotes
        String datafile = words[words.length-1];
        return datafile.substring(1, datafile.length()-1);
      }
    }
    return "No file found";
  }

  public String getDataFileRegex() {
    // So we know that the file is a *.dat file so lets just find that
    // Compile because that will speed up operations later (we have to run it multiple times)

    Pattern fileP = Pattern.compile("\\w+.dat");
    // \w+ means one or more alphanumeric character using \\ because in java "\" is special char
    Matcher match;  // define early so we don't have to recreate over and over in for loop

    for (String lines : parsedLines) {
      // So loop through each line in data file and then just match/capture the filename

      // setup our matcher using the earlier compiled pattern
      match = fileP.matcher(lines);
      if (match.find()) {
        // while (match.find()) will loop through all matches - better than contains
        // because match.find returns an array of groups - we can access the first match with:
        return match.group(0);
      }
    }

    return "No file found";
  }

  public Map<String, String> getFileSpecs() {
    Map<String, String> fileSpecs = new HashMap<>();

    // Bonus assignment - your code here

    return fileSpecs;
  }

  public void printCurrentLines() {
    parsedLines.forEach(System.out::printf);
  }

}
