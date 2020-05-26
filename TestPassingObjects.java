public class TestPassingObjects {  // Main method
	public static void main(String[] args) {    
   		 Circle2 myCircle = new Circle2();

    		int n = 5; // Print areas for radius 1, 2, 3, 4, and 5.
    		printAreas(myCircle, n);

   		System.out.println("\n" + "Radius is " + myCircle.radius);
    		System.out.println("n is " + n);
  	}

  	public static void printAreas(Circle2 c, int times){
   		 System.out.println("Radius \t\tArea");
    		while (times >= 1){
     			System.out.println(c.radius + "\t\t" + c.findArea());
      			c.radius++;
     			times--;
    		}
  	}
}
class Circle2 {	// Circle class  with two constructors
  	double radius;

  	Circle2(){	// Default constructor
   		radius = 1.0;
  	}
  	Circle2(double radius) { // Construct a circle with a specified radius

	this.radius=radius;
  	}
  	double findArea() {	// Find area of this circle
   		 return radius*radius*3.14159;
  	}
}/*Note: The program contains two classes*/ 
