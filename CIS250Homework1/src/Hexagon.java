
public class Hexagon extends TwoDimensionalShape implements Comparable<TwoDimensionalShape> {
	private int apothem; //Distance from center to one of the sides, similar to a radius.
	private int length;
	
	public Hexagon() {
		super();
		numSides = 6;
		apothem = -1;
		length = -1;
	}
	public Hexagon(String p_name, String p_color,  int p_sideLength, int p_apothem) {
		super(p_name, p_color);
		length = p_sideLength;
		apothem = p_apothem;
		numSides = 6;
	}
	
	@Override
	protected double area() {
		double area = numSides * length * apothem;
		//Length in this case is the length of each individual side.
		//There is no width here, but the apothem is individually defined for this polygon.
		return area;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nLength of Each Side: " + length +
				"\nApothem: " + apothem + "\n";
		//color name - 
		//Area: area unit
		//Number of Sides: numSides
		//Length of Each Side: length
		//Apothem: apothem
	}
	
	@Override
	public int compareTo(TwoDimensionalShape otherShape) {
		int result = super.compareTo(otherShape);
		return result;
	}
	
	public void setApothem(int p_apothem) {
		apothem = p_apothem;
	}
	public int getApothem() {
		return apothem;
	}
	
	public void setLength(int p_length) {
		length = p_length;
	}
	public int getLength() {
		return length;
	}
	
}