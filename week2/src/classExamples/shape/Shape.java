package classExamples.shape;

public abstract class Shape implements AreaCalculation {
	
	private String name;
	
	public void setShapeName(String name) {
		this.name = name;
	}
	
	public String getShapeName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "The area of " + getShapeName() + " is " + calculateArea();
	}
}
