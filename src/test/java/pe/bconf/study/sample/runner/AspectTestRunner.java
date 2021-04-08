package pe.bconf.study.sample.runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pe.bconf.study.sample.aop.service.SampleService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringContextAop.class)
public class AspectTestRunner {
    @Autowired
    private SampleService service;
    @Test
    public void test(){
        System.out.println("test start");
        service.doNotRun(true);
        System.out.println("test end");
    }
}

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages =  {"pe.bconf.study.sample"})
class SpringContextAop{}