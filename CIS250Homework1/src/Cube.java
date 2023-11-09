
public class Cube extends ThreeDimensionalShape implements Comparable<ThreeDimensionalShape>{
	private int length;
	
	public Cube() {
		super();
		numSides = 6;
	}
	public Cube(String p_name, String p_color, int p_length) {
		super(p_name, p_color);
		length = p_length;
		numSides = 6;
	}
	
	@Override
	protected double volume() {
		double volume = Math.pow(length, 3);
		return volume;
	}

	@Override
	protected double surfaceArea() {
		double surfaceArea = 6 * Math.pow(length, 2);
		return surfaceArea;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Length: " + length + "\n";
		//color name - 
		//Surface Area: surfaceArea surfAreaUnit
		//Volume: volume volUnit
		//Number of Sides: numSides
		//Length: length
	}
	
	@Override
	public int compareTo(ThreeDimensionalShape otherShape) {
		int result = super.compareTo(otherShape);
		return result;
	}
	
	public void setLength(int p_length) {
		length = p_length;
	}
	public int getLength() {
		return length;
	}
	
}