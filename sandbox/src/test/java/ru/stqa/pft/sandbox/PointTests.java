package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import exercise1.Point;

public class PointTests {

 @Test
  public void testDistance() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(10, 1);
    //Assert.assertEquals(p1.distance(p2), 0.0);
     System.out.println(p1.distance(p2));
  }
}
