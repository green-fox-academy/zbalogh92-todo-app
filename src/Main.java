import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsomb on 2017. 04. 06..
 */

public class Main {
  private final static String FILE_NAME = "data.csv";

  public static void main(String[] args) {
    List<String> rawLines = readLinesFromFile();
    System.out.println(rawLines);
    List<String> splittedLines = new ArrayList<>();
    refactData(rawLines, splittedLines);
    System.out.println(splittedLines);

    if (args.length == 0) {
      System.out.println("Zsombor's Todo application\n" +
              "=======================\n" +
              "\n" +
              "Command line arguments:\n" +
              " -l   Lists all the tasks\n" +
              " -a   Adds a new task\n" +
              " -r   Removes an task\n" +
              " -c   Completes an task");
    }

    if (args[0].equals("-l")) {
      for (int i = 0; i < splittedLines.size(); i++) {
        System.out.println(i + 1 + " - " + " " + splittedLines.get(i));
      }
    }
  }

  private static List<String> readLinesFromFile() {
    Path path = Paths.get(FILE_NAME);
    List<String> rawLines;
    try {
      rawLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      rawLines = new ArrayList<>();
    }
    return rawLines;
  }

  private static void refactData(List<String> rawLines, List<String> splittedLines) {
    for (String line : rawLines) {
      String[] splittedLine = line.split(";");
      for (int i = 0; i < splittedLine.length; i++) {
        splittedLines.add(splittedLine[i]);
      }
    }


  }
}
//
////
////      String type = splittedLine[0];
////      String color = splittedLine[1];
////      double water = Double.valueOf(splittedLine[2]);
////
////      if (type.equals("flower")) {
////        garden.add(new Flower(water, color));
////      } else if (type.equals("tree")) {
////        garden.add(new Tree(water, color));
////      }
////}
