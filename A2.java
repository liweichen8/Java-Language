/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public  class A2 {
	public static void main(String[] args) throws IOException  {    
		boolean exit = false;
		String menu;
		ArrayList<GeometricShape> ObjectList = new ArrayList<GeometricShape>();
		//TwoDGeometricShape mySquare = new IsoTrapezoid(2.0,3.0,1.5,1,true);
		while (!exit){
			System.out.print("Please enter the shape you want to create: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 menu=br.readLine();
			 switch (menu.toLowerCase()){
			 case "1" : case "square" :
				 ObjectList.add(new Square(inputDouble("please enter the width for the square"), true));
			 case "2" : case "rectangle":
		
				 
			 }
			 exit=true;
		}
		System.out.println("The base is " + ((Square) ObjectList.get(0)).getWidth());
		System.out.println(ObjectList.get(0));
		//System.out.println("The top is " + ((IsoTrapezoid) mySquare).getWidth2());
		//System.out.println("The radius is " + myCylinder.getRadius());
		//System.out.println("The volume of the cylinder is " + mySquare.findPerimeter());
		//System.out.println("The area of the trapezoid is " + mySquare.findArea());
		System.out.println(Rectangle.getNumOfObjects()+""+Square.getNumOfObjects()+""+IsoTrapezoid.getNumOfObjects());
	}
	/**input method
	 * display a message and allow the user to input a number
	 * @param  message the message that would be displayed in the console
	 * @return  the user's input in integer type
	 
	public static double inputDouble (String message) throws IOException{
		System.out.print(message+": ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Double.parseDouble(br.readLine());
	}

}
abstract class GeometricShape {
	private static int numOfObjects =0;
	public GeometricShape() {
		numOfObjects ++;
	}
	public static int getNumOfGeneralObjects(){
		return numOfObjects;
	}
}

abstract class ThreeDShape extends GeometricShape {
	private static int numOf3DObjects =0;
	public ThreeDShape()  {
		numOf3DObjects++;
	}
	public static int getNumOfGeneral3DObjects()  {
		return numOf3DObjects;
	}
	public abstract double findVolume() ;
	public abstract double findSurfaceArea() ;
}

class Cube extends ThreeDShape  {
	private double width; // instance variable
	private static int numOfCube = 0;  // Class variable
	// Default constructor
	public Cube()  {
		super();
		width = 1.0;
		numOfCube++;
	}
	// Construct a object with a specified property
	public Cube(double width, boolean objectTF)  {
		super();
		this.width = width;
		if (objectTF)
			numOfCube++;
	}
	// Getter method for property
	public double getWidth()  {
		return width;
	}
	// Setter method for property
	public void setWidth(double width)  {
		this.width = width;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfCube;
	}
	// Override the toString method 
	public String toString(){
		return "The volume of the cube is "+findVolume()+", the surface area of the square is "+findSurfaceArea();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Cube) {
			Cube c = (Cube) bO;
			if (this.width==(c.getWidth())) return true;
		}
		return false;
	}

	public double findVolume() {
		return width*width*width;
	}
	public double findSurfaceArea() {
		return width*width*6;
	}
} 
final class RectangluarPrism extends Cube  {
	private double height, length; // instance variable
	private static int numOfRPrism = 0;  // Class variable
	// Default constructor
	public RectangluarPrism()  {
		super(1.0,false);
		height = 1.0;
		length = 1.0;
		numOfRPrism++;
	}
	// Construct a object with a specified property
	public RectangluarPrism(double width,double height, double length, boolean objectTF)  {
		super();
		this.height = height;
		this.length= length;
		if (objectTF)
			numOfRPrism++;
	}
	// Getter method for property
	public double getLength()  {
		return length;
	}
	// Setter method for property
	public void setLength(double length)  {
		this.length = length;
	}
	public double getHeight()  {
		return length;
	}
	// Setter method for property
	public void setHeight(double height)  {
		this.height= height;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfRPrism;
	}
	// Override the toString method 
	public String toString(){
		return "The volume of the rectangluar prism is "+findVolume()+", the surface area of the rectangluar prism is "+findSurfaceArea();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof RectangluarPrism) {
			RectangluarPrism c = (RectangluarPrism) bO;
			if (this.length==(c.getHeight())&&this.height==(c.getHeight())) return true;
		}
		return false;
	}

	public double findVolume() {
		return getWidth()*height*length;
	}
	public double findSurfaceArea() {
		return getWidth()*height*2+getWidth()*length*2+length*height*2;
	}
} 
abstract class TwoDGeometricShape extends GeometricShape {
	private static int numOf2DObjects = 0;  // Class variable
	public TwoDGeometricShape()  {
		numOf2DObjects++;
	}
	public static int getNumOfGeneral2DObjects()  {
		return numOf2DObjects;
	}
	public abstract double findArea() ;
	public abstract double findPerimeter() ;
}

class Square extends TwoDGeometricShape  {
	private double width; // instance variable
	private static int numOfSquares = 0;  // Class variable
	// Default constructor
	public Square()  {
		super();
		width = 1.0;
		numOfSquares++;
	}
	// Construct a object with a specified property
	public Square(double width, boolean objectTF)  {
		super();
		this.width = width;
		if (objectTF)
			numOfSquares++;
	}
	// Getter method for property
	public double getWidth()  {
		return width;
	}
	// Setter method for property
	public void setWidth(double width)  {
		this.width = width;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfSquares;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the square is "+findArea()+", the perimeter of the square is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Square) {
			Square c = (Square) bO;
			if (this.width==(c.getWidth())) return true;
		}
		return false;
	}
	public double findArea() {
		return width*width;
	}
	public double findPerimeter() {
		return width*4;
	}
} 

final class Rectangle extends Square  {
	private double length; // instance variable
	private static int numOfRectangles = 0;  // Class variable
	// Default constructor
	public Rectangle()  {
		super(1.0,false);// Explicitly call the super class default constructor (Note: will be called implicitly if you don’t explicitly call it)
		length = 1.0;
		numOfRectangles++;
	}
	// Construct a object with a specified property
	public Rectangle(double width, double length,boolean objectTF )  {
		super(width, false);
		this.length = length;
		numOfRectangles++;
	}
	// Getter method for property
	public double getLength()  {
		return length;
	}
	// Setter method for property
	public void setLength(double length)  {
		this.length = length;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfRectangles;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the Rectangle is "+findArea()+", the perimeter of the rectangle is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Rectangle) {
			Rectangle c = (Rectangle) bO;
			if (this.length==(c.getLength())) return true;
		}
		return false;
	}
	public double findArea() {
		return getWidth()*length;
	}
	public double findPerimeter() {
		return getWidth()*2+length*2;
	}
} 

class Rhombus extends Square  {
	private double height; // instance variable
	private static int numOfRhombus = 0;  // Class variable
	// Default constructor
	public Rhombus()  {
		super(1.0, false);// Explicitly call the super class default constructor (Note: will be called implicitly if you don’t explicitly call it)
		height = 1.0;
		numOfRhombus++;
	}
	// Construct a object with a specified property
	public Rhombus(double width, double height,boolean objectTF)  {
		super(width, false);
		this.height = height;
		if (objectTF)
			numOfRhombus++;
	}
	// Getter method for property
	public double getHeight()  {
		return height;
	}
	// Setter method for property
	public void setHeight(double height)  {
		this.height = height;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfRhombus;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the Rhombus is "+findArea()+", the perimeter of the rhombus is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Rhombus) {
			Rhombus c = (Rhombus) bO;
			if (this.height==(c.getHeight())) return true;
		}
		return false;
	}
	public double findArea() {
		return getWidth()*height;
	}
	public double findPerimeter() {
		return getWidth()*4;
	}
} 
class Parallelogram extends Rhombus  {
	private double sideLength; // instance variable
	private static int numOfPar = 0;  // Class variable
	// Default constructor
	public Parallelogram()  {
		super(1.0,1.0,false);// Explicitly call the super class default constructor (Note: will be called implicitly if you don’t explicitly call it)
		sideLength = 1.0;
		numOfPar++;
	}
	// Construct a object with a specified property
	public Parallelogram(double width, double height, double sideLength, boolean objectTF)  {
		super(width, height, false);
		this.sideLength = sideLength;
		if (objectTF)
			numOfPar++;
	}
	// Getter method for property
	public double getSideLength()  {
		return sideLength;
	}
	// Setter method for property
	public void setSideLength(double sideLength)  {
		this.sideLength= sideLength;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfPar;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the parallelogram is "+findArea()+", the perimeter of the parallelogram is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Parallelogram) {
			Parallelogram c = (Parallelogram) bO;
			if (this.sideLength==(c.getSideLength())) return true;
		}
		return false;
	}
	public double findArea() {
		return getWidth()*getHeight();
	}
	public double findPerimeter() {
		return getWidth()*2+sideLength*2;
	}
} 

class IsoTrapezoid extends Parallelogram  {
	private double width2; // instance variable
	private static int numOfIsoTrap = 0;  // Class variable
	// Default constructor
	public IsoTrapezoid()  {
		super(1.0,1.0,1.0,false);// Explicitly call the super class default constructor (Note: will be called implicitly if you don’t explicitly call it)
		width2 = 1.0;
		numOfIsoTrap++;
	}
	// Construct a object with a specified property
	public IsoTrapezoid(double width, double height, double sideLength, double width2, boolean objectTF)  {
		super(width, height, sideLength, false);
		this.width2 = width2;
		if (objectTF)
			numOfIsoTrap++;
	}
	// Getter method for property
	public double getWidth2()  {
		return width2;
	}
	// Setter method for property
	public void setWidth2(double width2)  {
		this.width2=width2;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfIsoTrap;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the isosceles trapezoid is "+findArea()+", the perimeter of the isosceles trapezoid is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof IsoTrapezoid) {
			IsoTrapezoid c = (IsoTrapezoid) bO;
			if (this.width2==(c.getWidth2())) return true;
		}
		return false;
	}
	public double findArea() {
		return (getWidth()+width2)*getHeight()/2;
	}
	public double findPerimeter() {
		return getWidth()+width2+getSideLength()*2;
	}
} 

final class Kite extends IsoTrapezoid  {
	private double diagonal; // instance variable
	private static int numOfKite = 0;  // Class variable
	// Default constructor
	public Kite()  {
		super(1.0,1.0,1.0,1.0,false);// Explicitly call the super class default constructor (Note: will be called implicitly if you don’t explicitly call it)
		diagonal= getWidth2();
		numOfKite++;
	}
	// Construct a object with a specified property
	public Kite(double width, double height, double sideLength, double diagonal, boolean objectTF)  {
		super(width, height, sideLength,diagonal, false);
		diagonal=getWidth2();
		if (objectTF)
			numOfKite++;
	}
	// Getter method for property
	public double getDiagonal()  {
		return diagonal;
	}
	// Setter method for property
	public void setDiagonal(double diagonal)  {
		this.diagonal=diagonal;
	}
	// Getter method for numOfObjects
	public static int getNumOfObjects()  {
		return numOfKite;
	}
	// Override the toString method 
	public String toString(){
		return "The area of the kite is "+findArea()+", the perimeter of the kite is "+findPerimeter();
	}
	// Override the equals method 
	public boolean equals(Object bO) {
		if (bO instanceof Kite) {
			Kite c = (Kite) bO;
			if (this.diagonal==(c.getDiagonal())) return true;
		}
		return false;
	}
	public double findArea() {
		return (getHeight()*diagonal)/2;
	}
	public double findPerimeter() {
		return getWidth()*2+getSideLength()*2;
	}
}
*/
