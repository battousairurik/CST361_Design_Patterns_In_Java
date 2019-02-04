package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import loggingService.LoggingService;

@Interceptor
public class MethodExecutionInterceptor {

	private LoggingService logger = new LoggingService();
	
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {
		boolean success = true;
		logger.LogInfo(ctx); 
		//Get parameters from executing method if needed
		try {
			return ctx.proceed();
		} catch (Exception e) {
			success = false;
			logger.LogError(ctx, e);
			logger.LogInfoSuccess(ctx, success);
			return null;
		}finally{
			if (success == true) {
				logger.LogInfoSuccess(ctx, success);
			}
		}		
	}
}
