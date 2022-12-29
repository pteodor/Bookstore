package pl.first.project.book.store.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;

@Configuration
@ComponentScan("pl.first.project.book.store")
@EnableScheduling
public class AppConfiguration {

    /*@Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .directModelSubstitute(Object.class, Void.class)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("pl.first.project.book.store.controllers.rest.api"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo(
                "Bookstore API",
                "moja księgarnia z ksiONSZkami",
                "2.0",
                "http://google.pl",
                new Contact("Miron", "miron.pl", "mironkokosinski@gmail.com"),
                "Licence Moja",
                "http://google.pl",
                Collections.emptyList()
        );
    }
}
