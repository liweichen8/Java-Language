public abstract class GeometricShape{
	protected String color;
	protected double weight;

	protected GeometricShape() {  // Default construct
		color = "white";
		weight = 1.0;
	}

	protected GeometricShape(String color, double weight)  { 
		// Construct a geometric object
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {  // Getter method for color
		return color;
	}

	public void setColor(String color)  {  // Setter method for color
		this.color = color;
	}

	public double getWeight()  {  // Getter method for weight
		return weight;
	}

	public void setWeight(double weight) {  // Setter method for weight
		this.weight = weight;
	}

	public abstract double findArea();// Abstract method

	public abstract double findPerimeter();  // Abstract method

}


