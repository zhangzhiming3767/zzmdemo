package com.example.zzmdemo.headfirst.strategy;

public class MuteQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
