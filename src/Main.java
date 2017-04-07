import Todo.Todos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsomb on 2017. 04. 06..
 */

class Main {
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
    Todos todoLines = new Todos();

    if (args.length == 0) {
      System.out.println(WELCOME_TEXT);
    } else if (args[0].equals("-l") && todoLines.getSize() != 0) {
      for (int i = 0; i < todoLines.getSize(); i++) {
        if (checkForSpaceInFor(todoLines, i)) {
          System.out.println(i + 1 + " - " + todoLines.getTodoLineElement(i));
        }
      }
    } else if (args[0].equals("-l") && todoLines.getSize() == 0) {
      System.out.println("No todos for today! Enjoy your day! ༼ つ ▀̿_▀̿ ༽つ");
    } else if (args[0].equals("-la") && todoLines.getSize() != 0) {
      for (int i = 0; i < todoLines.getSize(); i++) {
        System.out.println(i + 1 + " - " + todoLines.getTodoLineElement(i));
      }
    } else if (args[0].equals("-a")) {
      todoLines.addToList("[ ] " + args[1]);
    } else if (args[0].equals("-r")) {
      if (args.length == 1) {
        System.out.println("Unable to remove: no index provided");
      } else if (args.length == 2) {
        try {
          if (todoLines.getSize() >= Integer.parseInt(args[1])) {
            todoLines.removeFromList(Integer.parseInt(args[1]) - 1);
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
          if (todoLines.getSize() >= Integer.parseInt(args[1])) {
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

    todoLines.writeToFile();
  }

  public static boolean checkForX(Todos todoLines, String[] args) {
    return (todoLines.getTodoLineElement(Integer.parseInt(args[1]) - 1).substring(1, 2).equals("X"));
  }

  public static boolean checkForSpace(Todos todoLines, String[] args) {
    return (todoLines.getTodoLineElement(Integer.parseInt(args[1]) - 1).substring(1, 2).equals(" "));
  }

  public static boolean checkForSpaceInFor(Todos todoLines, int i) {
    return (todoLines.getTodoLineElement(i).substring(1, 2).equals(" "));
  }

  public static void setForSpace(Todos todoLines, String[] args) {
    todoLines.setList(Integer.parseInt(args[1]) - 1, "[ " + todoLines.getTodoLineElement(Integer.parseInt(args[1]) - 1).substring(2));
  }

  public static void setForX(Todos todoLines, String[] args) {
    todoLines.setList(Integer.parseInt(args[1]) - 1, "[X" + todoLines.getTodoLineElement(Integer.parseInt(args[1]) - 1).substring(2));
  }
}