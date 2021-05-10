/**
 * A class that represents the EmptyNode of the PolynomialList; it contains all the method that are
 * listed in PolynomialList interface.
 */
class EmptyNode implements PolynomialList {

  @Override
  public PolynomialList addTerm(int coefficient, int power) {
    return new ElementNode(coefficient, power, this);
  }

  @Override
  public PolynomialList remove(int power) {
    return this;
  }

  @Override
  public int getDegree() {
    return 0;
  }


  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public double evaluate(double x) {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }


}