
public class Triangle extends TwoDimensionalShape implements Comparable<TwoDimensionalShape>{
	private int base;
	private int height;
		
	public Triangle() {
		super();
		numSides = 3;
	}
	public Triangle(String p_name, String p_color,  int p_base, int p_height) {
		super(p_name, p_color);
		numSides = 3;
		base = p_base;
		height = p_height;
	}
	
	@Override
	protected double area() {
		double area = base * height * 0.5;
		return area;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nBase: " + base + "\nHeight: " + height + "\n";
		//color name - 
		//Area: area unit
		//Number of Sides: numSides
		//Base: width
		//Height: length
	}
	
	@Override
	public int compareTo(TwoDimensionalShape otherShape) {
		int result = super.compareTo(otherShape);
		return result;
	}
	
	public void setHeight(int p_height) {
		height = p_height;
	}
	public int getHeight() {
		return height;
	}
	
	public void setBase(int p_base) {
		base = p_base;
	}
	public int getBase() {
		return base;
	}
	
}