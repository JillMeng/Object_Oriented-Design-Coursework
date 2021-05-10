import static org.junit.Assert.*;

import java.util.function.Function;
import list.ListADT;
import list.ListADTImpl;
import org.junit.Before;
import org.junit.Test;

public class ListADTTest {

  private ListADT<String> listOfString;

  @Before
  public void setup() {
    listOfString = new ListADTImpl<String>();
    String asdf = "asdf";
    listOfString.addToFront("5.5");
    listOfString.addToBack("asdf");
    listOfString.addToBack("zxcv");
  }

  @Test
  public void testMap() {
    ListADT<Integer> stringLengths = listOfString.map(s -> s.length());
    assertEquals(Integer.valueOf(4), stringLengths.get(1));
    assertEquals(Integer.valueOf(3), stringLengths.get(0));
  }

  @Test
  public void testFold() {
    ListADT<String> los = new ListADTImpl<>();
    los.addToBack("asdf");
    los.addToBack("qerghfdsfg");
    los.addToBack("adg");
    int longestStrLength = los.fold((str, acc) -> str.length() > acc ? str.length() : acc, 0);
    int longestStrLength2 = los.fold((str, acc) -> {
      if (str.length() > acc) {
        return str.length();
      } else {
        return acc;
      }
    }, 0);
    assertEquals(10, longestStrLength);
    String longestStr = los.fold((String str, String accStr) -> str.length() > accStr.length() ? str : accStr, "");
    assertEquals("qerghfdsfg", longestStr);
    String concatAll = los.fold((str1, str2) -> str1 + str2, "");
    assertEquals("asdfqerghfdsfgadg", concatAll);
  }

  @Test
  public void addToFront() {
  }

  @Test
  public void addToBack() {
  }

  @Test
  public void count() {
  }

  @Test
  public void filter() {
  }
}

class StringLength implements Function<String, Integer> {

  @Override
  public Integer apply(String s) {
    return s.length();
  }
}
