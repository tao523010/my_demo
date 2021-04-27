package com.module.worker.controller;

import java.util.List;

import com.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.annotation.Log;
import com.web.controller.BusinessType;
import com.module.worker.po.WorkerInfo;
import com.module.worker.service.IWorkerInfoService;
import com.web.controller.BaseController;
import com.web.domain.AjaxResult;
import com.utils.poi.ExcelUtil;

import com.web.page.TableDataInfo;
import javax.servlet.http.HttpServletResponse;


/**
 * 测试表Controller
 *
 * @author cjt
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/worker")
public class WorkerInfoController extends BaseController
{
    private String prefix = "worker";

    @Autowired
    private IWorkerInfoService workerInfoService;

    /**
     * 查询测试表列表
     */
    @RequestMapping("/list")
    @ResponseBody

    public TableDataInfo list(WorkerInfo workerInfo)
    {
        startPage();
        List<WorkerInfo> list = workerInfoService.selectWorkerInfoList(workerInfo);
        return getDataTable(list);
    }

    /**
     * 导出测试表列表
     */
    @Log(title = "测试表", businessType = BusinessType.EXPORT)
    @RequestMapping("/export")
    @ResponseBody
    @DataSource("dm")
    public AjaxResult export(HttpServletResponse response,WorkerInfo workerInfo)
    {
        List<WorkerInfo> list = workerInfoService.selectWorkerInfoList(workerInfo);
        ExcelUtil<WorkerInfo> util = new ExcelUtil<WorkerInfo>(WorkerInfo.class);
        return util.exportExcel(response,list, "info");
    }

    /**
     * 新增保存测试表
     */
    @Log(title = "测试表", businessType = BusinessType.INSERT)
    @RequestMapping("/add")
    @ResponseBody
    @DataSource("dm")
    public AjaxResult addSave(WorkerInfo workerInfo)
    {
        return toAjax(workerInfoService.insertWorkerInfo(workerInfo));
    }


    /**
     * 修改保存测试表
     */
    @Log(title = "测试表", businessType = BusinessType.UPDATE)
    @RequestMapping("/edit")
    @ResponseBody
    @DataSource("dm")
    public AjaxResult editSave(@Validated WorkerInfo workerInfo)
    {
        return toAjax(workerInfoService.updateWorkerInfo(workerInfo));
    }

    /**
     * 删除测试表
     */
    @Log(title = "测试表", businessType = BusinessType.DELETE)
    @RequestMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workerInfoService.deleteWorkerInfoByIds(ids));
    }
}
