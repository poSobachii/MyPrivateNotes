package esapplication;


import esapplication.services.ElasticSearchManipulator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ElasticApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ElasticApplication.class);
        ElasticSearchManipulator app = ctx.getBean(ElasticSearchManipulator.class);
        app.run();
        System.out.println("==============FINISHED==============");

    }

}

