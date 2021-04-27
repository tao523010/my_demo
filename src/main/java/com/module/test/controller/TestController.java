package com.module.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.annotation.Log;
import com.web.controller.BusinessType;
import com.module.test.po.Test;
import com.module.test.service.ITestService;
import com.web.controller.BaseController;
import com.web.domain.AjaxResult;
import com.utils.poi.ExcelUtil;

import com.web.page.TableDataInfo;
import javax.servlet.http.HttpServletResponse;


/**
 * 测试表Controller
 * 
 * @author cjt
 * @date 2021-04-25
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController
{
    private String prefix = "test";

    @Autowired
    private ITestService testService;

    /**
     * 查询测试表列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Test test)
    {
        startPage();
        List<Test> list = testService.selectTestList(test);
        return getDataTable(list);
    }

    /**
     * 导出测试表列表
     */
    @Log(title = "测试表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HttpServletResponse response,Test test)
    {
        List<Test> list = testService.selectTestList(test);
        ExcelUtil<Test> util = new ExcelUtil<Test>(Test.class);
        return util.exportExcel(response,list, "test");
    }

    /**
     * 新增保存测试表
     */
    @Log(title = "测试表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Test test)
    {
        return toAjax(testService.insertTest(test));
    }


    /**
     * 修改保存测试表
     */
    @Log(title = "测试表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Test test)
    {
        return toAjax(testService.updateTest(test));
    }

    /**
     * 删除测试表
     */
    @Log(title = "测试表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testService.deleteTestByIds(ids));
    }

    @Log(title = "测试事务", businessType = BusinessType.OTHER)
    @RequestMapping( "/trans")
    @ResponseBody
    public AjaxResult test()
    {
        testService.test();
        return AjaxResult.success("ss");
    }

}
