package ru.stqa.pft.rest.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import exercise1.Point;

public class PointTests {

 @Test
  public void testDistance() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1, 2);
    Assert.assertEquals(p1.distance(p2), 1.0);
  }
}
