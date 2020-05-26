/*
import java.io.*;
import java.util.ArrayList;
public class GeometricShapes {
	static ArrayList<Shapes> GeometricList = new ArrayList<Shapes>();
	static int numObject = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int choice=0;
		while(choice!=5){
			System.out.println("Please enter a number to make your choice.");
			System.out.println("Please enter '1' to create a gemetric shape.");
			System.out.println("Please enter '2' to find a particular object based on the unique key.");
			System.out.println("Please enter '3' to show the number of objects.");
			System.out.println("Please enter '4' to list all the objects in the database.");
			System.out.println("Please enter '5' to exit.");
			choice=Integer.parseInt(br.readLine());
			System.out.println();

			switch(choice){
			case 1:
				System.out.println("Please enter a number to choose to default or custom an object.");
				System.out.println("'1':default; '2':custom");
				choice=Integer.parseInt(br.readLine());
				switch(choice){
				case 1:
					Default();//allow the user to create a default shape
					break;
				case 2:
					Custom();//allow the user to create a custom shape
					break;
				}
				break;
			case 2:
				Find();//to find a particular object in the database 
				break;
			case 3:
				Number();//to show the number of objects
				break;
			case 4:
				List();//to list all the objects you have already created
				break;
			case 5:
				break;	
			}
			if (choice==5)
				break;
		}
			System.out.println("The program exits.");
		}//end of main method
	
	
	public static void Choose(){
		System.out.println("Please enter a number to choose what kind of shape you want to create.");
		System.out.println("TwoD shapes: '1':square; '2':rectabgle; '3':Rhombus; '4':Parallelogram; '5':IsoTrapezoid '6':Kite");
		System.out.println("ThreeD shapes: '7': cube; '8': cuboid");
		System.out.println("'9': exit");
	}
	public static void Default() throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int option=0;
		Choose();
		option=Integer.parseInt(br.readLine());
		System.out.println();

		while(option!=9){
			switch(option){
			case 1:
				GeometricList.add(new Square());
				break;
			case 2:
				GeometricList.add(new Rectangle());
				break;
			case 3:
				GeometricList.add(new Rhombus());
				break;
			case 4:
				GeometricList.add(new Parallelogram());
				break;
			case 5:
				GeometricList.add(new IsoTrapezoid());
				break;
			case 6:
				GeometricList.add(new Kite());
				break;
			case 7:
				GeometricList.add(new Cube());
				break;
			case 8:
				GeometricList.add(new Cuboid());
				break;
			default:
				System.out.println ("The number you enter is incorrect.Please enter number between 1 and 9");
				break;
			}
			System.out.println("This is your No." + (numObject+1) + " shape's object");//It tells the user the number of the shape is created
			System.out.println(GeometricList.get(numObject).toString());//output the attributes of the shape
			numObject++; 
			System.out.println();
			System.out.println("Please enter a numer to cotinue to create a default object.");
			System.out.println("Please enter '9' to go back to the main menu.");
			option = Integer.parseInt(br.readLine());
			System.out.println();
		}
	}
	public static double input(String words) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double value;
		System.out.print(words);
		value = Double.parseDouble(br.readLine());
		return value;
	}

	public static void Custom() throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int option=0;
		Choose();
		option=Integer.parseInt(br.readLine());
		while (option!=9){
			switch(option){
			case 1:
				GeometricList.add(new Square(input("Please enter the width of the square: "),true));
				break;
			case 2:
				GeometricList.add(new Rectangle(input("Please enter the width of the rectangle: "),
						input("please enter the length of the rectangle: ")));
				break;
			case 3:
				GeometricList.add(new Rhombus(input("Please enter the width of the rhombus: "),
						input("please enter the height of the rhombus: "), true));
				break;
			case 4:
				GeometricList.add(new Parallelogram(input("Please enter the width of the Parallelogram: "),
						input("please enter the height of the Parallelogram: "), 
						input("please enter the widthbase of the Parallelogram: "), true));
				break;
			case 5:
				GeometricList.add(new IsoTrapezoid(input("Please enter the width of the IsoTrapezoid: "),
						input("please enter the height of the IsoTrapezoid: "), 
						input("please enter the widthbase of the IsoTrapezoid: "), 
						input("please enter the widthtop of the IsoTrapezoid: "),true));
				break;
			case 6:
				GeometricList.add(new Kite(input("Please enter the first diagonal of the Kite: "),
						input("please enter the second diagonal of the Kite: "), 
						input("please enter the short width of the Kite: "), 
						input("please enter the long width of the Kite: ")));
				break;
			case 7:
				GeometricList.add(new Cube(input("Please enter the width of the Cube: "),true));
				break;
			case 8:
				GeometricList.add(new Cuboid(input("Please enter the width of the Cuboid: "), 
						input("please enter the length of the Cuboid: "), 
						input("please enter the height of the Cuboid: ")));
				break;
			case 9:
				break;
			default:
				System.out.println ("The number you enter is incorrect. Please enter the number between 1 and 9.");
				break;
			}
			System.out.println("This is your No." + (numObject+1) + " shape's object");//It tells the user the number of the shape is created
			System.out.println(GeometricList.get(numObject).toString());//output the attributes of the shape
			numObject++; 
			System.out.println();
			System.out.println("Please enter a numer to cotinue to create a custom object.");
			System.out.println("Please enter '9' to go back to the main menu.");
			option = Integer.parseInt(br.readLine());
			System.out.println();
		}
	}
	public static void Find()throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		boolean search=false;
		System.out.println("Unique ID is combinded with a particular code and the number of index. Ex. s001 represents a square with the index of 1");
		System.out.println("Please enter a unique ID to find the particular geometricshape you have already created,");
		System.out.println("UniqueID for TwoD shapes:");
		System.out.println("Square: s00; Rectangle: r00; Rhombus: r01; Parallelogram: p00; IsoTrapezoid: i00; Kite: k00");
		System.out.println("UniqueID for ThreeD shapes:");
		System.out.println("Cube: c00; Cuboid: c01");
		String code;
		code= br.readLine();
		for (int x=0;x<GeometricList.size();x++){
			if (GeometricList.get(x).getUniqueID().equals(code)){
				System.out.println(GeometricList.get(x).toString());
				search=true;
			}
		}
		if (search==false){
			System.out.println("Sorry, the particular object you are looking for does not exit.");
		}

	}
	public static void Number(){
		System.out.println("The total number of geometries that are created is "+Shapes.getNumGeometry());
		System.out.println("The number of squares is "+Square.getNumSquare()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of rectangles is "+Rectangle.getNumRectangle()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of rhombus is "+Rhombus.getNumRhombus()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of parallelogram is "+Parallelogram.getNumParallelogram()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of isotrapezoid is "+IsoTrapezoid.getNumIsoTrapezoid()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of kites is "+Kite.getNumKite()+" The number of quadrilaterals is " +TwoDShapes.getNumTwoD());
		System.out.println("The number of cubes is "+Cube.getNumCube()+" The number of threeD shapes is " +ThreeDShapes.getNumThreeD());
		System.out.println("The number of cuboids is "+Cuboid.getNumCuboid()+" The number of threeD shapes is " +ThreeDShapes.getNumThreeD());
System.out.println();
	}
	public static void List(){
		for (byte i = 0; i < GeometricList.size(); i++){
			System.out.println("It is NO. "+i+"shape.");
			System.out.println(GeometricList.get(i).toString());
			System.out.println();
		}
	}
}

abstract class Shapes{
	private static int numGeometry=0;
	public Shapes(){
		numGeometry++;
	}
	public static int getNumGeometry(){
		return numGeometry;
	}
public abstract String getUniqueID();
}
abstract class TwoDShapes extends Shapes{
	private static int numTwoD=0;
	public TwoDShapes(){
		numTwoD++;
	}
	public static int getNumTwoD(){
		return numTwoD;
	}
	public abstract double findArea();
	public abstract double findPerimeter();
}
abstract class ThreeDShapes extends Shapes{
	private static int numThreeD=0;
	public ThreeDShapes(){
		numThreeD++;
	}
	public static int getNumThreeD(){
		return numThreeD;
	}
	public abstract double findSurfaceArea();
	public abstract double findVolume();
}
class Square extends TwoDShapes{
	private static int numSquare=0;
	private double width;
	private String SquareCode;

	public Square(){
		super();
		width=1.0;
		numSquare++;
		SquareCode="s00"+numSquare;
	}

	public Square(double width,boolean result){
		super();
		this.width=width;
		if (result ==true)
		numSquare++;
		SquareCode="s00"+numSquare;
	}
	public static int getNumSquare(){
		return numSquare;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double w){
		width=w;
	}
	public String getUniqueID(){
		return SquareCode;
	}
	public double findArea(){
		return width*width;
	}
	public double findPerimeter(){
		return width*4;
	}
	public boolean equals(Object o){
		if (o instanceof Square){
			Square s=(Square)o;
			if (this.width ==s.width){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the square is "+getWidth()+"\n"+"The area is "+ findArea()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
final class Rectangle extends Square{
	private static int numRectangle=0;
	private double length;
	private String RectangleCode;

	public Rectangle(){
		super(1.0,false);
		length=2.0;
		numRectangle++;
		RectangleCode="r00"+numRectangle;
	}

	public Rectangle(double width,double length){
		super(width,false);
		this.length=length;
		numRectangle++;
		RectangleCode="r00"+numRectangle;
	}
	public static int getNumRectangle(){
		return numRectangle;
	}
	public double getLength(){
		return length;
	}
	public void setLength(double l){
		length=l;
	}
	public String getUniqueID(){
		return RectangleCode;
	}
	public double findArea(){
		return getWidth()*length;
	}
	public double findPerimeter(){
		return (getWidth()+length)*2;
	}
	public boolean equals(Object o){
		if (o instanceof Rectangle){
			Rectangle r=(Rectangle)o;
			if (this.length ==r.length){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the rectangle is "+getWidth()+"\n"+
				"The length is "+getLength()+"\n"+"The area is "+ findArea()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
class Rhombus extends Square{
	private static int numRhombus=0;
	private double height;
	private String RhombusCode;
	public Rhombus(){
		super(1.0,false);
		height=2.0;
		numRhombus++;
		RhombusCode="r01"+numRhombus;
	}
	public Rhombus(double width,double height,boolean result){
		super(width,false);
		this.height=height;
		if (result==true)
		numRhombus++;
		RhombusCode="r01"+numRhombus;
	}
	public static int getNumRhombus(){
		return numRhombus;
	}
	public double getHeight(){
		return height;
	}
	public void setLength(double h){
		height=h;
	}
	public String getUniqueID(){
		return RhombusCode;
	}
	public double findArea(){
		return getWidth()*height;
	}
	public double findPerimeter(){
		return getWidth()*4;
	}
	public boolean equals(Object o){
		if (o instanceof Rhombus){
			Rhombus r=(Rhombus)o;
			if (this.height ==r.height){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the rhombus is "+getWidth()+"\n"+
				"The height is "+getHeight()+"\n"+"The area is "+ findArea()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}

class Parallelogram extends Rhombus{
	private static int numParallelogram=0;
	private double widthbase;
	private String ParallelogramCode;
	public Parallelogram(){
		super(1.0,2.0,false);
		widthbase=3.0;
		numParallelogram++;
		ParallelogramCode="p00"+numParallelogram;
	}
	public Parallelogram(double width,double height,double widthbase,boolean result){
		super(width,height,false);
		this.widthbase=widthbase;
		if(result==true)
		numParallelogram++;
		ParallelogramCode="p00"+numParallelogram;
	}
	public static int getNumParallelogram(){
		return numParallelogram;
	}
	public double getWidthbase(){
		return widthbase;
	}
	public void setWidthbase(double w){
		widthbase=w;
	}
	public String getUniqueID(){
		return ParallelogramCode;
	}
	public double findArea(){
		return getHeight()*widthbase;
	}
	public double findPerimeter(){
		return (widthbase+getWidth())*2;
	}
	public boolean equals(Object o){
		if (o instanceof Parallelogram){
			Parallelogram p=(Parallelogram)o;
			if (this.widthbase ==p.widthbase){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the parallelogram is "+getWidth()+"\n"+
				"The height is "+getHeight()+"\n"+"The area is "+ findArea()+"\n"
				+"The widthbase is "+getWidthbase()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
class IsoTrapezoid extends Parallelogram{
	private static int numIsoTrapezoid=0;
	private double widthtop;
	private String IsoTrapezoidCode;

	public IsoTrapezoid(){
		super(1.0,2.0,3.0,false);
		widthtop=0.5;
		numIsoTrapezoid++;
		IsoTrapezoidCode="i00"+numIsoTrapezoid;
	}
	public IsoTrapezoid(double width,double height,double widthbase,double widthtop,boolean result){
		super(width,height,widthbase,false);
		this.widthtop=widthtop;
		if(result=true)
		numIsoTrapezoid++;
		IsoTrapezoidCode="i00"+numIsoTrapezoid;
	}
	public static int getNumIsoTrapezoid(){
		return numIsoTrapezoid;
	}
	public double getWidthtop(){
		return widthtop;
	}
	public void setWidthtop(double w){
		widthtop=w;
	}
	public String getUniqueID(){
		return IsoTrapezoidCode;
	}
	public double findArea(){
		return (widthtop+getWidthbase())*getHeight()/2;
	}
	public double findPerimeter(){
		return getWidth()*2+getWidthbase()+widthtop;
	}
	public boolean equals(Object o){
		if (o instanceof IsoTrapezoid){
			IsoTrapezoid i=(IsoTrapezoid)o;
			if (this.widthtop ==i.widthtop){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the IsoTrapezoid is "+getWidth()+"\n"+
				"The height is "+getHeight()+"\n"+"The widthbase is "+getWidthbase()+"\n"+
				"The widthtop is "+getWidthtop()+"\n"+
				"The area is "+ findArea()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
final class Kite extends IsoTrapezoid{
	private static int numKite=0;
	private double diagonal;
	private String KiteCode;

	public Kite(){
		super(1.0,2.0,3.0,0.5,false);
		diagonal=1.0;
		numKite++;
		KiteCode="k00"+numKite;
	}
	public Kite(double width,double height,double widthbase,double widthtop){
		super(width,height,widthbase,widthtop,false);
		this.diagonal=width;
		numKite++;
		KiteCode="k00"+numKite;
	}
	public static int getNumKite(){
		return numKite;
	}
	public double getDiagonal(){
		return diagonal;
	}
	public void setDiagonal(double d){
		diagonal=d;
	}
	public String getUniqueID(){
		return KiteCode;
	}
	public double findArea(){
		return (diagonal * getHeight()) / 2;
	}
	public double findPerimeter(){
		return getWidthtop()*2+getWidthbase()*2;
	}
	public boolean equals(Object o){
		if (o instanceof Kite){
			Kite k=(Kite)o;
			if (this.diagonal ==k.diagonal){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The diagonal of the kite is "+getWidth()+"\n"+
				"The second diagonal is "+getHeight()+"\n"+"The area is "+ findArea()+"\n"
				+"The long width is "+getWidthbase()+"\n"+
				"The short width is "+getWidthtop()+"\n"+
				"The perimeter is "+findPerimeter()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
class Cube extends ThreeDShapes{
	private static int numCube=0;
	private double width;
	private String CubeCode;

	public Cube(){
		super();
		width=1.0;
		numCube++;
		CubeCode="c00"+numCube;
	}

	public Cube(double width,boolean result){
		super();
		this.width=width;
		if (result==true)
		numCube++;
		CubeCode="c00"+numCube;
	}
	public static int getNumCube(){
		return numCube;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double w){
		width=w;
	}
	public String getUniqueID(){
		return CubeCode;
	}
	public double findSurfaceArea(){
		return width*width*6;
	}
	public double findVolume(){
		return width*width*width;
	}
	public boolean equals(Object o){
		if (o instanceof Cube){
			Cube c=(Cube)o;
			if (this.width ==c.width){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the cube is "+width+"\n"+"The surface area is "+ findSurfaceArea()+"\n"+
				"The volume is "+findVolume()+"\n"+
				"The unique key is "+getUniqueID();
	}
}
final class Cuboid extends Cube{
	private static int numCuboid=0;
	private double length,height;
	private String CuboidCode;

	public Cuboid(){
		super(1.0,false);
		length=1.0;
		height=2.0;
		numCuboid++;
		CuboidCode="c01"+numCuboid;
	}

	public Cuboid(double width,double length,double height){
		super(1.0,false);
		this.length=length;
		this.height=height;
		numCuboid++;
		CuboidCode="c01"+numCuboid;
	}
	public static int getNumCuboid(){
		return numCuboid;
	}
	public double getLength(){
		return length;
	}
	public void setLength(double l){
		length=l;
	}
	public double getHeight(){
		return height;
	}
	public void setHeight(double h){
		height=h;
	}
	public String getUniqueID(){
		return CuboidCode;
	}
	public double findSurfaceArea(){
		return (length*getWidth())*2+(getWidth()*height)*2+(length*height)*2;
	}
	public double findVolume(){
		return length*height*getWidth();
	}
	public boolean equals(Object o){
		if (o instanceof Cuboid){
			Cuboid c=(Cuboid) o;
			if (this.length ==c.length&& this.height==c.height){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "The width of the cuboid is "+getWidth()+"\n"+
				"The length is "+getLength()+"\n"+"The height is "+getHeight()+"\n"+
				"The surface area is "+ findSurfaceArea()+"\n"+
				"The volume is "+findVolume()+"\n"+
				"The unique key is "+getUniqueID();
	}
}

*/
