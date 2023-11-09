//Square has same length and width, so only one needs to be defined
//Squares all have four sides at 90 degree angles.
//Units for area are cm^2

public class Square extends TwoDimensionalShape implements Comparable<TwoDimensionalShape>{
	private int length;
	
	public Square() { //Default constructor
		super();
		numSides = 4;
	}
	public Square(String p_name, String p_color, int p_length) {
		super(p_name, p_color);
		numSides = 4;
		length = p_length;
	}
	
	public double area() {
		double area = Math.pow(length, 2);
		return area;
	}

	@Override
	public String toString() {
		return super.toString() + "\nLength: " + length +  "\n";
		//Color Name - 
		//Area: area unit
		//Number of Sides: numSides
		//Length: length
	}
	@Override
	public int compareTo(TwoDimensionalShape otherShape) {
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
