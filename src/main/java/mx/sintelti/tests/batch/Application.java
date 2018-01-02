package mx.sintelti.tests.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author: Javier Ramirez Jr
 * Date: 31/12/17
 * Time: 21:11
 * Project: SpringBatchTest
 * www.sintelti.mx
 */

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
