package com.example.zzmdemo.headfirst.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	@Override
	public abstract String getDescription();
}
