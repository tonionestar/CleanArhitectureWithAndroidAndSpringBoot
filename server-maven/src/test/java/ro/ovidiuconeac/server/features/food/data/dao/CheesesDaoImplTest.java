package ro.ovidiuconeac.server.features.food.data.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ro.ovidiuconeac.models.features.featurex.Cheese;
import ro.ovidiuconeac.server.features.food.data.exceptions.CheeseNotFoundException;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 2/19/17.
 */

public class CheesesDaoImplTest {

    private CheesesDao cheesesDao;

    @Before
    public void setUp() {
        cheesesDao = mock(CheesesDao.class);
    }

    @After
    public void tearDown() {
        cheesesDao = null;
    }

    @Test
    public void getRandomCheese() {
        Cheese cheese = new Cheese("Cas");
        Cheese result = null;
        try {
            when(cheesesDao.getRandomCheese()).thenReturn(cheese);
            result = cheesesDao.getRandomCheese();
        } catch (CheeseNotFoundException e) {
            assertEquals(true, false);
        }
        assertNotNull(result);
        assertEquals(cheese.getName(), result.getName());
    }

    @Test
    public void getRandomCheeseWithCheeseNotFoundException1() {
        try {
            when(cheesesDao.getRandomCheese()).thenThrow(new CheeseNotFoundException());
            cheesesDao.getRandomCheese();
        } catch (CheeseNotFoundException e) {
            assertEquals("No cheeses found in database", e.getMessage());
        }
    }

    @Test(expected = CheeseNotFoundException.class)
    public void getRandomCheeseWithCheeseNotFoundException2() throws CheeseNotFoundException {
        when(cheesesDao.getRandomCheese()).thenThrow(new CheeseNotFoundException());
        cheesesDao.getRandomCheese();
    }
}
