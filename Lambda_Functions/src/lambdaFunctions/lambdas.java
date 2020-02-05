package lambdaFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

/**
 * @author John Butler
 *
 */
// interface that we implement using lambda functions
interface functionsInterface {
	String[] sort(String[] arr); // abstract method
}

// sort method used by sortByStringLengthLambda lambda function
class SortByStringLength implements Comparator<String> {
	// used for sorting strings by string length
	public int compare(String a, String b) {
		return a.length() - b.length();
	}
}

//sort method used by sortByStringLengthDescendingLambda lambda function
class SortByStringLengthDescending implements Comparator<String> {
	// used for sorting strings by string length
	public int compare(String a, String b) {
		return b.length() - a.length();
	}
}

//sort method used by sortByFirstCharLambda lambda function
class SortByFirstChar implements Comparator<String> {
// used for sorting strings by the first char
	public int compare(String a, String b) {
		return a.charAt(0) - a.charAt(0);
	}
}

//sort method used by sortByE lambda function
class SortByE implements Comparator<String> {
	// used for sorting strings if they start with e
	public int compare(String a, String b) {
		if(a.charAt(0) == 'e' && b.charAt(0) == 'e') return 0;
		if (a.charAt(0) == 'e') return -1;
		return 1;
	}
}

public class lambdas {
	static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	static String[] sortByEFunction(String[] arr) {
		Arrays.sort(arr, new SortByE());
		return arr;
	}
	static String[] evenOdd(int[] arr) {
		String[] result = new String[arr.length];
		OfInt indices = IntStream.range(0, arr.length).iterator();
		Arrays.stream(arr).forEach((int num) -> {
			int index = indices.nextInt();
			if(num % 2 == 0) result[index] = "e" + String.valueOf(num);
			else result[index] = "o" + String.valueOf(num);
		});
		return result;
	}
	static String[] get3LetterStartsWithA(String[] arr) {
		ArrayList<String> result = new ArrayList<String>();
		Arrays.stream(arr).forEach((String str) -> {
			if(str.length() == 3 && str.charAt(0) == 'a') result.add(str);
		});
		return result.toArray(new String[result.size()]);
	}

	public static void main(String[] args) {
		String[] arr = { "aaa", "bb", "c", "ed", "eee", "abb" };
		printArray(arr);

		// lambda function to sort array by string length
		functionsInterface sortByStringLengthLambda = (String[] array) -> {
			Arrays.sort(array, new SortByStringLength());
			return array;
		};
		printArray(sortByStringLengthLambda.sort(arr));

		// lambda function to sort array by string lengths in descending
		functionsInterface sortByStringLengthDescendingLambda = (String[] array) -> {
			Arrays.sort(array, new SortByStringLengthDescending());
			return array;
		};
		printArray(sortByStringLengthDescendingLambda.sort(arr));

		// lambda function to sort array by the first character in each string
		functionsInterface sortByFirstCharLambda = (String[] array) -> {
			Arrays.sort(array, new SortByFirstChar());
			return array;
		};
		printArray(sortByFirstCharLambda.sort(arr));

		// lambda function to sort array by the first character in each string
		functionsInterface sortByELambda = (String[] array) -> {
			Arrays.sort(array, new SortByE());
			return array;
		};
		printArray(sortByELambda.sort(arr));

		// lambda function to sort array by the first character in each string
		functionsInterface sortByEFunctionLambda = (String[] array) -> {
			return sortByEFunction(array);
		};
		printArray(sortByEFunctionLambda.sort(arr));

		int[] ints = {1, 2, 3, 4, 5};
		printArray(evenOdd(ints));
		
		printArray(get3LetterStartsWithA(arr));
	}

}
