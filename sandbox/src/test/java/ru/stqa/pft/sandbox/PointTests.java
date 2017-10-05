package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;
import zadanie2.Point;

public class PointTests {
  @Test
  public void testDistance() {
    Point p1= new Point(1, 1);
    Point p2= new Point(1, 2);
   Assert.assertEquals(p1.distance(p2), 1.0);

  }
}
