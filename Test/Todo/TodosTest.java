package Todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zsomb on 2017. 04. 07..
 */
class TodosTest {

  @Test
  void testGetSize() {
    Todos helper = new Todos();
    helper.addToList("testString1");
    helper.addToList("testString2");
    assertEquals(2, helper.getSize());
  }
}