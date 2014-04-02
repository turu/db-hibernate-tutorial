package pl.agh.turek.bazy.hibernate.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Piotr Turek
 */
public class SpringConfigRunner {

    public static void main(String[] args) {
        new SpringConfigRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
    }

}
