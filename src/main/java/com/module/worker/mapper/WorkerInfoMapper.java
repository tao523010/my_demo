package com.module.worker.mapper;

import java.util.List;
import com.module.worker.po.WorkerInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 测试表Mapper接口
 * 
 * @author cjt
 * @date 2021-01-12
 */
public interface WorkerInfoMapper extends BaseMapper<WorkerInfo>
{
    /**
     * 查询测试表
     * 
     * @param id 测试表ID
     * @return 测试表
     */
    public WorkerInfo selectWorkerInfoById(Integer id);

    /**
     * 查询测试表列表
     * 
     * @param workerInfo 测试表
     * @return 测试表集合
     */
    public List<WorkerInfo> selectWorkerInfoList(WorkerInfo workerInfo);

    /**
     * 新增测试表
     * 
     * @param workerInfo 测试表
     * @return 结果
     */
    public int insertWorkerInfo(WorkerInfo workerInfo);

    /**
     * 修改测试表
     * 
     * @param workerInfo 测试表
     * @return 结果
     */
    public int updateWorkerInfo(WorkerInfo workerInfo);

    /**
     * 删除测试表
     * 
     * @param id 测试表ID
     * @return 结果
     */
    public int deleteWorkerInfoById(Integer id);

    /**
     * 批量删除测试表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkerInfoByIds(String[] ids);
}
