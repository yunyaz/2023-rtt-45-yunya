package hackerrank.coreJava;

public class CoreJava {

	public static void main(String[] args) {
		CoreJava problem = new CoreJava();
		problem.getMinDeletions();

	}

	public static int addNumbers(double d, double e) {
		// Write your code here
		int sum = (int) (d + e);
		return sum;
	}

	public void getMinDeletions() {
		// Write your code here
		String s = "bbeadcebfp";
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			if (i != 0 && s.substring(0, i).contains(Character.toString(c))) {
				continue;
			}
			for (int j = i + 1; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
