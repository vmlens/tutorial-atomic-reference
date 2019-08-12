package com.vmlens.tutorialAtomicReference;

import static org.junit.Assert.*;
import org.junit.Test;
import com.vmlens.annotation.Interleave;
import com.vmlens.tutorialAtomicReference.UpdateStateNotThreadSafe;


public class ConcurrencyTestUpdateState {
	// An not thread safe update using a volatile variable
	private final UpdateStateNotThreadSafe object = new UpdateStateNotThreadSafe();
	
	// Change to a thread safe update using compareAndSet
    //private final UpdateStateWithCompareAndSet object = new UpdateStateWithCompareAndSet();
	
	@Interleave
	private void update() {
		object.update();
	}
	@Test
	public void test() throws InterruptedException {
		Thread first = new Thread( () ->    {  update();  } ) ;
		Thread second = new Thread( () ->   {  update();  } ) ;
		first.start();
		second.start();
		first.join();
		second.join();	
		assertTrue(  object.getState().isAccessedByMultipleThreads() );
	}
}
