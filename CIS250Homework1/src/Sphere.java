
public class Sphere extends ThreeDimensionalShape implements Comparable<ThreeDimensionalShape>{
	private int radius;
	
	public Sphere() {
		super();
		numSides = 1;
		radius = -1;
	}
	public Sphere(String p_name, String p_color, int p_radius) {
		super(p_name, p_color);
		radius = p_radius;
		numSides = 1;
	}
	
	@Override
	protected double volume() {
		double volume = (4.00/3.00) * 3.14 * Math.pow(radius, 3);
		return volume;
	}

	@Override
	protected double surfaceArea() {
		double surfaceArea = 4 * 3.14 * Math.pow(radius, 2);
		return surfaceArea;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Radius: " + radius + "\n";
		//Color Name - 
		//Surface Area: surfaceArea surfAreaUnit
		//Volume: volume volUnit
		//Number of Sides: numSides
		//Radius: radius
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

}