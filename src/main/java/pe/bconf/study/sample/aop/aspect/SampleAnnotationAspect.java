package pe.bconf.study.sample.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import pe.bconf.study.sample.aop.annotation.SampleAnnotation;


@Aspect
@Component
public class SampleAnnotationAspect {
    private static final Logger log = LoggerFactory.getLogger(SampleAnnotation.class);

    public SampleAnnotationAspect(){
        System.out.println("aspect created");
    }

    @Around("@annotation(pe.bconf.study.sample.aop.annotation.SampleAnnotation)")
//    @Before("execution(* *.doNotRun())")
    public void printMethodAspect(ProceedingJoinPoint joinPoint) throws Throwable{
//    public Object printMethodAspect(JoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        System.out.println("aspect hook start");
        Object[] args = joinPoint.getArgs();
        long totalTime = System.currentTimeMillis() - startTime;
        log.info("Method {} : {}ms", joinPoint.getSignature(), totalTime);

        if (ObjectUtils.isEmpty(args) || args.length > 1){
            joinPoint.proceed();
        } else {
            if (!(boolean) args[0]){
                joinPoint.proceed();
            }else{
                log.info("Method Passed");
            }

        }
    }
}
