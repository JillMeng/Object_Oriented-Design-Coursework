import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test for class FibonacciCounter.
 */

public class FibonacciCounterTest {

  private FibonacciCounter counter1;
  private FibonacciCounter counter2;

  @Before
  public void setUp() {
    counter1 = new FibonacciCounter(5);
    counter2 = new FibonacciCounter(1);
  }

  @Test
  public void testConstructorGetters() {
    assertEquals(5, counter1.getCount());
    assertEquals(1, counter2.getCount());
    assertEquals(5, counter1.getFibValue(), 0.01);
    assertEquals(1, counter2.getFibValue(), 0.01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalCount() throws IllegalArgumentException {
    FibonacciCounter negativeCount = new FibonacciCounter(-1);
    //negativeCount.getCount();
  }


  @Test
  public void testIncrement() {
    FibonacciCounter incrementFib1 = counter1.increment();
    assertEquals(incrementFib1.getCount(), counter1.getCount() + 1);
  }

  @Test
  public void testDecrement() {
    FibonacciCounter decrementFib1 = counter1.decrement();
    FibonacciCounter decrementFib2 = counter2.decrement();
    assertEquals(decrementFib1.getCount(), counter1.getCount() - 1);
    assertEquals(decrementFib2.getCount(), counter2.getCount());
  }

  @Test
  public void testGetCounter() {
    assertEquals(5, counter1.getCount());
    assertEquals(1, counter2.getCount());
  }

  @Test
  public void testGetFibValue() {
    assertEquals(5, counter1.getFibValue(), 0.01);
    assertEquals(1, counter2.getFibValue(), 0.01);
  }
}


