package pl.first.project.book.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.first.project.book.store.configuration.AppConfiguration;
import pl.first.project.book.store.database.memory.BookDatabase;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        /*ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        BookDatabase database = context.getBean(BookDatabase.class);
        System.out.println(database.getBooks().get(0).getTitle());*/
        //pl.first.project.book.store.model.Book book = new pl.first.project.book.store.model.Book();
    }
}
