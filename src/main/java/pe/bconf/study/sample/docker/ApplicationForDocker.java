package pe.bconf.study.sample.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * docker에서 실행할 애플리케이션
 */
@SpringBootApplication
public class ApplicationForDocker {
    public static void main(String[] args){
        SpringApplication.run(ApplicationForDocker.class);
    }
}
