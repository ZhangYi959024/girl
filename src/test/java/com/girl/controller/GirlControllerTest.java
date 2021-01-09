package com.girl.controller;

import com.girl.entity.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void girlFindAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlAdd() throws Exception {
        MockHttpServletRequestBuilder request =MockMvcRequestBuilders.post("/girls");
        request.param("id","40").param("age","30").param("cupSize","F");
        MvcResult result1=  mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("result1=========="+result1.getResponse().getContentAsString());
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girl/37")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":\"0\",\"resultMessage\":\"处理成功\",\"data\":{\"id\":37,\"cupSize\":\"F\",\"age\":20}}"));
    }

    @Test
    public void updateById() throws Exception {
        MockHttpServletRequestBuilder requestBuilders=MockMvcRequestBuilders.put("/girl/37");
        requestBuilders.param("cupSize","F").param("age","20");
        mvc.perform(requestBuilders).andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string("{\"code\":\"0\",\"resultMessage\":\"处理成功\",\"data\":{\"id\":37,\"cupSize\":\"F\",\"age\":20}}"));
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void findByAge() throws Exception {
    }

    @Test
    public void insertTwoGirl() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

}