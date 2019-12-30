package com.example.zzmdemo.headfirst.factory.challenge;


import java.util.List;

public class PacificCalendar extends Calendar {
	public PacificCalendar(ZoneFactory zoneFactory) {
		zone = zoneFactory.createZone("US/Pacific");
		// make a calendar for the pacific zone
		// ...
	}
	@Override
	public void createCalendar(List<String> appointments) {
		// make calendar from appointments
		System.out.println("Making the calendar");
	}
}