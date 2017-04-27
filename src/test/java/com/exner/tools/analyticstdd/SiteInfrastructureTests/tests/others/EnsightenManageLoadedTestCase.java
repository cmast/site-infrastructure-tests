package com.exner.tools.analyticstdd.SiteInfrastructureTests.tests.others;

import com.exner.tools.analyticstdd.SiteInfrastructureTests.Tools;
import com.exner.tools.analyticstdd.SiteInfrastructureTests.tests.WebDriverBasedTestCase;

public class EnsightenManageLoadedTestCase extends WebDriverBasedTestCase {

	public EnsightenManageLoadedTestCase(String pageURL, Object params) {
		super(pageURL);
		setName(Tools.ENSIGHTEN + " loaded - " + pageURL);
	}

	@Override
	protected void runTest() throws Throwable {
		// check whether tool has been loaded on the page
		Object response = _jsExecutor
				.executeScript("if (typeof Bootstrapper === 'object') { return true } else { return false }");

		// make sure the element exists
		if (Boolean.class.isAssignableFrom(response.getClass())) {
			assertTrue(Tools.ENSIGHTEN + " must load", (Boolean) response);
		} else {
			fail(Tools.ENSIGHTEN + " not loaded");
		}

	}

}
