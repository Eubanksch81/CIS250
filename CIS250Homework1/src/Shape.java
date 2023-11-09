/* 
 * Charles Eubanks, CIS250.920, HW1, Shape Inheritance
 */


//This class is abstract because it only should define the methods that are used in every possible shape.
//The only classes that should be instantiable are the ones that describe a specific object. 

public abstract class Shape { //Abstract, Main base class
	protected String name;
	protected String color;
	protected int numSides;
	
	public Shape() {
		name = "NULL";
		color = "NULL";
	}
	public Shape(String p_name, String p_color) {
		name = p_name;
		color = p_color;
	}
	
	@Override
	public String toString() {
		return color + " " + name  + " - \n"; 
		//Color Name - 
	}
	
	public int compareTo(Shape otherShape) {
		int result = -10;
		if (toString().equals(otherShape.toString())) { //If both objects are the same color and name. 
			//Will do numerical comparisons for more detailed shapes.
			result = 0;
		}
		return result;
	}
	
	public void setName(String p_name) {
		name = p_name;
	}
	public String getName() {
		return name;
	}
	
	public void setColor(String p_color) {
		name = p_color;
	}
	public String getColor() {
		return color;
	}	
	
	public int getNumSides() { //Will not do setNumSides, as numSides is hardcoded for each class.
		return numSides;
	}
}

