package chap2.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class main {
	//2.1.2 색을 파라미터 화
	//DRY원칙에 위배(if문 안의 조건을 제외하고 필터링 조건 적용 부분이 동일하다)
	public static List<Apple> filterAppleByColor(List<Apple>inventory,String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple :inventory) {
			if(apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterAppleByWeight(List<Apple>inventory,int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple :inventory) {
			if(apple.getWeight() >= weight) {
				result.add(apple);
			}
		}
		return result;
	}
	
	//*메소드가 객체만 인수도 받는다 했을 때*에는 아래 메소드 처럼 test 메소드를 ApplePredicate 객체로 감싸서 전달해야 한다.
	//람다를 이용하면 여러 개의 ApplePredicate 클래스 정의하지 않고서도 표현식을 filterApples에 전달할 수 있다.
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple :inventory){
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, ApplePrintPredicate p) {
		for(Apple apple : inventory) {
			System.out.println(p.print(apple));
		}
	}
	
	//2.3.4 리스트 형식으로 추상화 (형식 파라미터 T 사용)
	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> result = new ArrayList<>();
		
		for(T e :list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	public static void main(String [] args) {
		List<Apple> inventory = null;
		
		//색을 파라미터한 방식으로 무게 혹은 다른 조건이 추가되었을 때 필터링의 조건을 적용하는 부분의 코드가 중복되어 소프트웨어공학의 DRY 원칙에 위배 
		List <Apple> greenApples = filterAppleByColor(inventory, "GREEN");
		List <Apple> redApples = filterAppleByColor(inventory, "RED");
		
		//2.2.1 추상적 조건으로 필터링
		//전달한 Predicate에 의해 filterApples 메소드의 동작이 결정된다
		List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
		
		prettyPrintApple(inventory, new SimpleApplePrint());
		
		//2.3.2 익명 클래스 사용 
		//인터페이스 사용 시의 과도한 선언을 줄여줄 수는 있으나 메소드를 중복해서 구현해야한다는 점은 여전하
	   redApples = filterApples(inventory, new ApplePredicate() {
			public boolean test(Apple apple) {
				return apple.getColor().equals("RED") ? true : false;
			}
		});
		
	   //2.3.3 람다 표현 사용
	   List <Apple>result = filterApples(inventory, (Apple apple) -> apple.getColor().equals("RED"));
	   
	   redApples = filter(inventory, (Apple apple) -> apple.getColor().equals("RED"));
	   
	   List<Integer>numbers = new ArrayList();
	   List <Integer> evenNumbers = filter(numbers, (Integer i) -> i%2 == 0);
	   
	}
	
}
