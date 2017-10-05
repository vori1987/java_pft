package mytest;

public class Prostokat {
  public double a;
  public double b;


  public Prostokat(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public static double r(Prostokat r) {
    return r.a * r.b;
  }

  public static void main(String[] args) {
    Prostokat r = new Prostokat(2, 2);

    System.out.println("Площадь " + r(r));
  }

}




