package exercise2;

public class Point2 {
  public double x;
  public double y;

  public Point2(double x, double y) {
    this.x = x;
    this.y = y;
  }

 // public static double distance(Point p1, Point p2) {
  //  return Math.sqrt((Math.pow((p1.x - p2.x), 2)) + (Math.pow((p1.y - p2.y), 2)));
  //}
 public double distance(Point2 p1){
   return Math.sqrt((Math.pow((this.x - p1.x), 2)) + (Math.pow((this.y - p1.y), 2)));
 }
}
