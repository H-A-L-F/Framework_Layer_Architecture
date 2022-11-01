package lib;

import java.util.List;

public class ValidInCollection implements ValidatorString {
	private List<String> list;
	
	public ValidInCollection(List<String> list) {
		this.list = list;
	}
	
	@Override
	public boolean isValid(String in) {
		for (String string : list) {
			if(string.equals(in)) return true;
		}
		return false;
	}
	
}
