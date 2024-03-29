/**
 * 
 * Copyright (C) [2012] - [2014] CareerScale IT Consulting LLP. All rights reserved.
 * 
 * If you got benefit with this code or with our training modules or for business queries, please do send email to info@careerscale.in
 * 
 * Information is provided in AS IS condition.
 * 
 */

package in.careerscale.training.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Test;

/**
 * 
 * @author harinath
 * 
 */
public class Log4j2Test extends BaseLogTest {

	@Test
	public void simpleAppenderTest() {

		Configurator.initialize("console", "log4j2/xml/log4j2.xml");
		Logger log = LogManager.getRootLogger();
		logPanagramResults(log);
	}

	@Test
	public void rollingAppenderTest() {

		Configurator.initialize("console", "log4j2/xml/log4j2-rolling.xml");
		Logger log = LogManager.getRootLogger();
		logPanagramResults(log);
	}

	@Test
	public void multiLoggerTest() {

		Configurator.initialize("console", "log4j2/xml/log4j2-multiple.xml");
		Logger log = LogManager.getRootLogger();
		logPanagramResults(log);

		Logger console = LogManager.getLogger("rollingLogger");
		logPanagramResults(console);

	}

}
