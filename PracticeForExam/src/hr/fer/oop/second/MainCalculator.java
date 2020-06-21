package hr.fer.oop.second;

public class MainCalculator {
	
	public static void main(String[] args) {
		ReversedNumeralSystemCalculator rnsc = new ReversedNumeralSystemCalculator();

//		char[] binaryDigits = {'0','1'};
//		System.out.println(rnsc.codeIntoNewReversedSystem(2, binaryDigits)); //NumeralSystemException

		System.out.println(rnsc.inputDec('8')); //prints 8
		System.out.println(rnsc.inputDec('3')); //prints 83
		System.out.println(rnsc.inputDec('a')); //prints 83
		System.out.println(rnsc.inputDec('-')); //prints 83
		System.out.println(rnsc.inputDec('3')); //prints 833
		System.out.println(rnsc.inputDec('2')); //prints 8332
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//		System.out.println(rnsc.codeIntoNewReversedSystem(16, hexDigits)); //prints C802
		char[] customDigits = {'1','a','2','b'};
//		System.out.println(rnsc.codeIntoNewReversedSystem(16, customDigits)); // NumeralSystemException
//		System.out.println(rnsc.codeIntoNewReversedSystem(3, customDigits)); // NumeralSystemException
		System.out.println(rnsc.codeIntoNewReversedSystem(4, customDigits)); //prints 1b12112

		System.out.println(rnsc.inputCoded('C', hexDigits)); //prints C
		System.out.println(rnsc.inputCoded('8', hexDigits)); //prints C8
		System.out.println(rnsc.inputCoded('0', hexDigits)); //prints C80
		System.out.println(rnsc.inputCoded('M', hexDigits)); //prints C80
		System.out.println(rnsc.inputCoded('2', hexDigits)); //prints C802
		System.out.println(rnsc.decodeFromNewReversedSystem(16, hexDigits)); //prints 8332
//		System.out.println(rnsc.decodeFromNewReversedSystem(6, hexDigits, "C802")); // NumeralSystemException
	}

}
