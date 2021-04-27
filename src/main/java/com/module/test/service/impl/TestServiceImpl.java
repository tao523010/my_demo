package com.module.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.module.test.mapper.TestMapper;
import com.module.test.po.Test;
import com.module.test.service.ITestService;
import com.utils.Convert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试表Service业务层处理
 * 
 * @author cjt
 * @date 2021-04-25
 */
@Service
public class TestServiceImpl implements ITestService 
{
    @Autowired
    private TestMapper testMapper;

    /**
     * 查询测试表
     * 
     * @param id 测试表ID
     * @return 测试表
     */
    @Override
    public Test selectTestById(Integer id)
    {
        return testMapper.selectTestById(id);
    }

    /**
     * 查询测试表列表
     * 
     * @param test 测试表
     * @return 测试表
     */
    @Override
    public List<Test> selectTestList(Test test)
    {
        return testMapper.selectTestList(test);
    }

    /**
     * 新增测试表
     * 
     * @param test 测试表
     * @return 结果
     */
    @Override
    public int insertTest(Test test)
    {
        return testMapper.insertTest(test);
    }

    /**
     * 修改测试表
     * 
     * @param test 测试表
     * @return 结果
     */
    @Override
    public int updateTest(Test test)
    {
        return testMapper.updateTest(test);
    }

    /**
     * 删除测试表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestByIds(String ids)
    {
        return testMapper.deleteTestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试表信息
     * 
     * @param id 测试表ID
     * @return 结果
     */
    @Override
    public int deleteTestById(Integer id)
    {
        return testMapper.deleteTestById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test(){
        Test t = new Test();
        t.setId(1);
        t.setName("A");
        testMapper.updateTest(t);
//        try {
            add1();
//        }catch (Exception e) {
//
//        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add1(){
        Test t = new Test();
        t.setName("c");
        testMapper.insertTest(t);
        int i = 1/0;

    }
}
