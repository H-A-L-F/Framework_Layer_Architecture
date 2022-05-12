package validators;

public class ValidInRange implements Validator{
	int min, max;
	
	public ValidInRange(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean isValidInt(int in) {
		if(in < this.min || in > this.max) return false;
		return true;
	}

	@Override
	public boolean isValidString(String in) {
		int len = in.length();
		return isValidInt(len);
	}
	
}
