package com.thaohm.features;

import com.thaohm.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by thaohm on 7/26/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest
public class AnswerTest {
    RestTemplate template = new TestRestTemplate();

    @Test
    public void itReturnsTheAnswer() throws Exception {
        ResponseEntity<String> responseEntity = template
                .getForEntity("http://localhost:8080/answer/42", String.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is("Don't Panic!"));
    }
}
