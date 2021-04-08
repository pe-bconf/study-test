package pe.bconf.study.sample.aop.service;

import org.springframework.stereotype.Component;
import pe.bconf.study.sample.aop.annotation.SampleAnnotation;

@Component
public class SampleService {
    @SampleAnnotation
    public void doNotRun(boolean run){
        System.out.println("This method have not to run.");
    }
}
