/**
 * This class represents a pay check that has an employee name, a rate, and the hours worked.
 */
public class PayCheck {
  private String name;
  private double rate;
  private double hoursWorked;
  private double totalPay;

  /**
   * Construct a PayCheck object and initializes it to an employee name, rate, hours worked. and
   * calculates the total pay for the week.
   *
   * @param name        the name of the employee
   * @param rate        the pay rate of the employee
   * @param hoursWorked the hours that employee worked in a week
   * @throws IllegalArgumentException when the given name, rate, and hoursWorked is illegal.
   */

  public PayCheck(String name, double rate, double hoursWorked) {
    if (name == null) {
      throw new IllegalArgumentException("Must have an employee name.");
    }
    if (rate < 0) {
      throw new IllegalArgumentException("Employee pay rate cannot be negative value.");
    }
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("Hours worked cannot be negative value.");
    }

    this.name = name;
    this.rate = rate;
    this.hoursWorked = hoursWorked;

    /*calculate the total pay for the week.*/
    if (this.hoursWorked >= 40) {
      this.totalPay = 1.5 * this.rate * (this.hoursWorked - 40) + 40 * this.rate;
    } else {
      this.totalPay = this.rate * this.hoursWorked;
    }
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
   * @return pay rate of the employee
   */
  public double getRate() {
    if (rate < 0) {
      throw new IllegalArgumentException("Pay Rate cannot be negative!");
    }
    return this.rate;
  }

  /**
   * Get the hours this employee has worked in a week.
   *
   * @return hours the employee has worked
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Get the total pay for the employee with the rate and the hours worked.
   *
   * @return return the total pay for the employee for the week
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * Return a string representation of the employee name and total pay amount.
   *
   * @return a formatted string
   */
  public String toString() {
    return String.format("$ %.2f", this.totalPay);
  }
}

