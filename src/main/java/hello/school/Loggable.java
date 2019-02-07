package hello.school;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loggable {

	Logger LOGGER = LoggerFactory.getLogger(Loggable.class);
	
	@Around("execution(* hello.school.*(..))")
	public void log(JoinPoint jp) {
		LOGGER.info("Action: %s", jp.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* hello.school.*(..))",returning="value")
	public void logReturn(JoinPoint jp, Object value) {
		LOGGER.info("Action: %s with returning value of: %s", jp.getSignature().getName(),value);
	}
}
