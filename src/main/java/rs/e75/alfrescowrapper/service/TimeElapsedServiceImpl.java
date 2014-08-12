package rs.e75.alfrescowrapper.service;

import org.apache.log4j.Logger;

/**
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class TimeElapsedServiceImpl implements TimeElapsedService {
	private static Logger logger = Logger
			.getLogger(TimeElapsedServiceImpl.class);

	// @Override
	// public void logRestTime(String name,long start,long end)
	// {
	// logger.debug("TIME ELAPSED ON :{"+name+"}"+(end-start));
	// }

	public void logRestTime(String name,
			org.apache.commons.lang.time.StopWatch stopWatch) {
	
		logger.debug("TIME ELAPSED ON :{" + name + "}  {" + stopWatch + "}");
	}

}
