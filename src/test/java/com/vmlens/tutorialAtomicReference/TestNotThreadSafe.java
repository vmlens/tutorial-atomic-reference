package com.vmlens.tutorialAtomicReference;

import static org.junit.Assert.*;
import org.junit.Test;
import com.vmlens.tutorialAtomicReference.UpdateStateNotThreadSafe;
import com.vmlens.api.AllInterleavings;
public class TestNotThreadSafe {
	@Test
	public void test() throws InterruptedException {
		try (AllInterleavings allInterleavings = new AllInterleavings("TestNotThreadSafe");) {
			while (allInterleavings.hasNext()) {	
		final UpdateStateNotThreadSafe object = new UpdateStateNotThreadSafe();		
		Thread first = new Thread( () ->    {  object.update();  } ) ;
		Thread second = new Thread( () ->   {  object.update(); } ) ;
		first.start();
		second.start();
		first.join();
		second.join();	
		assertTrue(  object.getState().isAccessedByMultipleThreads() );
			}
		}
	}
}
