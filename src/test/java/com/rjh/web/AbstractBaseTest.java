package com.rjh.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringWebUnifiedResponseDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractBaseTest {

    @Resource
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Resource
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void init(){
        if(mockMvc==null){
            mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        }
    }

}
