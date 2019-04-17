package schrader.collection.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {

  /**
   * Java 9: static factory methods for collections
   */

  @Test
  public void listOf() {
    var l = List.of(1, 2, 3);
  }

  @Test
  public void setOf() {
    var s = Set.of(1, 2, 1);
  }

  @Test
  public void mapOf() {
    var m = Map.of("foo", "bar");
  }

  @Test
  public void mapOfEntries() {
    var m2 = Map.ofEntries(Map.entry("foo", "bar"));
  }
}
