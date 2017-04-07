import Todo.Todos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zsomb on 2017. 04. 07..
 */


class MainTest {



  @Test
  void testCheckForX() {
    Todos helperTodos = new Todos();
    helperTodos.addToList("testString");
    assertTrue(helperTodos.getSize() > 0);
  }
}