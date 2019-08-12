package com.vmlens.tutorialAtomicReference;

import java.util.concurrent.atomic.AtomicReference;

public class UpdateStateWithCompareAndSet {
	private final AtomicReference<State> state = new AtomicReference<State>(new State());
	public  void update() {
		State current = state.get();
		State newValue = current.update();
		while( ! state.compareAndSet( current , newValue ) ) {
			current = state.get();
			newValue = current.update();
		}
	}
	public State getState() {
		return state.get();
	}	
}
