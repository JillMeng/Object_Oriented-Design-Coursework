/**
 * This class represents a employee. The employee has a name, hours worked in a given week and the
 * pay rate
 */

public class Employee {

  private String name;
  private double payRate;
  private double hrsWorked;

  /**
   * Construct an Employee object and initialize it to a name and pay rate, and initialize hours
   * worked to zero.
   *
   * @param name    the name of the employee
   * @param payRate the pay rate of that employee
   * @throws IllegalArgumentException when no name is initialized and when the pay rate is a
   *                                  negative value.
   */
  public Employee(String name, double payRate) {
    if (name == null) {
      throw new IllegalArgumentException("Must have an employee name.");
    }
    if (payRate < 0) {
      throw new IllegalArgumentException("Employee pay rate cannot be negative value.");
    }
    this.name = name;
    this.payRate = payRate;
    this.hrsWorked = 0.0;
  }

  /**
   * Get the name of the employee.
   *
   * @return the name of the employee
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the pay rate for the employee.
   *
   * @return PayRate of the employee
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Get the current hours the employee worked, and it is pre-initialized as 0.
   *
   * @return the current hours worked
   */
  public double getHrsWorked() {
    return hrsWorked;
  }

  /**
   * Add hours worked to the current number of hours the employee has worked.
   *
   * @param hours need to be added
   * @return the total hours worked after implementing the method
   * @throws IllegalArgumentException when hours added is less than 0.
   */
  public double addHrsWorked(double hours) {
    if (hours < 0) {
      throw new IllegalArgumentException("No negative hours worked!");
    }
    return this.hrsWorked += hours;
  }

  /**
   * Reset the employee’s hours worked for the week to zero.
   *
   * @return the number of hours the employee has worked
   */
  public int resetHoursWorked() {
    return 0;
  }

  /**
   * Print a string representation of the employee object by name.
   *
   * @return a formatted string
   */
  public String toString() {
    return this.name;
  }

  /**
   * Get the weekly paycheck for the given employee provide the hours this employee worked.
   *
   * @param hours provide hours the employee has worked as a parameter passing to the method in
   *              order to get the weekly pay check object.
   * @return a new PayCheck object given the current employee name,rate and hours worked.
   * @throws IllegalArgumentException when hours worked is less than 0.
   */
  public PayCheck getWeeklyCheck(double hours) {
    if (hours < 0) {
      throw new IllegalArgumentException("Hours worked cannot be less than 0!");
    }
    return new PayCheck(this.name, this.payRate, hours);
  }
}
