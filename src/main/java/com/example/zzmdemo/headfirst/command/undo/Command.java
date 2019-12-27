package com.example.zzmdemo.headfirst.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
