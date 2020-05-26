
public class Circle extends GeometricShape{
	private double radius;

	public Circle()  { // Default constructor
		this(1.0, "white", 1.0);
	}

// Construct circle with specified radius
	public Circle(double radius)  {     
		super("white", 1.0);
		this.radius = radius;
	}

  // Construct a circle with specified radius, weight, and color
	public Circle(double radius, String color, double weight)  {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius()  { // Getter method for radius
		return radius;
	}
	
	public void setRadius(double radius) {// Setter method for radius
		this.radius = radius;
	}

	// Implement the findArea method defined in GeometricShape
	public double findArea() {
		return radius*radius*Math.PI;
	}

  // Implement the findPerimeter method defined in GeometricShape
	public double findPerimeter()  {
		return 2*radius*Math.PI;
	}

	public boolean equals(Circle circle)  {
		return this.radius == circle.getRadius();
	}
	
	// Override the equals() method defined in the Object class	
	public boolean equals(Object o) {
		if (o instanceof Circle) {
			Circle circle = (Circle) o;
			if (this.radius == circle.getRadius())
				return true;
	    }
		return false;
	}

	// Override the toString() method defined in the Object class
	public String toString()  {
		return "[Circle] radius = " + radius;
	}
} 
