import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class BuiltInListDemo {

  @Test
  public void listDemo() {
    List<String> list = new ArrayList<>();
    list.add("asdf");
    list.add(0, "zxcv");
    assertEquals(2, list.size());
    List<Integer> lengths = new ArrayList<>();
    for (String s : list) {
      System.out.println(s);
      lengths.add(s.length());
    }
    lengths = list.stream().map(s -> s.length()).collect(Collectors.toList());
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + ": " + list.get(i));
    }

    // equality sameness
    // aliasing vs copying, mutation vs non-mutability


  }

}
