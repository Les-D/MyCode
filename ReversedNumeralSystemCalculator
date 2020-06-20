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

public abstract class AbstractNumeralSystemCalculator {
	
    String inputDecNumber;
    String inputCodedNumber;

    /**
     * Clears variables inputDecNumber and inputCodedNumber
     */
    abstract public void clear();

    /**
     * Receive characters, and only if character is digit 0-9 adds it
     * to current saved digits. Invalid characters are just ignored
     * @param c entered character
     * @return curent number made of valid digits entered so far
     */
    abstract public String inputDec(char c);

    /**
     * Receive characters, and only if character is valid digit from digits array
     * adds it to current saved digits. Invalid characters are just ignored
     * @param c entered character
     * @param digits valid digits in coded number
     * @return current number made of valid digits entered so far
     */
    abstract public String inputCoded(char c, char[] digits);

    /**
     * Transfer/code valid decimal number(base 10) inputDecNumber into 
     * new number with base system with base base 
     * @param base base of wanted base system
     * @param digits digits of wanted base system. You can assume that 
     * digits are unique (no duplicates)
     * @return new number that represents record of the number 
     * inputDecNumber in base system base written in reversed order 
     * (most significant digit is on most right place)
     * @throws NumeralSystemException exception will be thrown if base
     * and number given of digits do not match 
     */
    abstract public String codeIntoNewReversedSystem(int base, char[] digits) throws NumeralSystemException;

    /**
     * Transfer/decode coded number inputCodedNumber written in reversed order 
     * (most significant digit is on most right place) into original decimal form
     * @param base base of wanted base system
     * @param digits digits of wanted base system. You can assume that 
     * digits are unique (no duplicates)
     * @return decimal form of number inputCodedNumber
     * @throws NumeralSystemException exception will be thrown if base
     * and number given of digits do not match, or if inputCodedNumber is empty 
     * or have digits not supported in array of valid digits digits 
     */
    abstract public String decodeFromNewReversedSystem(int base, char[] digits) throws NumeralSystemException;
}

@SuppressWarnings("serial")
public class NumeralSystemException extends RuntimeException {
	
	public NumeralSystemException() {
        super();
    }

    public NumeralSystemException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NumeralSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumeralSystemException(String message) {
        super(message);
    }

    public NumeralSystemException(Throwable cause) {
        super(cause);
    }

}

public final class ReversedNumeralSystemCalculator extends AbstractNumeralSystemCalculator {
	
	
	public ReversedNumeralSystemCalculator() {
		inputDecNumber = "";
		inputCodedNumber = "";
	}

	@Override
	public void clear() {
		inputDecNumber = "";
		inputCodedNumber = "";
	}

	@Override
	public String inputDec(char c) {
		try {
			int num = Integer.parseInt(String.valueOf(c));
			if(num >= 0 && num <= 9)
				inputDecNumber = inputDecNumber + num;
		} catch (Exception e){
		}
		
		return inputDecNumber;
	}

	@Override
	public String inputCoded(char c, char[] digits) {
		try {
			for(char ch : digits) {
				if(c == ch)
					inputCodedNumber = inputCodedNumber + c;
			}
		} catch (Exception e) {	
		}
		
		return inputCodedNumber;
	}

	@Override
	public String codeIntoNewReversedSystem(int base, char[] digits) {
		String novi = "";
		if(inputDecNumber == "" || base != digits.length)
			throw new NumeralSystemException();
		
		int num = Integer.parseInt(inputDecNumber);
		do {
			int i = num % base;
			novi = novi + digits[i];
			num = num / base;
		} while (num != 0);
		
		return novi;
	}

	@Override
	public String decodeFromNewReversedSystem(int base, char[] digits) {
		String novi = "";
		int num = 0;
		if(base != digits.length || inputCodedNumber == "")
			throw new NumeralSystemException();
		
		int k;
		for(int j = 0; j < inputCodedNumber.length(); j++) {
			k = 0;
			for(int i = 0; i < base; i++) {
				if(inputCodedNumber.charAt(j) == digits[i]) {
					num += (i * Math.pow(base, j));
					k++;					
				}
			}			
			if(k == 0)
				throw new NumeralSystemException();
		}
		return novi + num;
	}
}
