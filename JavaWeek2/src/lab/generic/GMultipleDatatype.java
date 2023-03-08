package lab.generic;

public class GMultipleDatatype<DatatypeOne, DatatypeTwo> {
	DatatypeOne valueOne;
	DatatypeTwo valueTwo;

	public GMultipleDatatype(DatatypeOne v1, DatatypeTwo v2) {
		this.valueOne = v1;
		this.valueTwo = v2;
	}

	public DatatypeOne getValueOne() {
		return valueOne;
	}

	public void setValueOne(DatatypeOne valueOne) {
		this.valueOne = valueOne;
	}

	public DatatypeTwo getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(DatatypeTwo valueTwo) {
		this.valueTwo = valueTwo;
	}
}
