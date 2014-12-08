public class ArrayStaticMethods {

	/*
	 * This method will return a double that is the average of all values in
	 * data. This may be defined as the mean of the elements in the array data.
	 */

	public static double mean(double[] data) {
		double total = 0;
		for (double element : data) {
			total += element;
		}
		return (total / data.length);

	}

	/*
	 * Given a sentence as an array of characters, this method will compute the
	 * number of words in the sentence. All sentences must only include letters,
	 * spaces,commas and end with a period.
	 */

	public static int countWords(char[] cArray) {
		int total = 0;
		for (char element : cArray) {
			if ((element == ' ') || (element == '.')) {
				total += 1;
			}
		}
		return total;
	}

	/*
	 * This method will take an integer array and two integer values as
	 * parameters. It will then produce an array with exactly the same contents
	 * as the parameter but with all occurrences of value 1 replaced with value 2.
	 */

	public static int[] replace(int[] values, int value1, int value2) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == value1) {
				values[i] = value2;
			}
		}
		return values;

	}

	/*
	 * This method will take an array of integers as a parameter and return a
	 * new array that contains the same numbers as the given array. These
	 * numbers will be organized with the evens in the front and the odds at the
	 * end of the array. The grouping of numbers from the original array will
	 * follow suit with the returned array.
	 */

	public static int[] evenFront(int[] aArray) {
		int[] newArray = new int[aArray.length];
		int count = 0;

		for (int ele1 : aArray) {
			if (ele1 % 2 == 0) {
				newArray[count] = ele1;
				count++;
			}
		}
		for (int ele2 : aArray) {
			if (ele2 % 2 != 0) {
				newArray[count] = ele2;
				count++;
			}
		}

		return newArray;
	}

	/*
	 * This method will take an array of characters as a parameter and return
	 * true if any character is surrounded by another character. It will return
	 * false if there are no letters being surrounded. For example in "abcdc", d
	 * is surrounded by c on both sides returning true.
	 */

	public static boolean surroundedCharacter(char[] aArray) {
		for (int i = 1; i < aArray.length; i++) {
			if ((aArray[i + 1]) == (aArray[i - 1])) {
				if ((aArray[i + 1] != aArray[i])
						&& (aArray[i - 1]) != aArray[i]) {
					return true;
				}
			}
			i++;
		}
		return false;
	}
}
