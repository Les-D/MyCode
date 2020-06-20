package hr.fer.oop.edgar.labos4.ponovo;

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
