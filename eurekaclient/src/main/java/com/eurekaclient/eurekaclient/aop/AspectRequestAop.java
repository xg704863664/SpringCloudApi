package com.eurekaclient.eurekaclient.aop;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
@Log4j2
public class AspectRequestAop {

    @Pointcut("execution(public * com.eurekaclient.eurekaclient..*.*(..))")
    public void requestRecoder(){

    }

    @Around("requestRecoder()")
    public  Object requestTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        RequestAttributes requestAttributes =null;
        try {
             requestAttributes = RequestContextHolder.currentRequestAttributes();
        }catch (Exception e){
            return o;
        }

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        if (signature.getDeclaringType().isAnnotationPresent(RestController.class)||signature.getDeclaringType().isAnnotationPresent(Controller.class)) {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = servletRequestAttributes.getRequest();
            log.info("ip: {} url: {} class_method:{} args:{} time:{}", request.getRemoteAddr(), request.getRequestURL().toString(), signature.getDeclaringTypeName() + "." + signature.getName(), proceedingJoinPoint.getArgs(),(endTime-startTime)/1000+"s");
        }
        return o;
    }

    @AfterThrowing(pointcut = "requestRecoder()",throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("{} {} Params[{}] ,throws: [{}]", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()), error.getMessage());
    }
//    @Before("requestRecoder()")
//    public void logRequest(JoinPoint joinPoint){
//        RequestAttributes requestAttributes =null;
//        try {
//             requestAttributes = RequestContextHolder.currentRequestAttributes();
//        }catch (Exception e){
//            return;
//        }
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        Class<?> clazz = signature.getDeclaringType();
//        int len = joinPoint.getArgs().length;
//        Class<?> [] a= new Class[len];
//        for (int i = 0; i <len; i++) {
//            a[i]=joinPoint.getArgs()[i].getClass();
//        }
//        try {
//            Method method = clazz.getMethod(signature.getName(),a);
//            String name = method.getName();
//            System.out.println(name);
//            if (signature.getDeclaringType().isAnnotationPresent(RestController.class)||signature.getDeclaringType().isAnnotationPresent(Controller.class)) {
//                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//                HttpServletRequest request = servletRequestAttributes.getRequest();
//                log.info("ip: {} url: {} class_method:{} args:{}", request.getRemoteAddr(), request.getRequestURL().toString(), signature.getDeclaringTypeName() + "." + signature.getName(), joinPoint.getArgs());
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
}