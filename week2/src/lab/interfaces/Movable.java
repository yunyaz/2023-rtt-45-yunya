package lab.interfaces;

//An interface defines a list of public abstract methods to be implemented by the subclasses
public interface Movable {

	void moveUp(); // "public" and "abstract" by default

	void moveDown();

	void moveLeft();

	void moveRight();

	String getCoordinate();

}
