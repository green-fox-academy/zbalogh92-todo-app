package Todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsomb on 2017. 04. 07..
 */
public class Todos {
  private final static String FILE_NAME = "data.csv";
  List<String> todoLines = readLinesFromFile();

  public List<String> readLinesFromFile() {
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

  public void writeToFile() {
    Path path = Paths.get(FILE_NAME);
    try {
      Files.write(path, todoLines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addToList(String newTodo) {
    todoLines.add(newTodo);
  }

  public void setList(int index, String element) {
    todoLines.set(index, element);
  }

  public int getSize () {
    return todoLines.size();
  }

  public String getTodoLineElement(int index) {
    return todoLines.get(index);
  }

  public void removeFromList (int index) {
    todoLines.remove(index);


  }


}
