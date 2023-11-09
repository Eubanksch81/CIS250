
public class Cylinder extends ThreeDimensionalShape implements Comparable<ThreeDimensionalShape>{
	private int radius;
	private int height;
	
	public Cylinder() { //Default constructor
		super();
		numSides = 3;
		radius = -1;
		height = -1;
	}
	public Cylinder(String p_name, String p_color, int p_radius, int p_height) {
		super(p_name, p_color);
		radius = p_radius;
		height = p_height;
		numSides = 3;
	}
	
	@Override
	protected double volume() {
		double volume = 3.14 * Math.pow(radius, 2) * height;
		return volume;
	}

	@Override
	protected double surfaceArea() {
		double surfaceArea = (2.0 * 3.14 * radius * height) + (2.0 * 3.14 * Math.pow(radius, 2));
		return surfaceArea;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Radius: " + radius + "\nHeight: " + height + "\n";
		//Color Name - 
		//Surface Area: surfaceArea surfAreaUnit
		//Volume: volume volUnit
		//Number of Sides: numSides
		//Radius: radius
		//Height: height
	}
	
	@Override
	public int compareTo(ThreeDimensionalShape otherShape) {
		int result = super.compareTo(otherShape);
		return result;
	}
	
	public void setRadius(int p_radius) {
		radius = p_radius;
	}
	public int getRadius() {
		return radius;
	}
	
	public void setHeight(int p_height) {
		height = p_height;
	}
	public int getHeight() {
		return height;
	}

}