package com.girl.service;

import com.girl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServerTest {
    @Autowired
    private GirlServer girlServer;
    @Test
    public void insertTwoGirl() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void girlAdd() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        Optional<Girl> girl =girlServer.findById(24);
        Assert.assertEquals(new Integer(15),girl.get().getAge());
        Assert.assertEquals("C",girl.get().getCupSize());
    }

    @Test
    public void updateById() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void findByAge() throws Exception {
    }

}