package grammer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaExample {
	public static void main(String[] args) {
		/*
		 * 람다식 - 익명메소드 메소드를 하나만 가지고 있는 함수형 인터페이
		 * (매겨변수 목록) -> { 실행 }
		 */
		new Thread(() -> {
			System.out.println("Hello World");
		}).start();
		
		Arrays.asList(1, 10)
		.stream()
		.filter(i -> (i%2 == 0))
		.forEach(System.out::println);
		
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		.stream()
		.filter(i -> (i%2 == 0))
		.map(val -> val+1)
		.forEach(val -> System.out.println(val));
		
		final List<Person> p = Arrays.asList(
				new Person("John", 25),
				new Person("Joo", 30),
				new Person("HyunAa",26),
				new Person("HyunA",27),
				new Person("Tayeon", 31));
		
		List<Person> l1 = p.stream()
				.sorted(Comparator.comparing(Person::getName)
						.thenComparing(Comparator.comparing(Person::getAge)))
				.collect(Collectors.toList());
		System.out.println(l1);
		
		List<Person> l2 = p.stream()
				.sorted(Comparator.comparing((Person temp) -> temp.name))
				.filter((Person temp) -> temp.age%2 != 0)
				.collect(Collectors.toList());
		System.out.println(l2);
	}
}

class Person{
	String name; int age;
	Person(String name, int age) { this.name = name; this.age = age; }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
