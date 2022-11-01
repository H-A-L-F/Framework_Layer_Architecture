package lib;

public class ValidInRange implements ValidatorString, ValidatorInt {
	private int min, max;
	
	public ValidInRange(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean isValid(int in) {
		if(in < this.min || in > this.max) return false;
		return true;
	}

	@Override
	public boolean isValid(String in) {
		int len = in.length();
		return isValid(len);
	}
	
}
