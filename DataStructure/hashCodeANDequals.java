//class has to override equals(), hashCode() if want to have a different meaning than comparing the reference
class Coordinate {
  public int x;
  public int y;
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

Coordinate one = new Coordinate(0, 0);
Corrdinate two = new Coordinate(0, 0);

System.out.println(one == another); //false
System.out.println(one.equals(another)); //false, not overriden yet

*******************************************

class Point {
  public int x;
  public int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj == this) {
      return true;
    }
    if(!(obj instanceof Point)) {
      return false;
    }
    Point another = (Point) obj;
    return this.x == another.x && this.y == another.y;
  }
  
}

*******************************************

class Point {
  int x;
  int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(!(obj instanceof Point)) {
      return false;
    }
    Point another = (Point) obj;
    return this.x == another.x && this.y == another.y;
  }
  @Override
  public int hashCode() {
    return x*101 + y;
  }
}

//common hashCode() implementation
class Combo {
  ...
  @Override
  public int hashCode() {
    return a*31*31 + b.hashCode()*31 + c.hashCode;
  }
}












