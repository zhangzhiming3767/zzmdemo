package com.example.zzmdemo.headfirst.strategy;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack");
	}
}
