package com.thaohm.unit;

import com.thaohm.HomepageController;
import com.thaohm.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by thaohm on 7/26/16.
 */
public class HomepageControllerTest {
    @InjectMocks
    HomepageController homepageController;

    @Mock
    MessageService messageService;

    MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(homepageController).build();
    }

    @Test
    public void index_renderIndexTemplate() throws Exception {
        when(messageService.getMessage()).thenReturn("Goodbye, world!");
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", is(equalTo("Goodbye, world!"))));
    }
}
