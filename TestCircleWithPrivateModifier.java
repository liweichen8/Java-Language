// TestCircleWithPrivateModifier.java: Demonstrate private modifier
public class TestCircleWithPrivateModifier {
  public static void main(String[] args)  {  // Main method

    // Create a Circle with radius 5.0
    Circle1 myCircle = new Circle1(5.0);
    System.out.println("The area of the circle of radius "
      + myCircle.getRadius() + " is " + myCircle.findArea());

    // Increase myCircle's radius by 10%
    myCircle.setRadius(myCircle.getRadius()*1.1);
    System.out.println("The area of the circle of radius "
      + myCircle.getRadius() + " is " + myCircle.findArea());
  }
}

class Circle1 {// Declare class Circle with private radius and accessor methods
	private double radius;

	public Circle1() {  // Default constructor
		radius = 1.0;
	}

	public Circle1(double r) {  // Construct a circle with a specified radius
		radius = r;
	}

	public double getRadius() {// Getter (accessor) method for radius
		return radius;
	}

	public void setRadius(double newRadius) {// Setter (mutator) method for radius
		radius = newRadius;
	}

	public double findArea() {  // Find the circle area	
		return radius*radius*3.14159;
	}
}

