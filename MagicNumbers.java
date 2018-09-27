import java.util.Arrays;

public class MagicNumbers {
	

	public static void range(String[] wizard) {

		int first = stringToInteger(wizard[0]);
		int last = stringToInteger(wizard[1]);

		int count = 0;

		int[] magicNumbers = new int[arraySize(wizard)];

		while(first < last) {

			int length = integerToString(first).length();

			if(repeatedDigits(integerToString(first))) {

				if(isMagicNumber(integerToString(first),length)){

					magicNumbers[count] = first;
				}
				else{
					magicNumbers[count] = -1;
				}
			}
			else {
				magicNumbers[count] = -1;
			}
			count++;
			first++;
		}

		System.out.println(Arrays.toString(magicNumbers));
	}

//Method checks to see if any values repeat within the Integer
	public static boolean repeatedDigits(String wizard) {
		int i = 0; 
		int x = wizard.length() - 1; 

		while(x > i) {
			if(wizard.charAt(x) == wizard.charAt(i)) {
	
				return false;
			}

			x--;
			i++;

		}

		return true;



	}


//Method checks to see if the each value iterates through all numbers and ends on the first
	public static boolean isMagicNumber(String wizard, int length) {

		int nextInt = 0;
		int currentInt = 0;
		int first = 0;
		int finalValue = 0;
		int last = length;
		int numLength = length;
		int initialValue = charToInteger(wizard.charAt(0));

		while(first <= last - 1 ) {

			currentInt = charToInteger(wizard.charAt(first));

			nextInt = charToInteger(wizard.charAt(nextPos(currentInt,numLength,first)));

			//Makes sure that the next number is equal to the number at that position
			if(first != last - 1 && nextInt != charToInteger(wizard.charAt(first + 1)) ){
				break;
			}

			if(first == last - 1) {

				if(initialValue == nextInt) {
					return true;
				}

			}

			first++;
		}

		return false;

	}

	//Adds the position with the position value modulo total length of integer to get the next position
	public static int nextPos(int positionValue, int length, int position) {

		return ((positionValue + position) % length);
	}


	public static String integerToString(int num) {
		return String.valueOf(num);

	}

	public static int stringToInteger(String str ) {
		return Integer.parseInt(str);
	}

	public static int charToInteger(char str ) {
		return Character.getNumericValue(str);
	}

     public static String charToString(char str ) {
		return Character.toString(str);
	}


	public static int arraySize(String[] wizard) {

		int first = stringToInteger(wizard[0]);
		int last = stringToInteger(wizard[1]);

		int count = 0;

		while(first < last ) {

			count ++;
			first++;
		}

		return count;

	}



	public static void main(String[] args ) {

		String input = "10 100";

		String[] wizard = input.split(" ");

		range(wizard);

	}
}