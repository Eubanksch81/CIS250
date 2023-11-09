
public class Circle extends TwoDimensionalShape implements Comparable<TwoDimensionalShape>{
	private int radius;
	
	public Circle() {
		super();
		radius = -1;
		numSides = 1;
	}
	public Circle(String p_name, String p_color, int p_radius) {
		super(p_name, p_color);
		radius = p_radius;
		numSides = 1;
	}
	
	@Override
	protected double area() {
		double area = Math.pow(radius, 2) * 3.14; //Radius^2 * pi. Using Math.pi leads to a crazy specific double value
		return area;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nRadius: " + radius + "\n";
		//color name - 
		//Area: area unit
		//Number of Sides: numSides
		//Radius: radius
	}
	
	@Override
	public int compareTo(TwoDimensionalShape otherShape) {
		int result = super.compareTo(otherShape);
		return result;
	}
	
	public void setRadius(int p_radius) {
		radius = p_radius;
		area(); //Gets new area for the changed radius
	}
	public int getRadius() {
		return radius;
	}

}