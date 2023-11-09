
public class TetraHedron extends ThreeDimensionalShape implements Comparable<ThreeDimensionalShape>{
	private int length;
	private int width;
	private int height;
	
	public TetraHedron() {
		super();
		numSides = 4;
		length = -1;
		width = -1;
		height = -1;
	}
	public TetraHedron(String p_name, String p_color, int p_length, int p_width, int p_height) {
		super(p_name, p_color);
		numSides = 4;
		length = p_length;
		width = p_width;
		height = p_height;
	}
	
	@Override
	protected double volume() {
		double baseArea = length * width;
		double volume = baseArea * height * (1.00/3.00);
		return volume;
	}

	@Override
	protected double surfaceArea() {
		double baseArea = length * width;
		double lateralArea = (length * height * 0.5) * 3; 
		double surfaceArea = baseArea + lateralArea;
		return surfaceArea;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Length: " + length + "\nWidth: " + width + "\nHeight: " + height + "\n";
		//Color Name - 
		//Surface Area: surfaceArea surfAreaUnit
		//Volume: volume volUnit
		//Number of Sides: numSides
		//Length: length
		//Width: width
		//Height: height
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
	
	public void setWidth(int p_width) {
		width = p_width;
	}
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int p_height) {
		height = p_height;
	}
	public int getHeight() {
		return height;
	}
}