package lib;

public class ValidInOption implements Validator {
	private String[] opts;
	private int[] ints;
	
	
	public ValidInOption(String[] opts) {
		this.opts = opts;
		this.ints = new int[1];
	}
	
	public ValidInOption(int[] ints) {
		this.opts = new String[1];
		this.ints = ints;
	}

	@Override
	public boolean isValidInt(int in) {
		for (int i : ints) {
			if(i == in) return true;
		}
		return false;
	}

	@Override
	public boolean isValidString(String in) {
		for (String string : opts) {
			if(string.equals(in)) return true;
		}
		return false;
	}

}
