package chap2.practice;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import chap2.example.Apple;

public class main {
	public static void main(String [] args) {
		//example1 Comparator로 정렬하기 
		List<Apple> inventory = new ArrayList<>();
		
		inventory.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
	
		//inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		//example2 Runnable 코드 블록 실행하기 
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello world");
			}
		});
		
		t = new Thread(()-> System.out.println("Hello world!"));	
		
		//example3 GUI 이벤트 처리하기
		Button button = new Button("Send");
		/*
		button.setOnAction(new EvenHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				label.setText("Send!");
			}
		});
		*/
	}
}
