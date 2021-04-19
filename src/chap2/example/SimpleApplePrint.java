package chap2.example;

public class SimpleApplePrint implements ApplePrintPredicate {

	@Override
	public String print(Apple apple) {
		return apple.getWeight() > 150 ? "Heavy "+apple.getColor()+" apple" : "light "+apple.getColor()+" apple";
	}

}
