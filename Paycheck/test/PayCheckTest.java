import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test for class PayCheck.
 */

public class PayCheckTest {

  private PayCheck jill;
  private PayCheck joe;

  @Before
  public void setup() {
    jill = new PayCheck("Jill", 35.5, 45.0);
    joe = new PayCheck("Joe", 15.9, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() throws IllegalArgumentException {
    PayCheck illegalName = new PayCheck(null, 35.0, 50.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRateException() throws IllegalArgumentException {
    PayCheck illegalRate = new PayCheck("Jhon", -35.0, 50.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHoursWorkedException() throws IllegalArgumentException {
    PayCheck illegalHours = new PayCheck("Jhon", 35.0, -50.0);
  }

  @Test
  public void testGetName() {
    assertEquals("Jill", jill.getName());
    assertEquals("Joe", joe.getName());
  }

  @Test
  public void testGetRate() {
    assertEquals(35.5, jill.getRate(), 0.01);
    assertEquals(15.9, joe.getRate(), 0.01);
  }

  @Test
  public void testHoursWorked() {
    assertEquals(45.0, jill.getHoursWorked(), 0.01);
    assertEquals(25.0, joe.getHoursWorked(), 0.01);
  }

  @Test
  public void testGetTotalPay() {
    double jillPayCheck;
    double joePayCheck;

    jillPayCheck = 40 * 35.5 + (45 - 40) * 35.5 * 1.5;
    joePayCheck = 25 * 15.9;

    assertEquals(jillPayCheck, jill.getTotalPay(), 0.01);
    assertEquals(joePayCheck, joe.getTotalPay(), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("$ 1686.25", jill.toString());
    assertEquals("$ 397.50", joe.toString());
  }

}