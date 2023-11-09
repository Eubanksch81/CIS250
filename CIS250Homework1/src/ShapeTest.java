/* 
 * Charles Eubanks, CIS250.920, HW1, Shape Inheritance
 */

import java.util.*;

public class ShapeTest { //For testing all classes

	public static void main(String[] args) {
		//Test the methods that we are supposed to define for each shape.
		ArrayList<Shape> shapesList = new ArrayList<Shape>();
		ArrayList<TwoDimensionalShape> twoDShapes = new ArrayList<TwoDimensionalShape>();
		ArrayList<ThreeDimensionalShape> threeDShapes = new ArrayList<ThreeDimensionalShape>();
		//2D Objects
		Circle circle1 = new Circle("Circle1", "Red", 3);
		shapesList.add(circle1);
		Circle circle2 = new Circle("Circle2", "Blue", 4);
		shapesList.add(circle2);
		Hexagon hexagon1 = new Hexagon("Hexagon1", "Blue", 4, 6);
		shapesList.add(hexagon1);
		Hexagon hexagon2 = new Hexagon("Hexagon2", "Red", 3, 5);
		shapesList.add(hexagon2);
		Square square1 = new Square("Square", "Pink", 4);
		shapesList.add(square1);
		Square square2 = new Square("Square", "Pink", 4);
		shapesList.add(square2);
		Triangle triangle1 = new Triangle("Triangle1", "Black", 3, 5);
		shapesList.add(triangle1);
		Triangle triangle2 = new Triangle("Triangle2", "Yellow", 4, 2);
		shapesList.add(triangle2);
		
		twoDShapes.add(circle1);
		twoDShapes.add(circle2);
		twoDShapes.add(hexagon1);
		twoDShapes.add(hexagon2);
		twoDShapes.add(square1);
		twoDShapes.add(square2);
		twoDShapes.add(triangle1);
		twoDShapes.add(triangle2);
		
		
		//3D Objects
		Cube cube1 = new Cube("Cube1", "Red", 3);
		shapesList.add(cube1);
		Cube cube2 = new Cube("Cube2", "Blue", 4);
		shapesList.add(cube2);
		Cylinder Cylinder1 = new Cylinder("Cylinder1", "Blue", 3, 4);
		shapesList.add(Cylinder1);
		Cylinder Cylinder2 = new Cylinder("Cylinder2", "Red", 3, 4);
		shapesList.add(Cylinder2);
		Sphere sphere1 = new Sphere("Sphere1", "Orange", 4);
		shapesList.add(sphere1);
		Sphere sphere2 = new Sphere("Sphere2", "Green", 2);
		shapesList.add(sphere2);
		TetraHedron tetrahedron1 = new TetraHedron("Tetrahedron1", "Magenta", 4, 5, 6);
		shapesList.add(tetrahedron1);
		TetraHedron tetrahedron2 = new TetraHedron("Tetrahedron2", "Pink", 3, 4, 5);
		shapesList.add(tetrahedron2);
		
		threeDShapes.add(cube1);
		threeDShapes.add(cube2);
		threeDShapes.add(Cylinder1);
		threeDShapes.add(Cylinder2);
		threeDShapes.add(sphere1);
		threeDShapes.add(sphere2);
		threeDShapes.add(tetrahedron1);
		threeDShapes.add(tetrahedron2);
		
		System.out.println("SHAPES LIST: BOTH 2D AND 3D OBJECTS");
		System.out.println("-----------------------------------");
		System.out.println();
		for (int i = 0; i < shapesList.size(); ++i) {
			//Call toString on all shapes.
			System.out.println(shapesList.get(i).toString());
		}
		System.out.println("2D SHAPES LIST: ALL 2D OBJECTS");
		System.out.println("------------------------------");
		System.out.println();
		for (int i = 0; i < twoDShapes.size(); ++i) { //WORKS
			//Calls toString for every 2DShape object. 
			//Instantiating a 2D object automatically calls area(), and the area is outputted in toString().
			System.out.println(twoDShapes.get(i).toString());
		} 
		System.out.println("3D SHAPES LIST: ALL 3D OBJECTS");
		System.out.println("------------------------------");
		System.out.println();
		for (int i = 0; i < threeDShapes.size(); ++i) {
			//Call toString and volume on all 3D shapes.
			//Instantiating a 3D object automatically calls volume() and surfaceArea(), and they're both outputted in toString().
			System.out.println(threeDShapes.get(i).toString());
		}
		
		//After calling toString on all of the objects, call compareTo for each type of shape.
		System.out.println("COMPARING SHAPES OF SHAPESLIST");
		System.out.println("------------------------------");
		System.out.println();
		for (int i = 0; i < shapesList.size(); i += 2) {
			if (shapesList.get(i).compareTo(shapesList.get(i + 1)) == 0) {
				System.out.println("Both objects are the same base shape.");
				System.out.println();
			}
			else {
				System.out.println("Both objects are not the same base shape.");
				System.out.println();
			}
		}
		System.out.println();
		
		//TwoDimensionalShapes comparisons
		System.out.println("COMPARING 2DSHAPES OF TWODSHAPES");
		System.out.println("--------------------------------");
		System.out.println();
		for (int i = 0; i < twoDShapes.size(); i += 2) {
		  	if (twoDShapes.get(i).compareTo(twoDShapes.get(i + 1)) == 0) {
		  		System.out.println(twoDShapes.get(i).getName() + " is equal to " + twoDShapes.get(i+1).getName());
		  	}
		  	else if (twoDShapes.get(i).compareTo(twoDShapes.get(i + 1)) == 1) {
		  		System.out.println(twoDShapes.get(i).getName() + " is greater than " + twoDShapes.get(i+1).getName());
		  	}
		  	else {
		  		System.out.println(twoDShapes.get(i).getName() + " is less than " + twoDShapes.get(i+1).getName());
		  	}
		  	System.out.println();
		}
		System.out.println("COMPARING 3DSHAPES OF THREEDSHAPES");
		System.out.println("----------------------------------");
		System.out.println();
		//ThreeDimensionalShapes comparisons
		for (int i = 0; i < threeDShapes.size(); i += 2) {
		  	if (threeDShapes.get(i).compareTo(threeDShapes.get(i + 1)) == 0) {
		  		System.out.println(threeDShapes.get(i).getName() + " is equal to " + threeDShapes.get(i+1).getName());
		  	}
		  	else if (threeDShapes.get(i).compareTo(threeDShapes.get(i + 1)) == 1) {
		  		System.out.println(threeDShapes.get(i).getName() + " is greater than " + threeDShapes.get(i+1).getName());
		  	}
		  	else {
		  		System.out.println(threeDShapes.get(i).getName() + " is less than " + threeDShapes.get(i+1).getName());
		  	}
		  	System.out.println();
		}
	}
}