package pl.first.project.book.store.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.first.project.book.store.database.*;
import pl.first.project.book.store.database.hibernate.*;

@Configuration
@ComponentScan(basePackages = {
        "pl.first.project.book.store.controllers",
        "pl.first.project.book.store.services",
        "pl.first.project.book.store.session"
})
public class TestConfiguration {

    /*@Bean
    public IBookDAO bookDAO() {
        return new BookDAOStub();
    }

    @Bean
    public IEntitySever entitySever() {
        return new EntitySaverStub();
    }

    @Bean
    public IOrderDAO orderDAO() {
        return new OrderDAOStub();
    }

    @Bean
    IOrderPositionDAO orderPositionDAO() {
        return new OrderPositionDAOStub();
    }

    @Bean
    public IUserDAO userDAO() {
        return new UserDAOStub();
    }*/

// sposób tworzenia artificial DAO mockiem
    /*@Bean
    public IBookDAO bookDAO() {
        return Mockito.mock(IBookDAO.class);
    }*/


}

