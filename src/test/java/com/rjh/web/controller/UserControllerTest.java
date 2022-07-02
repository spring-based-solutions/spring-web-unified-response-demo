package com.rjh.web.controller;

import com.rjh.web.AbstractBaseTest;
import com.rjh.web.entity.User;
import com.rjh.web.response.ResponseCode;
import com.rjh.web.response.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author NULL
 * @since 2022-07-02
 */
public class UserControllerTest extends AbstractBaseTest {

    private String baseUrl = "/users";

    @Test
    public void testAddUser() throws Exception {
        String name = "Ben";
        User user = new User();
        user.setName(name);
        mockMvc.perform(MockMvcRequestBuilders.post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(name));
    }

    @Test
    public void testDeleteUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(baseUrl+"/1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(true));
    }

}
