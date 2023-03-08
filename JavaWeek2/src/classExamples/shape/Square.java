package classExamples.shape;

public class Square extends Shape {

	private int length;
	private int height;
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// this is the implementation of the AreaCalculation interface
	@Override
	public double calculateArea() {
		int area = length * height;
		return area;
	}
	
	public String toString() {
		return "The area of " + getShapeName() + " (length = " + length + ", height = " + height + ") is " + calculateArea();
	}

}
