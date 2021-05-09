# Modern Java in Action
###### 한빛미디어의 Modern Java in Action을 학습하고 요약한 내용입니다.

### Index
[1. 자바 8,9,10,11 : 무슨 일이 일어나고 있는가 ?](#chap-1-자바-891011-무슨-일이-일어나고-있는가-)<br>
[2. 동적 파라미터화 코드 전달하기](#chap-2-동적-파라미터화-코드-전달하기)</br>
[3. 람다 표현식](#chap-3-람다-표현식)</br>
[4. 스트림 소개](#chap-4-스트림-소개)</br>


## chap 1. 자바 8,9,10,11 : 무슨 일이 일어나고 있는가 ?
1. Java 8은 <b>간결한 코드, 멀티코어 프로세서의 쉬운 활용</b> 두 가지 요구사항을 기반으로 하여 아래 새로운 기술을 제공한다.
  * Stream API
  * 메소드에 코드를 전달하는 기법 - 메소드 참조와 람다
  * 인터페이스의 디폴트 메소드

2. 스트림 처리 
  * 컬렉션을 처리하면서 발생하는 모호함과 반복적인 코드 문제, 멀티코어 활용 어려움 문제 해결
    * 내부 반복 : 루프를 신경 쓸 필요없이 라이브러리 내부에서 모든 데이터가 처리된다.
    * 병렬 연산 지원 API : DB 질의 언어에서 표현식을 처리하는 것처럼 고수준 언어로 원하는 동작을 표현하면, 구현(stream api)에서 최적의 저수준 실행방법을 선택하는 방식으로 동작한다. 스레드를 사용하지 않으면서 병렬성을 얻을 수 있는 방법을 제공한다.
  
3. 동작 파라미터화(behavior parameterization)
  * <b>메소드를 다른 메소드의 인수로 넘기는 기능</b>을 제공 
  * 말하자면, 스트림 api의 기반에 연산의 동작을 파라미터화 할 수 있는 코드를 전달한다는 사상이 있다.
  
4. 병렬성과 공유 가변 데이터
  * 스트림 메소드로 전달하는 코드는 다른 코드와 동시에 실행하더라도 안전하게 실행될 수 있어야 한다 = 공유 가변 데이터에 접근하지 않아야 한다.

5. 메소드와 람다, 함수형 프로그래밍
  * second class 그 자체로 값이 될 수 있도록 하는 기능 즉, <b>메소드를 값으로 취급할 수 있게 되는 기능</b>이 추가됐다.
    * first class : 전달하여 값을 바꿀 수 있는 값
    * second class : 전달할 수 없는 구조체 (메소드, 클래스)
  * File [] hiddenFiles = new File(".").listFiles(File::isHidden);
  * 함수형 프로그래밍
      * 람다 문법 형식으로 구현된 프로그램.
      * 함수를 일급값으로 사용한다. 
      * 한번 쓸 메소드를 람다함수로 구현해 메소드를 값으로 전달하는 기능을 이용할 수 있다.
  * 수학에서는 인수로 값을 받아 true/false로 값을 반환하는 함수를 Predicate 라고 한다.
 
6. 디폴트 메소드와 자바 모듈 
  * 디폴트 메소드 
    * Java 8 에서 제공하는 디폴트 메소드는 구현하지 않아도 되는 메소드를 인터페이스에 추가하여(메소드 본문은 인터페이스의 일부로 포함) 기존 코드를 건드리지 않고도 인터페이스 설계 확장을 가능하게 하는 기능이다. 
  * 자바 모듈
    * Java 9의 모듈 시스템 이용해 패키지 모음을 포함하는 모듈을 정의할 수 있게 되면서 JAR 같은 컴포넌트에 구조를 적용할 수 있게 됐다.

## chap 2. 동적 파라미터화 코드 전달하기
1. 동적 파라미터화
  * 아직 어떻게 실행할 것인지 결정하지 않은 코드 블록. 코드 블록의 실행을 미루고 나중에 실행될 메소드의 인수로 전달하면, 이후 프로그램에서 호출. 
2. 한 메소드가 다른 동작을 수행하도록 해 변화하는 요구사항에 유연하게 대응할 수 있다. <br>
  cf) 인터페이스, Predicate 객체 구현 (과도한 선언) <br>
      -> 익명클래스 (선언과 인스턴스화를 동시에 하여 선언 과정을 줄이나 명시적으로 동작을 정의하는 메소드를 계속 구현) <br> 
      -> 람다 표현식 (코드 간결)
  
## chap 3. 람다 표현식
1. 람다란 무엇인가
  * 특징
    * 익명 : 메소드 이름이 없음
    * 함수 : 메소드 처럼 특정 클래스에 종속되지 않음
    * 전달 : 인수로 전달하거나 변수로 저장 가능

2. 함수형 인터페이스
  * 인터페이스에 선언하여 단 하나의 추상 메소드만을 갖도록 제한하는 역할
  * 람다식으로 함수형 인터페이스의 추상 메소드 구현을 직접 전달 할 수 있으므로 <b>전체 표현식을 함수형 인터페이스의 인스턴스로 취급</b>할 수 있다.
  * 즉, 람다식에서는 함수형 인터페이스의 인스턴스를 생성하여 함수를 변수처럼 선언/반환할 수 있다.

3. 함수 디스크립터
  * 람다 표현식의 시그니처를 서술하는 메소드
  * 함수형 인터페이스의 추상 메서드 시그니처 = 람다 표현식의 시그니처
  * @FunctionalInterface 어노테이션 : 추상메소드가 1개인 함수형 인터페이스

4. 실행 어라운드 패턴
  * [초기화/준비 코드] -> [작업/자원 처리 코드] -> [정리/마무리 코드] 