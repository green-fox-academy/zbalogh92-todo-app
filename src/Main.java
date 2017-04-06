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
}
