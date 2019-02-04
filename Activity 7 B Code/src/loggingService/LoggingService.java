package loggingService;

import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingService {

	private static final Logger logger = LogManager.getLogger(LoggingService.class);
	
	public void LogDebug(InvocationContext ctx) {
		logger.debug("Debug info for: " + ctx.getMethod().getName());
	}
	public void LogInfo (InvocationContext ctx) {
		logger.info("Intercepting: " + ctx.getMethod().getName());
	}
	public void LogWarning (InvocationContext ctx) {
		logger.warn("Warning in: " + ctx.getMethod().getName());
	}
	public void LogError(InvocationContext ctx, Exception e) {
		logger.error("Error in: " + ctx.getMethod().getName() + " Exception: "+ e.toString());
	}
	public void LogInfoSuccess (InvocationContext ctx, boolean result) {
		logger.info("Method: " + ctx.getMethod().getName() + " Execution Success: " + result);
	}
}
