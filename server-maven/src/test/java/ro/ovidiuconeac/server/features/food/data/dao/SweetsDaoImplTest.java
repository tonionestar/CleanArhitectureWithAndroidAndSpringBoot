package ro.ovidiuconeac.server.features.food.data.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ovidiuconeac.models.features.featurex.Sweet;
import ro.ovidiuconeac.server.features.food.data.exceptions.SweetNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 2/19/17.
 */
public class SweetsDaoImplTest {
    
    private SweetsDao sweetsDao;

    @Before
    public void setUp() {
        sweetsDao = mock(SweetsDao.class);
    }

    @After
    public void tearDown() {
        sweetsDao = null;
    }

    @Test
    public void getRandomCheese() {
        Sweet sweet = new Sweet("Turbo bubble gum");
        Sweet result = null;
        try {
            when(sweetsDao.getRandomSweet()).thenReturn(sweet);
            result = sweetsDao.getRandomSweet();
        } catch (SweetNotFoundException e) {
            assertEquals(true, false);
        }
        assertNotNull(result);
        assertEquals(sweet.getName(), result.getName());
    }

    @Test
    public void getRandomSweetWithSweetNotFoundException1() {
        try {
            when(sweetsDao.getRandomSweet()).thenThrow(new SweetNotFoundException());
            sweetsDao.getRandomSweet();
        } catch (SweetNotFoundException e) {
            assertEquals("No sweets found in database", e.getMessage());
        }
    }

    @Test(expected = SweetNotFoundException.class)
    public void getRandomCheeseWithCheeseNotFoundException2() throws SweetNotFoundException {
        when(sweetsDao.getRandomSweet()).thenThrow(new SweetNotFoundException());
        sweetsDao.getRandomSweet();
    }
}
