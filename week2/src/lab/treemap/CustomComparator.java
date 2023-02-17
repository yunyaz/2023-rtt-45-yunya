package lab.treemap;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		int value = str1.compareTo(str2);

		// elements are sorted in reverse order
		if (value > 0) {
			return -1;
		} else if (value < 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
