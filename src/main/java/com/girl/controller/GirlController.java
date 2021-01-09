package com.girl.controller;

import com.girl.entity.Girl;
import com.girl.girlUtils.HttpResultUtil;
import com.girl.result.HttpResult;
import com.girl.service.GirlServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
     /**
     * 服务端
     */
    @Autowired
    private GirlServer girlServer;

    /**
     * @return 查询到的集合
     * 全量查询
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlFindAll() {
        return girlServer.findAll();
    }

    /**
     * 插入数据
     * @param girl 待插入数据
     * @param bindingResult 异常返回信息
     * @return
     */
    @PostMapping(value = "/girls")
    public HttpResult<Girl> girlAdd(@Valid Girl girl,BindingResult bindingResult) {
        return girlServer.girlAdd(girl,bindingResult);
    }

    /**
     * 通过id查找用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public HttpResult findById(@PathVariable("id") Integer id) {
        return HttpResultUtil.success(girlServer.findById(id));
    }

    @PutMapping("/girl/{id}")
    public HttpResult UpdateById(@PathVariable("id") Integer id, Girl girl ) {
        return HttpResultUtil.success(girlServer.UpdateById(id,girl));
    }

    @DeleteMapping("/girl/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        girlServer.deleteById(id);
    }

    @GetMapping("/girls/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlServer.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void insertTwoGirl() {
        girlServer.insertTwoGirl();
    }
    @GetMapping("/girl/getAge/{id}")
    public HttpResult<Girl>  getAge(@PathVariable("id") Integer id) throws Exception {
        Optional<Girl> girl=girlServer.getAge(id);
        return HttpResultUtil.success(girl);
    }
}
