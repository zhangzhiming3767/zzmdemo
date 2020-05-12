package com.example.zzmdemo.headfirst.strategy;

public class FakeQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Qwak");
	}
}
