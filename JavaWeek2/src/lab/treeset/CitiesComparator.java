package lab.treeset;

import java.util.Comparator;

public class CitiesComparator implements Comparator<String> {

	@Override
	public int compare(String cityOne, String cityTwo) {

		int value = cityOne.compareTo(cityTwo);

		// sort elements in reverse order
		if (value > 0) {
			return -1;
		} else if (value < 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
