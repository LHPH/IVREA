package mx.gob.ivrea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("infraestructura-ivrea.xml");
        // Suma sum = (Suma) ctx.getBean(Suma.class);
        // sum.oper(10, 1);
    }
}
