package pl.first.project.book.store.services.impl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.first.project.book.store.configuration.TestConfiguration;
import pl.first.project.book.store.database.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class GenericServiceTest {

    @MockBean
    IBookDAO bookDAO;

    @MockBean
    IEntitySever entitySever;

    @MockBean
    IOrderDAO orderDAO;

    @MockBean
    IOrderPositionDAO orderPositionDAO;

    @MockBean
    IUserDAO userDAO;
}
