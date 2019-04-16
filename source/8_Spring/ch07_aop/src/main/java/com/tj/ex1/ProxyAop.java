package com.tj.ex1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyAop {
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis(); // 시작시점시간
		String methodSignature = joinPoint.getSignature().toShortString();
		System.out.println(methodSignature +"가 시작되었습니다");
		try {
			Object obj = joinPoint.proceed();// 핵심기능 수행
			return obj;
		} finally {
			long endTime = System.currentTimeMillis(); // 끝시점 시간
			System.out.println(methodSignature+"가 끝났다.");
			System.out.println("경과 시간은 "+(endTime-startTime));
		}
	}
	public void beforeAdvice(JoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr+" 메소드 수행전 beforeAdvice 수행함");
	}
	public void afterAdvice() {
		System.out.println("핵심기능 수행 후 afterAdvice 무조건 실행");
	}
	public void afterReturningAdvice() {
		System.out.println("핵심기능에서 예외가 없을 경우만 핵심기능 수행 후");
		System.out.println("afterReturning Advice");
	}
	public void afterThrowingAdvice(JoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr+"기능에서 예외발생후 수행하는 공통기능");
	}
}





















