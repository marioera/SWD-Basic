package com.manticore.funtutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcessPerson {

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithinAgeRange(List<Person> roster, int low,
			int high) {
		for (Person p : roster) {
			if (p.getAge() >= low && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicate(List<Person> roster,
			Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPersons(List<Person> roster,
			Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void processPersonsWithFunction(List<Person> roster,
			Predicate<Person> tester, Function<Person, String> mapper,
			Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static <X, Y> void processElements(Iterable<X> source,
			Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();

		Person person = null;
		person = new Person(":D", 10);
		roster.add(person);
		person = new Person("A", 20);
		roster.add(person);
		person = new Person("B", 30);
		roster.add(person);
		person = new Person("C", 40);
		roster.add(person);
		person = new Person("D", 50);
		roster.add(person);
		person = new Person("E", 60);
		roster.add(person);
		person = new Person("F", 70);
		roster.add(person);
		person = new Person("G", 80);
		roster.add(person);
		person = new Person("H", 90);
		roster.add(person);

		// ProcessPerson.printPersonsOlderThan(roster, 30);
		// ProcessPerson.printPersonsWithinAgeRange(roster, 30, 70);
		// ProcessPerson.printPersons(roster, new
		// CheckPersonEligibleForSelectiveService());
		/*
		 * ProcessPerson.printPersons(roster, new CheckPerson() { public boolean
		 * test(Person p) { return p.getAge() >= 30 && p.getAge() <= 70; } });
		 */
		// ProcessPerson.printPersons(roster, (Person p) -> p.getAge() >= 30 &&
		// p.getAge() <= 70);
		// ProcessPerson.printPersonsWithPredicate(roster, (Person p) ->
		// p.getAge() >= 30 && p.getAge() <= 70);
		// ProcessPerson.processPersons(roster, (Person p) -> p.getAge() >= 30
		// && p.getAge() <= 70, (Person p) -> p.printPerson());
		// ProcessPerson.processPersonsWithFunction(roster, (Person p) ->
		// p.getAge() >= 30 && p.getAge() < 70, (Person p) -> p.getName() + " "
		// + p.getAge(), (String s) -> System.out.println(s));
		// ProcessPerson.processElements(roster, (Person p) -> p.getAge() >= 30
		// && p.getAge() < 70, (Person p) -> p.getName() + " " + p.getAge(),
		// (String s) -> System.out.println(s));
		// ProcessPerson.processElements(roster, (Person p) -> true, (Person p)
		// -> p.getAge(), (Integer s) -> System.out.println(s));
		// roster.stream().filter(p -> p.getAge() >= 30 && p.getAge() <
		// 70).map(p -> p.getName() + " " + p.getAge()).forEach(s ->
		// System.out.println(s));
		double sum = roster.stream()
				.filter(p -> p.getAge() >= 30 && p.getAge() < 70)
				.mapToInt(p -> p.getAge()).average().getAsDouble();
		System.out.println(sum);

	}
}