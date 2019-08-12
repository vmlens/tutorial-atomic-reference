package com.vmlens.tutorialAtomicReference;

public class UpdateStateNotThreadSafe {
	private volatile  State state = new State();
	public void update() {
		state = state.update();
	}
	public State getState() {
		return state;
	}	
}
