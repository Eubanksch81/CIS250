
//This class is abstract because it only should define the methods that are used in every possible 2D shape.
//The only classes that should be instantiable are the ones that describe a specific object. 

public abstract class TwoDimensionalShape extends Shape implements Comparable<TwoDimensionalShape> { //Abstract Extension of Shape
	protected String unit = "cm^2";
	
	public TwoDimensionalShape() {
		super(); //Calls default constructor with default values
	}
	public TwoDimensionalShape(String p_name, String p_color) {
		super(p_name, p_color);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Area: " + area() + " " + unit + "\nNumber of Sides: " + numSides;
		//Color Name - 
		//Area: area unit
		//Number of Sides: numSides
	}
	
	@Override
	public int compareTo(TwoDimensionalShape otherShape) {
		int result; 
		if (area() == otherShape.area()) {
			result = 0;
		}
		else if (area() > otherShape.area()) {
			result = 1;
		}
		else if (area() < otherShape.area()) {
			result = -1;
		}
		else {
			result = -10;
		}
		return result;
	}
	
	protected abstract double area();
	
	public String getUnit() { //Will not do setUnit, as the unit is hardcoded for 2D objects.
		return unit;
	}
}