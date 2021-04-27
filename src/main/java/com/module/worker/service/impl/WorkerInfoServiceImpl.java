package com.module.worker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.module.worker.mapper.WorkerInfoMapper;
import com.module.worker.po.WorkerInfo;
import com.module.worker.service.IWorkerInfoService;
import com.utils.Convert;

/**
 * 测试表Service业务层处理
 * 
 * @author cjt
 * @date 2021-01-12
 */
@Service
public class WorkerInfoServiceImpl implements IWorkerInfoService 
{
    @Autowired
    private WorkerInfoMapper workerInfoMapper;

    /**
     * 查询测试表
     * 
     * @param id 测试表ID
     * @return 测试表
     */
    @Override
    public WorkerInfo selectWorkerInfoById(Integer id)
    {
        return workerInfoMapper.selectWorkerInfoById(id);
    }

    /**
     * 查询测试表列表
     * 
     * @param workerInfo 测试表
     * @return 测试表
     */
    @Override
    public List<WorkerInfo> selectWorkerInfoList(WorkerInfo workerInfo)
    {
        return workerInfoMapper.selectWorkerInfoList(workerInfo);
    }

    /**
     * 新增测试表
     * 
     * @param workerInfo 测试表
     * @return 结果
     */
    @Override
    public int insertWorkerInfo(WorkerInfo workerInfo)
    {
        return workerInfoMapper.insertWorkerInfo(workerInfo);
    }

    /**
     * 修改测试表
     * 
     * @param workerInfo 测试表
     * @return 结果
     */
    @Override
    public int updateWorkerInfo(WorkerInfo workerInfo)
    {
        return workerInfoMapper.updateWorkerInfo(workerInfo);
    }

    /**
     * 删除测试表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkerInfoByIds(String ids)
    {
        return workerInfoMapper.deleteWorkerInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试表信息
     * 
     * @param id 测试表ID
     * @return 结果
     */
    @Override
    public int deleteWorkerInfoById(Integer id)
    {
        return workerInfoMapper.deleteWorkerInfoById(id);
    }
}
