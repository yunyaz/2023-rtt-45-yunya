package classExamples.shape;

public class Circle extends Shape {
	
	double PI = Math.PI;
	double radius;
	

	public void setRadius(double radius) {
		this.radius = radius;
	}


	@Override
	public double calculateArea() {
		double area = PI * radius * radius;
		return area;
	}
	
//	public String toString() {
//		return "The area of " + getShapeName() + " (radius = " + radius + ") is " + calculateArea();
//	}

}
