package lib;

public class ValidEmail implements ValidatorString{

	@Override
	public boolean isValid(String in) {
		return !in.startsWith("@") && in.contains("@") && in.endsWith(".com") && !in.endsWith("@.com");
	}

}
