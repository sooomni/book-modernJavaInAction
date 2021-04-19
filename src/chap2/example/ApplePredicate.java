package chap2.example;

/* Stretegy design pattern 
 * : 행위를 캡슐화하는 인터페이스 생성 후(ApplePredicate) 가능한 행위를 클래스로 생성하고(AppleGreenColorPredicate, AppleHeavyWeightPredicate)
 *   런타임에 알고리즘을 선택하여 (동적 수정) 행위를 선택하도록 하는 방법 
 * 동작 파라미터 화 
 * : 메소드(filterApples)가 다양한 동작(ApplePredicate)을 받아 내부적으로 다양한 동작을 수행할 수 있다. 
 * */
public interface ApplePredicate {
	boolean test(Apple apple);
}
