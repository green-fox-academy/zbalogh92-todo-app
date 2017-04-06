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
  private final static String WELCOME_TEXT = "Zsombor's Todo application\n" +
          "=======================\n" +
          "\n" +
          "Command line arguments:\n" +
          " -l   Lists the undone tasks\n" +
          " -la  Lists all the tasks\n" +
          " -a   Adds a new task\n" +
          " -r   Removes a task\n" +
          " -c   Completes or uncompletes a task";

  public static void main(String[] args) {
    List<String> todoLines = readLinesFromFile();

    if (args.length == 0) {
      System.out.println(WELCOME_TEXT);
    } else if (args[0].equals("-l") && todoLines.size() != 0) {
      for (int i = 0; i < todoLines.size(); i++) {
        if (checkForSpaceInFor(todoLines, i)) {
          System.out.println(i + 1 + " - " + todoLines.get(i));
        }
      }
    } else if (args[0].equals("-l") && todoLines.size() == 0) {
      System.out.println("No todos for today! Enjoy your day! ༼ つ ▀̿_▀̿ ༽つ");
    } else if (args[0].equals("-la") && todoLines.size() != 0) {
      for (int i = 0; i < todoLines.size(); i++) {
        System.out.println(i + 1 + " - " + todoLines.get(i));
      }
    } else if (args[0].equals("-a")) {
      todoLines.add("[ ] " + args[1]);
    } else if (args[0].equals("-r")) {
      if (args.length == 1) {
        System.out.println("Unable to remove: no index provided");
      } else if (args.length == 2) {
        try {
          if (todoLines.size() >= Integer.parseInt(args[1])) {
            todoLines.remove(Integer.parseInt(args[1]) - 1);
          } else {
            System.out.println("Unable to remove: index is out of bound!");
          }
        } catch (NumberFormatException e) {
          System.out.println("Unable to remove: index is not a number");
        }
      } else {
        System.out.println("You can delete only 1 line by 1 argument!");
      }
    } else if (args[0].equals("-c")) {
      if (args.length == 1) {
        System.out.println("Unable to check: no index provided");
      } else if (args.length == 2) {
        try {
          if (todoLines.size() >= Integer.parseInt(args[1])) {
            if (checkForX(todoLines, args)) {
              setForSpace(todoLines, args);
            } else if (checkForSpace(todoLines, args)) {
              setForX(todoLines, args);
            }
          } else {
            System.out.println("Unable to check: index is out of bound!");
          }
        } catch (NumberFormatException e) {
          System.out.println("Unable to check: index is not a number");
        }
      }
    } else if (args.length > 0) {
      System.out.println("Unsupported argument!");
    }

    writeToFile(todoLines);
  }

  private static boolean checkForX(List<String> todoLines, String[] args) {
    return (todoLines.get(Integer.parseInt(args[1]) - 1).substring(1, 2).equals("X"));
  }

  private static boolean checkForSpace(List<String> todoLines, String[] args) {
    return (todoLines.get(Integer.parseInt(args[1]) - 1).substring(1, 2).equals(" "));
  }

  private static boolean checkForSpaceInFor(List<String> todoLines, int i) {
    return (todoLines.get(i).substring(1, 2).equals(" "));
  }

  private static void setForSpace(List<String> todoLines, String[] args) {
    todoLines.set(Integer.parseInt(args[1]) - 1, "[ " + todoLines.get(Integer.parseInt(args[1]) - 1).substring(2));
  }

  private static void setForX(List<String> todoLines, String[] args) {
    todoLines.set(Integer.parseInt(args[1]) - 1, "[X" + todoLines.get(Integer.parseInt(args[1]) - 1).substring(2));
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
//
//  public void complete() {
//    this.complete = true;
//  }
//
//  public boolean isCompleted() {
//    return complete;
//  }
//
//  public void setCompleted(boolean complete) {
//    this.complete = complete;
//  }
//
//  @Override
//  public String toString() {
//    return (complete ? "[x] " : "[ ] ") + name;
//  }
//}

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



