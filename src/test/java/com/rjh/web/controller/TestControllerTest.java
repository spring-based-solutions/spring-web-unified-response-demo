package com.rjh.web.controller;

import com.rjh.web.AbstractBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author NULL
 * @since 2022-07-02
 */
public class TestControllerTest extends AbstractBaseTest {

    private String baseUrl = "/test";

    @Test
    public void testStringReturn() throws Exception {
        String url = baseUrl+"/string/{str}";
        String str = "test";
        mockMvc.perform(MockMvcRequestBuilders.get(url,str))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

}
