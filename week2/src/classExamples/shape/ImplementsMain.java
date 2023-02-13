package classExamples.shape;

import java.util.ArrayList;
import java.util.List;

public class ImplementsMain {

	public static void main(String[] args) {
		Square s = new Square();
		s.setShapeName("Square");
		s.setHeight(10);
		s.setLength(5);

		Square s1 = new Square();
		s1.setShapeName("Square 1");
		s1.setHeight(7);
		s1.setLength(7);
		
		Triangle t = new Triangle();
		t.setShapeName("Triangle");
		t.setBase(5);
		t.setHeight(10);
		
		Triangle t1 = new Triangle();
		t1.setShapeName("Triangle 1");
		t1.setBase(7);
		t1.setHeight(4);
		
		Circle c = new Circle();
		c.setShapeName("Circle");
		c.setRadius(5);

		List<Shape> shapes = new ArrayList<>();
		shapes.add(s1);
		shapes.add(t1);
		shapes.add(s);
		shapes.add(t);
		shapes.add(c);

		for (Shape shape : shapes) {
//			String name = shape.getShapeName(); // this is inherited from Shape class
//			double area = shape.calculateArea(); // this implementation is manditory due to the AreaCalculation
			
			System.out.println(shape);

		}
	}

}
