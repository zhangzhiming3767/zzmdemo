package com.example.zzmdemo.headfirst.decorator.starbuzz;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  @Override
	public double cost() {
		return 1.99;
	}
}
