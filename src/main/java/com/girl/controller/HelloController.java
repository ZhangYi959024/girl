package com.girl.controller;

import com.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController = @ResponseBody + @Controller
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    //    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private int age;
//    @Value("${content}")
//    private String  Content;
    @Autowired
    private GirlProperties girlProperties;

    //    @RequestMapping(value={"/hello","hi"},method = RequestMethod.GET)
    @RequestMapping(value = {"/hello1", "hi1"}, method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
//        return girlProperties.getCupSize();
//        return "index";
        return "id:" + myId;
    }
}