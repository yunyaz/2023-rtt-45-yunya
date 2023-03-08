package lab.abstraction;

public class Circle extends Shape {
	protected double radius;
	private final double PI = Math.PI;

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, double height) {
		this.radius = radius;
		super.height = height;
	}

	public double getArea() {
		// double area = PI * this.radius * this.radius;
		double area = PI * Math.pow(this.radius, 2); 
		return area;
	}

	@Override
	public void displayshapName() {
		System.out.println("Drawing a Circle of radius " + this.radius);
	}

	/** Returns a self-descriptive string */
	@Override
	public String toString() {
		return "Circle[ radius = " + radius + super.toString() + "]";
	}
}
