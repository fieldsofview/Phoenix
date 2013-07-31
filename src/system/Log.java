/**
 * This is the Logging system Class that generates a logger instance for anything
 * that requires to be logged in the system. The Logger used if Apache's log4j 1.2.17
 */
package system;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Murali
 */
public class Log {

	public static Logger logger = Logger.getRootLogger();

	/*
	 * TODO:// Write a on the fly log files generator.
	 */

	/**
	 * Configure the logger based on the configuration file provided in the
	 * "config" directory.
	 */
	public static void ConfigureLogger() {
		PropertyConfigurator.configure("config/logger.properties");
                logger.setLevel(Level.INFO);
		// TimeZone tz = TimeZone.getTimeZone("IST");
	}
}
