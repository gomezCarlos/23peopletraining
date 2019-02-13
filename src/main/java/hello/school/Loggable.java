package hello.school;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loggable {

	private static final Logger LOGGER = LoggerFactory.getLogger(Loggable.class);
	
	@AfterReturning(pointcut="execution(* hello.school.*.*(..))",returning="value")
	public void logReturn(JoinPoint jp, Object value) {
		LOGGER.info("Action: {} with returning value of: {}", jp.getSignature().getName(),value);
	}
	
	
}
