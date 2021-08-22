package chap5.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
	public static void main(String [] args) {
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011,300),
				
				new Transaction(raoul, 2012,1000),

				new Transaction(raoul, 2011,400),

				new Transaction(mario, 2012,710),

				new Transaction(mario, 2012,700),

				new Transaction(alan, 2012,950)
				
		);
		
		//1.
		List <Transaction> Trans2011 = transactions.stream()
											  		 .filter(trader -> trader.getYear() == 2011)
											  		 .sorted((a,b)-> a.getValue() - b.getValue())
											  		 //.sorted(comparing(Transaction::getValue))
											  		 //.forEach(t -> System.out.println(t.toString()));
											  		 .collect(Collectors.toList());	
 		 /*
 		  * filter : predicate(boolean 반환 함수)와 일치하는 모든 요소를 포함하는 스트림 반환
 		  * map : 인수로 적용된 함수가 각 요소에 적용되어 적용한 결과가 새로운 요소로 매핑 (변환)
 		  */
		
		//2. 
		List<String> Allcities = transactions.stream()
										  .map(t -> t.getTrader().getCity())
										  .distinct()
										  //.forEach(t -> System.out.println(t.toString()));
		  		 						  .collect(Collectors.toList());	
		
		//3.
		List<Trader> tradersInCambidge = transactions.stream()				 
													 .map(Transaction::getTrader)
													 .filter(t -> t.getCity().equals("Cambridge"))
													 .distinct()
													 .sorted(Comparator.comparing(Trader::getName))
													 //.forEach(t -> System.out.println(t.toString()));
					  		 						 .collect(Collectors.toList());	
													 
											
		//4.
		String tradersName = transactions.stream()
										 .map(transaction -> transaction.getTrader().getName())
										 .distinct()
										 .sorted()
										 .collect(Collectors.joining());	
		//System.out.println(tradersName);
		
		//5.
		boolean isMilan = transactions.stream()
						 .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		//System.out.println(isMilan);
		
		//6.
		transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
		
		//7.
		System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max));
		
		//8.
		System.out.println(transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::min));	
	}
}
