/**
 * Copyright (c) 2013, mini2Dx Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.context;

import org.junit.Assert;
import org.junit.Test;
import org.mini2Dx.injection.dummy.TestBean;
import org.mini2Dx.injection.dummy.TestInterfaceImpl;

/**
 * Integration test for {@link GameContext} and {@link DesktopComponentScanner}
 * 
 * @author Thomas Cashman
 */
public class DesktopGameContextIT {

	@Test
	public void testGameContext() throws Exception {
		DesktopGameContext.initialise(new String[] { "org.mini2Dx.injection.dummy" });

		TestBean testBean1 = GameContext.getBean(TestBean.class);
		TestBean testBean2 = GameContext.getBean(TestBean.class);

		Assert.assertEquals(false, testBean1.equals(testBean2));
		Assert.assertEquals(true,
				testBean1.getDependency().equals(testBean2.getDependency()));

		Assert.assertEquals(true,
				testBean1.getInterfaceField() instanceof TestInterfaceImpl);
		// Assert.assertEquals(
		// false,
		// testBean1.getInterfaceField().equals(
		// testBean2.getInterfaceField()));

		TestInterfaceImpl testInterfaceImpl1 = GameContext
				.getBean(TestInterfaceImpl.class);
		TestInterfaceImpl testInterfaceImpl2 = GameContext
				.getBean(TestInterfaceImpl.class);

		Assert.assertEquals(false,
				testInterfaceImpl1.getValue() == testInterfaceImpl2.getValue());
	}
}
