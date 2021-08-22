# Modern Java in Action
###### 한빛미디어의 Modern Java in Action을 학습하고 요약한 내용입니다.

### Index
[1. 자바 8,9,10,11 : 무슨 일이 일어나고 있는가](#chap-1-자바-891011--무슨-일이-일어나고-있는가)<br>
[2. 동적 파라미터화 코드 전달하기](#chap-2-동적-파라미터화-코드-전달하기)</br>
[3. 람다 표현식](#chap-3-람다-표현식)</br>
[4. 스트림 소개](#chap-4-스트림-소개)</br>
[5. 스트림 활용](#chap-5-스트림-활용)</br>

## chap 1. 자바 8,9,10,11 : 무슨 일이 일어나고 있는가
### 1. ***간결한 코드, 멀티코어 프로세서의 쉬운 활용***을 기반으로 새로운 기술 제공
  * <b>Stream API</b>
  * <b>메소드에 코드를 전달하는 기법</b> - 메소드 참조와 람다
  * <b>인터페이스의 디폴트 메소드</b>

### 2. 스트림 처리 
  * 컬렉션을 처리하면서 발생하는 모호함과 반복적인 코드 문제, 멀티코어 활용 어려움 문제 해결
    * 내부 반복 : 루프를 신경 쓸 필요없이 라이브러리 내부에서 모든 데이터가 처리된다.
    * 병렬 연산 지원 API : DB 질의 언어에서 표현식을 처리하는 것처럼 고수준 언어로 원하는 동작을 표현하면, 구현(stream api)에서 최적의 저수준 실행방법을 선택하는 방식으로 동작한다. 스레드를 사용하지 않으면서 병렬성을 얻을 수 있는 방법을 제공한다.
  
### 3. 동작 파라미터화(behavior parameterization)
  * <b>메소드를 다른 메소드의 인수로 넘기는 기능</b>을 제공 
  * 말하자면, 스트림 api의 기반에 연산의 동작을 파라미터화 할 수 있는 코드를 전달한다는 사상이 있다.
  
### 4. 병렬성과 공유 가변 데이터
  * 스트림 메소드로 전달하는 코드는 다른 코드와 동시에 실행하더라도 안전하게 실행될 수 있어야 한다 = 공유 가변 데이터에 접근하지 않아야 한다.

### 5. 메소드와 람다, 함수형 프로그래밍
  * second class 그 자체로 값이 될 수 있도록 하는 기능 즉, <b>메소드를 값으로 취급할 수 있게 되는 기능</b>이 추가됐다.
    * first class : 전달하여 값을 바꿀 수 있는 값
    * second class : 전달할 수 없는 구조체 (메소드, 클래스)
  * ``` File [] hiddenFiles = new File(".").listFiles(File::isHidden);``` 
  * 함수형 프로그래밍
      * 람다 문법 형식으로 구현된 프로그램.
      * 함수를 일급값으로 사용한다. 
      * 한번 쓸 메소드를 람다함수로 구현해 메소드를 값으로 전달하는 기능을 이용할 수 있다.
  * 수학에서는 인수로 값을 받아 true/false로 값을 반환하는 함수를 Predicate 라고 한다.
 
### 6. 디폴트 메소드와 자바 모듈 
  * 디폴트 메소드 
    * Java 8 에서 제공하는 디폴트 메소드는 구현하지 않아도 되는 메소드를 인터페이스에 추가하여(메소드 본문은 인터페이스의 일부로 포함) 기존 코드를 건드리지 않고도 인터페이스 설계 확장을 가능하게 하는 기능이다. 
  * 자바 모듈
    * Java 9의 모듈 시스템 이용해 패키지 모음을 포함하는 모듈을 정의할 수 있게 되면서 JAR 같은 컴포넌트에 구조를 적용할 수 있게 됐다.

*****

## chap 2. 동적 파라미터화 코드 전달하기
### 1. 동적 파라미터화
  * 아직 어떻게 실행할 것인지 결정하지 않은 코드 블록. 코드 블록의 실행을 미루고 나중에 실행될 메소드의 인수로 전달하면, 이후 프로그램에서 호출. 

### 2. 한 메소드가 다른 동작을 수행하도록 해 변화하는 요구사항에 유연하게 대응할 수 있다. <br>
  cf) 인터페이스, Predicate 객체 구현 (과도한 선언) <br>
      -> 익명클래스 (선언과 인스턴스화를 동시에 하여 선언 과정을 줄이나 명시적으로 동작을 정의하는 메소드를 계속 구현) <br> 
      -> 람다 표현식 (코드 간결)
 
 *****

## chap 3. 람다 표현식
### 1. 람다란 무엇인가
  * 특징
    * 익명 : 메소드 이름이 없음
    * 함수 : 메소드 처럼 *특정 클래스에 종속되지 않음*
    * 전달 : 인수로 전달하거나 변수로 저장 가능
    * *람다 표현식은 변수에 할당하거나 함수형 인터페이스를 인수로 받는 메소드에만 전달할 수 있으며, 함수형 인터페이스의 추상 메소드와 같은 시그니처를 갖는다*
    
### 2. 함수형 인터페이스
  * 인터페이스에 선언하여 단 하나의 추상 메소드만을 갖도록 제한하는 역할
  * 람다식으로 함수형 인터페이스의 추상 메소드 구현을 직접 전달 할 수 있으므로 <b>함수형 인터페이스의 인스턴스로 취급</b>할 수 있다.
  * 즉, 람다식에서는 함수형 인터페이스의 인스턴스를 생성하여 함수를 변수처럼 선언/반환할 수 있다.

### 3. 함수 디스크립터
  * 람다 표현식의 시그니처를 서술하는 메소드
  * <b>함수형 인터페이스의 추상 메서드 시그니처 = 람다 표현식의 시그니처</b>
  * @FunctionalInterface 어노테이션 : 추상메소드가 1개인 함수형 인터페이스

### 4. 실행 어라운드 패턴
  * [초기화/준비 코드] -> [작업/자원 처리 코드] -> [정리/마무리 코드] 
  
### 5. 다양한 함수 인터페이스
|함수형 인터페이스|함수 디스트립터|메소드|
|:---|:---|:---|
|Predicate<T>|Generic T -> boolean| boolean test(T t) |
|Consumer<T>|Generic T -> void|void accept(T t)|
|Funcion <T, R>|Generic T -> Generic R|R apply (T t)|

#### 자바 형식
|primitive type|reference type|
|:---|:---|
|boolean, char, byte, short, int, long, float, double|Byte, Integer, Object, List|
|Generic 사용 불가|Generic 파라미터로 사용 가능|
|stack에 값 저장|heap에 값 저장, stack에 유사참조값|
|null 불가|null 가능|
|성능, 메모리 장점|엄청 큰 값 다루거나, Null을 다뤄야 하거나, 제네릭 타입에서 사용 되야 할 때|

- 기본형은 실제 값을 저장, 참조형은 실제 값x, 참조하는 유사 주소 값을 저장한다<br>
  -> 참조 변수 대입 시 값이 아닌 유사 주소값을 넣으면 해당 값의 변화가 일어났을 때 원래 값도 변경된다 : 얕은 복사
  -> 복사 값을 변경해도 원 값에 변경이 없으려면 주소값 참조가 아닌 새로운 메모리에 값을 복사해야한다 : 깊은 복사

- Generic : 클래스 내부에서 사용할 타입을 클래스 외부에서 지정하는 것
- boxing : 기본형 -> 참조형
  ```

    List<Integer> arr = new LinkedList<>();
    arr.add(10);            //<- boxing 지원 이전에는 arr.add(new Integer(10))

  ```
- unboxing : 참조형 -> 기본형
  ```

    int a = list.get(0)     // <- unboxing 지원 이전에는 (int)arr.get(0)

  ```

  * 오토박싱은 메모리 누수의 원인이 될 수 있다 <br>
  : 박싱 값은 기본형을 감싸는 래퍼며 힙에 저장된다 -> 메모리를 더 소비하며 기본형 가져올 때도 메모리 탐색 과정이 필요하다<br>
  -> java 8 에서 기본형을 입출력으로 사용하는 상황에서 오토박싱 피할 수 있도록 특별한 버전의 함수형 인터페이스 제공
   ```
    public interface IntPredicate{
      boolean test(int t);
    }

    IntPredicate evenNumbers = (int i) -> i%2 == 0;
    evenNumbers.test(1000)  //<-참(박싱 없음)

    Predicate <Integer> oddNumbers = (Integer i) -> i%2 != 0;
    oddNumbers.test(1000)  //<-거짓(박싱 : int -> Integer)
  ```
 
### 6. 예외, 람다, 함수형 인터페이스의 관계
  * 예외 된지는 람다표현식을 만드려면 (1) 확인된 예외를 선언하는 함수형 인터페이스를 직접 정의 혹은 (2) 람다를 try-catch 블록으로 감싸야한다.
  ```
  Function<BufferedReader,String> f = (bufferedReader b) -> {
   try{
      return b.readLine();
   }
   catch(IOException e){
      throw new RuntimeException(e);
   }
  };
  ```

### 7. 형식 검사
  * 대상 형식 : 어떤 콘텍스트(람다가 전달될 메소드 파라미터나 람다가 할당되는 변수 등) 에서 기대되는 람다 표현식의 형식
  * 대상 형식의 특징 때문에 같은 람다 표현식이더라도 호환되는 추상 메소드를 가진 다른 함수형 인터페이스로 사용될 수 있다.
  * <> : 다이아몬드 연산자로 콘텍스트에 따른 제네릭 형식 추론 가능
  * void 호환 규칙 : 람다 바디에 일반 표현식이 있으면 void 반환 하는 함수 디스크립터와 호환된다 (파라미터가 호환된다는 전제하에)  
  ```
  Predicate<String> p = s -> list.add(s);     //Predicate 반환 값 boolean
  Consumer<String> b = s -> list.add(s);      //Consumer 반환 값 void   -> list add 메소드는 void 대신 boolean을 반환하나 유효한 코드
  ```

### 8. 형식 추론
  * 자바 컴파일러는 대상 형식을 이용해 람다식과 관련된 함수형 인터페이스 추론(= 람다 시그니처, 파라미터 형식 추론) <br> -> 람다 문법에서 생략 가능

### 9. 지역변수 사용
  * 람다 캡처링 (자신의 바디에서 참조): 자유변수 활용 가능 (파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수) 
  * 단, 한번만 할당할 수 있는 지역변수만을 캡쳐 (final)
  ```
  int portNumber = 1337;
  Runnable r.  () -> System.out.println(portNumber);
  // portNumber = 11377;  -> 두 번 할당할 수 없으므로 컴파일 불가
  ```
  * 제약의 원인 : 인스턴스 변수는 힙에 저장, 지역변수는 스택 저장 -> 람다가 지역변수 바로 접근할 수 있는데 스레드에서 실행된다면, 변수 할당한 스레드가 사라져 변수 할당 해제 시에도 람다 실행 스레드에서 변수에 접근하려 할 수 있다.

### 10. 메소드 참조
  * 메소드 참조 : 기존 메소드 정의를 재활용해 람다처럼 전달 가능
  * ex) (Apple apple) -> apple.getWeight()  /   Apple::getWeight (Apple 클래스에 정의된 getWeight 메소드 참조)

### 11. 생성자 참조
  ```
    Function <Integer,Apple> c2 = Apple::new;    
      // 람다 표현 Function <Integer,Apple> c2 = (weight) -> new Apple(weight);
    Apple a2 = c2.apply(110);   //<- apply 메소드에 무게를 인수로 호출해 새로운 Apple 객체를 만들 수 있다

    BiFunction <Color, Integer,Apple> c4 = (weight) -> new Apple(weight);
  ```

### 12. 정리
  * *Apple을 weight 별로 비교해 inventory를 sort 하라*

  * 동적 파라미터화 : 객체 안에 동작을 포함 (*sort 동작이 파라미터화* -> 전달 전략에 따라 sort 동작이 달라짐)
    ```
      public class AppleComparator implements Comparator<Apple>{
        public int compare(Apple a1, Apple a2){
          return a1.getWeight().compareTo(a2.getWeight());
        }
      }
      inventory.sort(new AppleComparator());
    ```
  * 익명 클래스 : 한번만 사용 (선언과 인스턴스화 동시)
    ```
      inventory.sort(new Comparator<Apple>(){
          public int compare (Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
          }
        });  
    ```
  * 람다 표현식
    ```
      inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

      inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight());    //형식 추론에 따른 간결화


      Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());   //정적 메소드 compaing 포함    
      import static java.util.Comparator.comparing;
      inventory.sort(comparing(apple -> apple.getWeight())); 
    ```
  * 메소드 참조 (정적 메소드)
    ```
      inventory.sort(comparing(Apple::getWeight));      
    ```

### 13. 람다식의 조합 : 디폴트 메소드
  * Comparaotr 조합 : 역정렬 reversed()
  * Predicate 조합 : 반전 negate() / or / and
  * Function 조합 : f.andThen(g)  -> andThen g(f(x)) / compose f(g(x))

*****

## chap 4. 스트림 소개
### 1. 스트림 = Sequence of elements
  * 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소
  * 선언형 / 조립 가능 / 병렬<br>
    선언형 : 보다 간결하고 가독성이 좋아진다. if,조건문 등의 동작 구현에 대한 지정 없이 수행을 지정할 수 있다.<br>
    조립 가능 : filter, sorted, map, collect 같은 블록 연산을 연결해 복잡한 처리 파이프라인을 만들 수 있다.<br>
    병렬화 : parallelStream() 병렬 실행으로 성능에 유리
  * 파이프라이닝 -> 최적화 : laziness, sort-circuiting
  * 내부반복 지원 
  * 중간연산과 최종연산

### 2. 파이프라이닝
  * 스트림 라이브러리에서 필터링 filter, 추출 map, 축소 limit 기능을 제공해 직접 기능을 구현할 필요가 없다.
  
### 3. 스트림과 컬렉션
  |about|컬렉션|스트림|
  |:---|:---|:---|
  |가장 큰 차이는 데이터를 언제 계산하는가|컬렉션 추가 전 (*모든 요소* 저장 -> 계산 -> 컬렉션 추가)|요청할 때만 (사용자가 *요청하는 값만* 스트림에서 추출)|
  |주요 관심|데이터 (시간과 공간의 복잡성과 관련 요소 저장, 접근 연산)|계산 (표현 계산식 위주)|
  |반복 타입|외부반복 (for-each 등)|내부반복|

### 4. 내부반복
  * 내부반복을 이용하면 (1) 작업을 투명하게 병렬로 처리하거나 최적화를 다양한 순서로 처리 가능 (2) 하드웨어 활용 병렬성 구현 자동 선택 (외부반복에서는 스스로 관리 (synchronized 등))

### 5. 스트림 연산
  * 연결되어 파이프라인을 형성하는 중간연산과 스트림 닫는 최종연산
  * 중간 연산 : 다른 스트림 반환해 파이프라인 구성 <br>
              단말연산을 스트림 파이프라인 실행 전까지 아무 연산도 수행하지 않음 (게으르다) -> 중간연산 합친 다음 최종연산으로 한번에 처리
  * 최종 연산 : 파이프라인을 실행, 결과 도출
  * 장점 : 쇼트서킷 -> 각 과정을 한 과정으로 합친 후 지정 숫자만큼 실행 시 중단할 수 있다.(cf. 모든 데이터에 대해 각 중간 연산을 다 수행 후 다음 연산으로)

*****

## chap 5. 스트림 활용
### 1. 필터링
  : 프리디케이트로 필터링 / 고유 요소만 필터링
  1. predicate (boolean 반환 함수) 필터링 : 일치하는 모든 요소 포함하는 스트림 반환
   ```
    List <Dish> vege = menu.steram() 
                           .filter(Dish::isVegetarian)
                           .collect(toList());
   ```
  2. 고유 요소 필터링 : 고유 여부는 스트림에 만든 객체의 hashCode, equals로 결정 
   ```    
    // 모든 짝수를 선택하고 중복을 필터링 

      List<Integer> numbers = Arrays.asList(1,2,3,3,2,4);
      numbers.steram() 
             .filter(i -> i%2 == 0)
             .distinct()
             .forEach(System.out::println);

      // System.out.println(2);
      // System.out.println(4);
   ```
    
### 2. 스트림 슬라이싱
 : 스트림 요소 선택하거나 스킵
  1. predicate 이용한 슬라이싱 
   * takeWhile : 무한 스트림을 포함한 모든 스트림에 프리디케이트 적용해 슬라이스
     ```
       //리스트 정렬 사실을 이용해 320 칼로리보다 크거나 같은 요리가 나왔을 때 반복 중단
       List<Dish> slicedMenu1 = specialMenu.stream()
                                           .takeWhile(dish.geCalories() < 320)
                                           .colect(toList());
     ```
  
   * dropWhile : 프리디케이트가 거짓이 되면 그 지점에서 작업 중단 후 남은 요소 반환. 무한스트림에서도 동작
     ```   
        //320 칼로리보다 큰 요소가 나왔을 때 작업 중단 후 남은 작업 (320보다 큰 요소) 반환
        List<Dish> slicedMenu2 = specialMenu.stream()
                                            .dropWhile(dish.geCalories() < 320)
                                            .colect(toList());
     ```
  2. 스트림 축소
   * limit(n) : 주어진 값 이상의 크기 갖는 새로운 스트림 반환. filter와 조합 시 프리디케이트와 일치하는 처음 N개 요소 선택 시 즉시 반환

  3. 요소 건너뛰기
   * skip(n) : 처음 n개 요소 제외한 스트림 반환 

### 3. 매핑
 : 특정 데이터 선택 기능
  1. 스트림 각 요소에 함수 적용
   * map(func) : 인수로 제공된 함수가 각 요소에 적용된 결과가 새로운 요소로 매핑 (modify보다 transforming의 개념)
      ```
        //각 요리명의 길이 구하기
        List<Integer> dishNameLength = menu.stream()
                                           .filter(Dish::getName)
                                           .map(String::length)
                                           .colect(toList());
      ```
  2. 스트림 평면화
   * flatMap : 하나의 평면화된 스트림을 반환. 스트림의 각 값을 다른 스트림으로 만든 다음 모든 스트림을 하나의 스트림으로 연결하는 기능 수행
      ```
        List<String> uniqueCharacters = word.stream()
                                            .map(word -> word.split(""))  //각 단어를 개별 문자로 포함하는 배열로 변환 Stream<String[]> 
                                            .flatMap(Arrays::stream)      //생성된 스트림을 하나의 스트림으로 평면화 Stream<String>
                                            .distinct()
                                            .collect(toList());
      ```

### 4. 검색과 매핑
 : 특정 속성이 데이터 집합에 있는지 여부 검색
  1. 프리디케이트가 적어도 한 요소와 일치하는지 확인 : anyMatch
   ```
      if(menu.stream().anyMatch(Dish::isVegetarian)){
        System.out.println("the menu is (somewhat) vegetarian friendly! ");
      }    
   ```
  2. 프리디케이트가 모든 요소와 일치하는지 검사 : allMatch / noneMatch
   * allMatch : 모든 요소가 주어진 프리디케이트와 일치하는지 확인
   * noneMatch : 주어진 프리디케이트와 일치하는 요소가 없는지 확인
     ```
       boolean isHealthy = menu.stream()
                               .allMatch(dish -> dish.getCalories() < 1000);
     ```
  * 쇼트서킷 평가 : 전체 스트림을 처리하지 않더라도 원하는 요소를 찾으면 결과를 즉시 반환
  <br> ex) allMatch, noneMatch, findFirst, findAny, limit ...

  3. 요소 검사
   * findAny : 현재 스트림에서 임의의 요소 반환
      ```
        Optional <Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
      ```
   * Optional : 값의 존재나 부재 여부 표현하는 컨테이너 클래스

  4. 첫 번째 요소 찾기
   * findFirst()
     ```
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Optional<Integer> FirstSquareDivisibleByThree = list.stream().map(n->n*n).filter(n -> n%3 == 0).findFirst();
     ```

### 5. reducing
  1. reducing
   * reducing은 2개의 인수 가짐
      - 초깃값 0
      - 두 요소를 조합해 새로운 값 만드는 BinaryOperator<T>
   * 누적 연산으로 람다를 계속 호출하여 누적 연산 결과를 얻어가는 방식
   * 초기값이 없다면 합산 결과 반환할 수 없음
     ```
      int sum = numbers.stream().reduce(0,(a,b) -> a+b);  // reduce를 이용해 stream의 모든 요소를 더함 (numbers는 Integer)
      int sum = numbers.stream().reduce(0,Integer::sum);  // Integer 클래스의 정적메소드 sum 활용

      int mul = numbers.stream().reduce(1,(a,b) -> a*b);  // reduce를 이용해 stream의 모든 요소를 곱함    
     ```
  2. 최대값과 최소값
   * reduce를 이용해 최대값 최소값 찾기
     ```
       Optional <Integer> max = numbers.stream().reduce(Integer::max);              
       Optional <Integer> max = numbers.stream().reduce(Integer::min);  
     ```
 
   * Stream 으로 최대값 찾기
     - 숫자 비교
        ```
          List <Integer> alist = Arrays.asList(1,2,3);
          Integer maxVar = alist.stream().mapToInt(x->x).max().getAsInt();
          Integer maxVar = alist.stream().max(Comparator.comparing(x->x));

          int [] arr = {1,2,3};
          int max = alist.stream(arr).max().getAsInt();
        ```
     - String 비교
        ```
          String [] line = {"hello","world","hi"};
          int maxLength = alist.stream(line).mapToInt(String::length).max().getAsInt();
        ```
        
### 6. 숫자형 스트림
  1. 기본형 특화 스트림
	  * IntStream / DoubleStream / LongStream
	  * 숫자 스트림으로 매핑
      ```
        int calories = menu.stream().mapToInt(Dish::getCalories) // Integer형식으로 추출 후 IntStream 반환 (Stream<Integer>랑 다름)
                                    .sum()						// 비어있으면 0 반환
      ``` 
	  * 객체 스트림으로 복원
      ```
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed(); 	// 숫자스트림을 스트림으로 변환
      ``` 	 	
   * 기본형 특화 스트림 버전 Optional 
     	- 스트림에 요소가 없는 상황과 실제 값 구분 위함
     	- OptionalInt / OptionalDouble / OptionalLong
        ```
          int max = menu.stream().mapToInt(Dish::getCalories).max().orElse(1); // 값이 없을 때 사용할 기본값 명시
        ```	
  2. 숫자 범위
	  * range(m,m) : n과 m 미포함
	  * rangeClosed(n,m) : n과 m 포함
	    ```
        IntStream evenNumbers = IntStream.rangeClosed(1,100)  //1~100 범위 표현
                                         .filter(n -> n%2 == 0);
        evenNumbers.count(); 		//1~100 중 짝수 50 반환 | rangeClosed 아닌 range였다면 1과 100포함하지 않으므로 49 반환
	    ```
  3. 피타고라스 수
 	    ```
 	      Stream <int[]> pythgoreanTriples = IntStream.rangeClosed(1,100).boxed()
                                                    .flatMap(a -> IntStream.rangeClosed(a,100)
                                                                           .filter(b -> Math.sqrt(a*a + b*b % 1 == 0)
                                                                           .mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
                                                    );
 	      pythgoreanTriples.limit(5).forEach(t -> System.out.println(t[0]+", "+t[1]+", "+t[2]));
 	    ```
### 7. 스트림 만들기
*****