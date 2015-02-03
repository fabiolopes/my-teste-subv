package com.requerOnline.applicationContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceAroundTimes {
	
	@Around("execution(* * .logar *(..))")
	public Object marcarTempo(ProceedingJoinPoint joinPoint) throws Throwable{
		long tmpInicial = System.currentTimeMillis();
		Object resultado = joinPoint.proceed();
		long tmpFinal = System.currentTimeMillis();
		System.out.println("Tempo gasto na operação é "+(tmpFinal - tmpInicial));
		return resultado;
	}

}
