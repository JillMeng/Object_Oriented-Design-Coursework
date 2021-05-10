/**
 * This is an interface contains all the methods that live in the list of polynomial.
 */
public interface PolynomialList {

  /**
   * A method that takes a coefficient and a power (both integral numbers) and store them into Term
   * Object and assigns the resulting term to the polynomial.
   *
   * @param coefficient the int value passed in.
   * @param power       in int value passed in.
   * @return a new Polynomial list that has the new Term added.
   * @throws IllegalArgumentException when the power is negative.
   */
  PolynomialList addTerm(int coefficient, int power);

  /**
   * A method removeTerm that takes a power and removes any and all terms in the polynomial with
   * that power.
   *
   * @param power specify the power of the term that needs to be moved.
   * @return a new Polynomial list that has the chosen term removed.
   * @throws IllegalArgumentException when the power is negative.
   */
  PolynomialList remove(int power);

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


}
