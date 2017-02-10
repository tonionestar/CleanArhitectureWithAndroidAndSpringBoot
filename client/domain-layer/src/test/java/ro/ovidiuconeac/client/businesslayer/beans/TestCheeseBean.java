package ro.ovidiuconeac.client.businesslayer.beans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ovidiu on 2/7/17.
 */

public class TestCheeseBean {

    private CheeseBeanImpl cheeseBean;

    @Before
    public void init() {
        cheeseBean = new CheeseBeanImpl();
    }

    @After
    public void deinit() {
        cheeseBean = null;
    }

    @Test
    public void getFruit() {
        assertNotNull(cheeseBean.getRandomCheese());
    }
}
