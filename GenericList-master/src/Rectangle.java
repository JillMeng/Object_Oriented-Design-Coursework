public class Rectangle {

  private double x;
  private double y;
  private double width;
  private double height;

  public Rectangle(double x, double y, double width, double height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Non-positive width or height is not allowed");
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }


  public boolean overlap(Rectangle other) {
    if (this == other) {
      return true;
    }
    return ((this.x == other.x) && (this.y == other.x)
            && (other.tanAngle(double rightX2,double rightY2) == this.tanAngle(double rightX, double rightY)));


  //confirm the angle of the Rectangle by confirming the lower right conner
  double tanAngle(double rightX, double rightY) {
    double tanAngle = (rightY-this.y)/(rightX - this.x);
    return Math.atan(tanAngle) * 180 / Math.PI;
  }

  public String toString() {
    String str = String.format("x:%d, y:%d, w:%d, h:%d",this.x,this.y,this.width,this.height);
    return str;
  }
}
