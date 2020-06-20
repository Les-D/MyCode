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
