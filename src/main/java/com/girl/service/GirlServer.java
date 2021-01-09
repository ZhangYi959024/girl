package com.girl.service;

import com.girl.entity.Girl;
import com.girl.enums.HttpResultEnum;
import com.girl.exception.GirlException;
import com.girl.girlUtils.HttpResultUtil;
import com.girl.repository.GirlRepository;
import com.girl.result.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class GirlServer {
    @Autowired
    private GirlRepository girlRepository;
    private static final Logger logger = LoggerFactory.getLogger(GirlServer.class);

    @Transactional
    public void insertTwoGirl() {
        Girl girl = new Girl();
        girl.setAge(30);
        girl.setCupSize("G");
        girl.setId(6);
        girlRepository.save(girl);
        Girl girl1 = new Girl();
        girl1.setAge(30);
        girl1.setCupSize("G");
        girl1.setId(7);
        girlRepository.save(girl1);
    }
    public Optional<Girl> getAge(Integer id) throws Exception {
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age < 10) {
            throw new GirlException(HttpResultEnum.PRIMARY_SCHOOL);
        }
        if (age >= 10 && age < 16) {
            throw new GirlException(HttpResultEnum.MIDDLE_SCHOOL);
        }
        return girl;
    }

    /**
     * @return 查询全量数据
     */
    public List<Girl> findAll(){
        return  girlRepository.findAll();
    }
    /**
     * 插入数据
     * @param gril 待插入数据
     * @param bindingResult 异常返回信息
     * @return
     */
    public HttpResult<Girl> girlAdd(@Valid Girl gril, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return HttpResultUtil.error("1",bindingResult.getFieldError().getDefaultMessage());
        }
        return HttpResultUtil.success(gril);
    }
    /**
     * 通过id查找用户信息
     * @param id
     * @return
     */
    public Optional<Girl> findById(Integer id) {
        return  girlRepository.findById(id);
    }

    /**
     * 通过id更新数据
     * @param id
     * @param girl 待更新数据
     * @return
     */
    public Girl UpdateById (Integer id , Girl girl){
        girl.setId(id);
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return  girlRepository.save(girl);
    }

    /**
     * 通过id删除数据
     * @param id
     */
    public void  deleteById(Integer id){
        girlRepository.deleteById(id);
    }

    /**
     *  通过年龄插座信息
     * @param age
     * @return
     */
    public List<Girl> findByAge( Integer age) {
        return girlRepository.findByAge(age);
    }
}
