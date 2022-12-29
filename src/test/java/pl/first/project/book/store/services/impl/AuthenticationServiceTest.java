package pl.first.project.book.store.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.first.project.book.store.database.hibernate.EntitySaverStub;
import pl.first.project.book.store.model.User;
import pl.first.project.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

public class AuthenticationServiceTest extends GenericServiceTest {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    EntitySaverStub entitySaver;

    @Resource
    SessionObject sessionObject;

    @Before
    public void configuration() {
        Mockito
                .when(this.userDAO.getUserByLogin(Mockito.any()))
                .thenReturn(generateUser());
        Mockito
                .when(this.userDAO.getUserByLogin("jakisLoginKtoregoNieMaWBazie"))
                .thenReturn(Optional.empty());
        Mockito
                .when(this.userDAO.isLoginExist(Mockito.any()))
                .thenReturn(true);
        Mockito
                .when(this.userDAO.isLoginExist("user123"))
                .thenReturn(false);
    }

    @Test
    public void successAuthenticationTest() {
        String userLogin = "admin";
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword("admin");

        this.sessionObject.setUser(null);

        this.authenticationService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getUser());
        Assert.assertEquals("admin", this.sessionObject.getUser().getLogin());
    }

    @Test
    public void incorrectLoginAuthenticationTest() {
        User user = new User();
        user.setLogin("jakisLoginKtoregoNieMaWBazie");
        user.setPassword("admin");

        this.sessionObject.setUser(null);

        this.authenticationService.authenticate(user);

        Assert.assertNull(this.sessionObject.getUser());
    }

    @Test
    public void incorrectPasswordAuthenticationTest() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin1234");

        this.sessionObject.setUser(null);

        this.authenticationService.authenticate(user);

        Assert.assertNull(this.sessionObject.getUser());
    }

    @Test
    public void successRegistrationTest() {
        User user = new User();
        user.setLogin("user123");
        user.setPassword("user123");
        //int saveEntityCallsBeforeTest = this.entitySaver.getPersistEntityCalls();

        this.authenticationService.register(user);

        //int saveEntityCallsAfterTest = this.entitySaver.getPersistEntityCalls();

        //Assert.assertEquals(saveEntityCallsAfterTest, saveEntityCallsBeforeTest + 1);
        Mockito.verify(this.entitySaver, Mockito.times(1)).persistEntity(Mockito.any());
    }

    @Test
    public void loginAlreadyExistRegistrationTest() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");

        this.authenticationService.register(user);
    }

    @Test
    public void logoutTest() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");

        this.sessionObject.setUser(null);

        this.authenticationService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getUser());

        this.authenticationService.logout();

        Assert.assertNull(this.sessionObject.getUser());
    }

    public  Optional<User> generateUser() {
        return Optional.of(new User(1, "admin", DigestUtils.md5Hex("admin")));
    }
}
