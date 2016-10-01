package com.example.core.dao;

import com.example.core.entity.Users;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsersDAOIT {

    private static final Logger logger = LoggerFactory.getLogger(UsersDAOIT.class);

    @Autowired
    private UsersDAO usersDAO;

    private static final String USER_NAME = RandomStringUtils.randomAlphabetic(50);
    private static final String PASSWORD = RandomStringUtils.randomAlphabetic(50);

    private Users p;

    @Before
    public void onStartUp() {
        p = new Users();
        p.setUsername(USER_NAME);
        p.setPassword(PASSWORD);
        p.setEnabled(Boolean.TRUE);
    }

    @Test
    public void testSave() {
        usersDAO.save(p);
        assertNotNull(p.getUsername());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_NullUsername() {
        p.setUsername(null);
        usersDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_LongUsername() {
        p.setUsername(RandomStringUtils.randomAlphabetic(51));
        usersDAO.save(p);
    }
}
