package hackerrank.SBA;

public class Second {

	interface Sport {
		void calculateAvgAge(int[] age);

		void retirePlayer(int id);
	}
	/*
	 * 
	 * This is here only for visibility. Please do not take the code below out of
	 * the comments.
	 * 
	 * import java.util.*;
	 * 
	 * interface Sport{ void calculateAvgAge(int[] age); void retirePlayer(int id);
	 * }
	 * 
	 * This is here only for visibility. Please do not take the code above out of
	 * the comments.
	 */

	// ================ PLEASE WRITE CODE HERE =============

	/*
	 * Write your implementation of the Cricket and Football classes below.
	 */

	class Cricket implements Sport {

		int[] playerIDs;
		final int NUM_OF_PLAYERS = 11;

		Cricket() {
			playerIDs = new int[NUM_OF_PLAYERS + 1];
			for (int i = 0; i < playerIDs.length; i++) {
				playerIDs[i] = 1;
			}
			System.out.println("A new cricket team has been formed");
		}

		public void calculateAvgAge(int[] age) {
			double sum = 0;
			for (int i = 0; i < age.length; i++) {
				sum = sum + age[i];
			}
			double avg = sum / age.length;
			System.out.format("The average age of the team is %.2f\n", avg);
		}

		public void retirePlayer(int id) {
			if (playerIDs[id] == -1) {
				System.out.println("Player has already retired");
			} else {
				playerIDs[id] = -1;
				System.out.println("Player with id: " + id + " has retired");
			}
		}
	}

	class Football implements Sport {

		int[] playerIDs;
		final int NUM_OF_PLAYERS = 11;

		Football() {
			playerIDs = new int[NUM_OF_PLAYERS + 1];
			for (int i = 0; i < playerIDs.length; i++) {
				playerIDs[i] = 1;
			}
			System.out.println("A new football team has been formed");
		}

		public void calculateAvgAge(int[] age) {
			double sum = 0;
			for (int i = 0; i < age.length; i++) {
				sum = sum + age[i];
			}
			double avg = sum / age.length;
			System.out.format("The average age of the team is %.2f\n", avg);
		}

		public void retirePlayer(int id) {
			if (playerIDs[id] == -1) {
				System.out.println("Player has already retired");
			} else {
				playerIDs[id] = -1;
				System.out.println("Player with id: " + id + " has retired");
			}
		}

		void playerTransfer(int fee, int id) {
			if (playerIDs[id] == -1) {
				System.out.println("Player has already retired");
			} else {
				System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);
			}
		}
	}
}
