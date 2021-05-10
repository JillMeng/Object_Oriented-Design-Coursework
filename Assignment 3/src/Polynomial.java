/**
 * This is a ADT interface that is abstract from PolynomialList, and is accessible to the use.
 */
public interface Polynomial {

  /**
   * A method that takes a coefficient and a power (both integral numbers) and store them into Term
   * Object and adds the resulting term to the existing polynomial.
   *
   * @param coefficient a int value to form the coefficient of the term.
   * @param power       a int value to form the power of the term.
   * @throws IllegalArgumentException when the power is negative.
   */
  void addTerm(int coefficient, int power);

  /**
   * A method removeTerm that takes a power and removes any and all terms in the polynomial with
   * that power.
   *
   * @param power specify the power of the term that needs to be moved.
   * @throws IllegalArgumentException when the power is negative.
   */
  void removeTerm(int power);

  /**
   * A method that returns the degree of this polynomial.
   *
   * @return an int value that is the degree of the polynomial.
   */
  int getDegree();

  /**
   * A method that takes a power and returns the coefficient for the term with that power.
   *
   * @param power the int parameter passed in to specify the term.
   * @return an in value that represents the coefficient of the chosen term.
   * @throws IllegalArgumentException when the power is negative.
   */
  int getCoefficient(int power);


  /**
   * A method that takes a double-precision decimal number and returns a double-precision result.
   *
   * @param x the double value that gets passed into the polynomial.
   * @return the calculation result of the polynomial.
   */
  double evaluate(double x);

  /**
   * A method that turn the polynomial to a formatted string.
   *
   * @return a formatted string value.
   */
  String toString();


  /**
   * A method add that takes another Polynomial object and returns the polynomial obtained by adding
   * the two polynomials. Any implementation should ensure that this method does not mutate either
   * polynomial. The implementation may assume that the given Polynomial is the of the same concrete
   * class as this object; if it is a different class, the method may throw an
   * IllegalArgumentException.
   *
   * @param other another Polynomial object that gets passed in
   * @return a new polynomials that adds up both polynomial
   * @throws IllegalArgumentException when the passed on object is not a Polynomial.
   */
  Polynomial add(Polynomial other);
}

