package com.thaohm;

import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by thaohm on 7/26/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest()
public class HomePageTest extends SeleniumTest {

    @Override
    protected String getDefaultBaseUrl() {
        return "http://localhost:8080";
    }

    @Test
    public void itContainsMessage() {
        goTo(getDefaultBaseUrl());
        find("body").should().contain("Hello, world");
    }
}
