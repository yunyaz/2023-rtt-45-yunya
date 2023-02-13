package lab.interfaces;

public class MyRunner {

	public static void main(String[] args) {

		Circle c1 = new Circle(1, 2, 2);
		System.out.println("Area of Circle " + c1.getArea());
		System.out.println("Coordinates are " + c1.getCoordinate());
		
		c1.moveDown();
		System.out.println("After move Down, Coordinates are " + c1.getCoordinate());
		
		c1.moveRight();
		System.out.println("After move right, Coordinates are " + c1.getCoordinate());
		
		c1.moveUp();
		System.out.println("After move Up, Coordinates are " + c1.getCoordinate());
		
		c1.moveLeft();
		System.out.println("After move left, Coordinates are " + c1.getCoordinate());
		
		System.out.println("--------Test Polymorphism-------");
		
		Movable c2 = new Circle(5, 10, 200); // upcasting
		
		c2.moveUp();
		System.out.println("After move up , Coordinates are " + c2.getCoordinate());
		
		c2.moveLeft();
		System.out.println("After move Left , Coordinates are " + c2.getCoordinate());
	}

}
