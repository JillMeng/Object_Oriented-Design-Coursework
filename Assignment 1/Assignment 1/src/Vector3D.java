/**
 * This class represents a 3D vector that contains x, y, z three components of the vector.
 */
public class Vector3D {
  private double x;
  private double y;
  private double z;

  /**
   * Construct a 3D vector object and initialized it with x, y, z value.
   *
   * @param x the x value of the vector
   * @param y the y value of the vector
   * @param z the z value of the vector
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Get the value of the x component.
   *
   * @return x value of the vector
   */
  public double getX() {
    return this.x;
  }

  /**
   * Get the value of the y component.
   *
   * @return y value of the vector
   */
  public double getY() {
    return this.y;
  }

  /**
   * Get the value of the z component.
   *
   * @return z value of the vector
   */
  public double getZ() {
    return this.z;
  }

  /**
   * Convert the x,y,z components to a string format as “(x,y,z)”.
   *
   * @return a formatted string to represent the vector.
   */
  public String toString() {
    return String.format("(%.2f,%.2f,%.2f)", this.x, this.y, this.z);
  }

  /**
   * A method that calculates the magnitude of the 3D vector.
   *
   * @return a double value that is the magnitude of the given vector
   */
  public double getMagnitude() {
    return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }

  /**
   * This method normalize and return a new version of this vector. It also throw an
   * IllegalStateException when the magnitude is zero, the operation cannot be completed.
   *
   * @return a normalized version of this vector
   * @throws IllegalStateException when the magnitude is zero.
   */
  public Vector3D normalize() {
    if (this.getMagnitude() == 0) {
      throw new IllegalStateException("Magnitude is 0, cannot proceed normalize operation.");
    }

    double newX = this.x / this.getMagnitude();
    double newY = this.y / this.getMagnitude();
    double newZ = this.z / this.getMagnitude();
    return new Vector3D(newX, newY, newZ);
  }

  public Vector3D add(Vector3D other) {
    return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
  }

  /**
   * A method that multiplies each of the three components by a constant value and return a new
   * vector object.
   *
   * @return a new vector object with the corresponding components being multiplied by this constant
   */
  public Vector3D multiply(double constant) {
    return new Vector3D(this.x * constant, this.y * constant, this.z * constant);
  }

  /**
   * A method that returns the dot product of this vector and another vector.
   *
   * @return a double value that represents the dot product of the two vectors.
   */
  public double dotProduct(Vector3D other) {
    return (this.x * other.x + this.y * other.y + this.z * other.z);
  }

  /**
   * A method that returns the angle between two vectors in degrees. When any of the magnitude of
   * the two vectors is zero, throws an exception as the operation cannot be completed.
   *
   * @return a double value of the angle between two vectors in degrees.
   * @throws IllegalStateException when any or both of the corresponding magnitude is zero.
   */
  public double angleBetween(Vector3D other) {
    if (this.getMagnitude() * other.getMagnitude() == 0) {
      throw new IllegalStateException("Magnitude is zero, this operation cannot be completed.");
    }
    double cosAngle = this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude());
    return Math.acos(cosAngle) * 180 / Math.PI;
  }
}


