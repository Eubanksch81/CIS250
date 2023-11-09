
//This class is abstract because it only should define the methods that are used in every possible 3D shape.
//The only classes that should be instantiable are the ones that describe a specific object. 

public abstract class ThreeDimensionalShape extends Shape implements Comparable<ThreeDimensionalShape> { //Abstract Extension of Shape
	protected String surfAreaUnit = "cm^2";
	protected String volUnit = "cm^3";
	
	public ThreeDimensionalShape() {
		super(); //Calls default constructor with default values
	}
	public ThreeDimensionalShape(String p_name, String p_color) {
		super(p_name, p_color);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Surface Area: " + surfaceArea() + " " + surfAreaUnit +
				"\nVolume: " + volume() + " " +  volUnit + "\nNumber of Sides: " + numSides + "\n";
		//Color Name - 
		//Surface Area: surfaceArea surfAreaUnit
		//Volume: volume volUnit
		//Number of Sides: numSides
	}
	
	@Override
	public int compareTo(ThreeDimensionalShape otherShape) {
		int result;
		if ((volume() + surfaceArea()) == (otherShape.volume() + otherShape.surfaceArea())) {
			result = 0;
		}
		else if ((volume() + surfaceArea()) > (otherShape.volume() + otherShape.surfaceArea())) {
			result = 1;
		}
		else if ((volume() + surfaceArea()) > (otherShape.volume() + otherShape.surfaceArea())){
			result = -1;
		}
		else {
			result = -10;
		}
		return result;
	}
	
	protected abstract double volume();
	protected abstract double surfaceArea();
	
	public String getsurfAreaUnit() { //Will not do setUnit, as unit is hardcoded for 3D objects.
		return surfAreaUnit;
	}
	public String getVolUnit() {
		return volUnit;
	}
}