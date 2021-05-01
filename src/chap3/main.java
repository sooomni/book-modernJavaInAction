package chap3;

import java.util.Comparator;
import java.util.List;

import chap2.example.Apple;

public class main {
	public static void main(String [] args) {
		Comparator<Apple> byWeight = 
			(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
	
		int r = (String s) -> s.length();
		(Apple a) -> a.getWeight() > 150;
		
		int result = (int x, int y) -> {
			System.out.println("Result");
			System.out.println(x+y);
		};
		int x = () -> 42;
		(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		
		(List<String> list)-> list.isEmpty();
	}
}
