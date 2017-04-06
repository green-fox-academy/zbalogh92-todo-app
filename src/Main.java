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
    List<String> todoLines = readLinesFromFile();
    System.out.println(todoLines);

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

    if (args[0].equals("-l") && todoLines.size() != 0) {
      for (int i = 0; i < todoLines.size(); i++) {
        System.out.println(i + 1 + " - " + " " + todoLines.get(i));
      }
    } else if (args[0].equals("-l") && todoLines.size() == 0) {
      System.out.println("No todos for today! Enjoy your day! :)");
    }
    if (args[0].equals("-a")) {
      todoLines.add(args[1]);
    }

    writeToFile(todoLines);
  }

  private static List<String> readLinesFromFile() {
    Path path = Paths.get(FILE_NAME);
    List<String> todoLines;
    try {
      todoLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      todoLines = new ArrayList<>();
    }
    return todoLines;
  }

  private static void writeToFile(List<String> data) {
    Path path = Paths.get(FILE_NAME);
    try {
      Files.write(path, data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

//  private static void refactData(List<String> todoLines, List<String> todoLines) {
//    for (String line : todoLines) {
//      String[] splittedLine = line.split(";");
//      for (int i = 0; i < splittedLine.length; i++) {
//        todoLines.add(splittedLine[i]);
//      }
//    }
//  }
//
//  private static void backToCsv(List<String> todoLines)
//
//}
