package com.manticore.funtutorial;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {

	@Override
	public boolean test(Person p) {
		return p.getAge() >= 30 && p.getAge() <= 70;
	}

}
