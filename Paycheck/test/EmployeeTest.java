import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test for class Employee.
 */

public class EmployeeTest {

  private Employee jill;

  @Before
  public void setUp() {
    jill = new Employee("Jill", 35.5);
  }

  @Test
  public void testEmployeeGetters() {
    assertEquals("Jill", jill.getName());
    assertEquals(35.5, jill.getPayRate(), 0.01);
    assertEquals(0, jill.getHrsWorked(), 0.01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() throws IllegalArgumentException {
    Employee illegalName = new Employee(null, 35.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPayRate() throws IllegalArgumentException {
    Employee illegalPayRate = new Employee("Joe", -35.5);
  }


  @Test
  public void testAddHrsWorked() {
    assertEquals(40, jill.addHrsWorked(40), 0.01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalHrsWorked() throws IllegalArgumentException {
    double hrsWorked;
    hrsWorked = jill.addHrsWorked(-40);
  }

  @Test
  public void testResetHours() {
    assertEquals(0, jill.resetHoursWorked());
  }

  @Test
  public void testToString() {
    assertEquals("Jill", jill.toString());
  }

  @Test
  public void testGetWeeklyCheck() {
    PayCheck pay = jill.getWeeklyCheck(45.0);
    assertEquals(jill.getName(), pay.getName());
    assertEquals(jill.getPayRate(), pay.getRate(), 0.01);
    assertEquals("$ 1686.25", pay.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalHours() throws IllegalArgumentException {
    PayCheck weekPay;
    weekPay = jill.getWeeklyCheck(-35.5);
  }
}
