package com.ruoyi.project.system.dbmanage.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.dbmanage.domain.FdManage;
import com.ruoyi.project.system.dbmanage.service.IFdManageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库字段管理Controller
 * 
 * @author 宗国建
 * @date 2020-01-27
 */
@Controller
@RequestMapping("/system/fdmanage")
public class FdManageController extends BaseController
{
    private String prefix = "system/fdmanage";

    @Autowired
    private IFdManageService fdManageService;

    @RequiresPermissions("system:fdmanage:view")
    @GetMapping()
    public String fdmanage()
    {
        return prefix + "/fdmanage";
    }

    /**
     * 查询数据库字段管理列表
     */
    @RequiresPermissions("system:fdmanage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FdManage fdManage)
    {
        startPage();
        List<FdManage> list = fdManageService.selectFdManageList(fdManage);
        return getDataTable(list);
    }

    /**
     * 导出数据库字段管理列表
     */
    @RequiresPermissions("system:fdmanage:export")
    @Log(title = "数据库字段管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FdManage fdManage)
    {
        List<FdManage> list = fdManageService.selectFdManageList(fdManage);
        ExcelUtil<FdManage> util = new ExcelUtil<FdManage>(FdManage.class);
        return util.exportExcel(list, "fdmanage");
    }

    /**
     * 新增数据库字段管理
     */
    @GetMapping("/add")
    public String add(@RequestParam String tbId, ModelMap mmap)
    {
        System.out.println("--------------"+tbId);
        mmap.put("user", ShiroUtils.getSysUser());
        mmap.put("tbId", tbId);
        return prefix + "/add";
    }



    /**
     * 新增保存数据库字段管理
     */
    @RequiresPermissions("system:fdmanage:add")
    @Log(title = "数据库字段管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FdManage fdManage)
    {
        return toAjax(fdManageService.insertFdManage(fdManage));
    }

    /**
     * 修改数据库字段管理
     */
    @GetMapping("/edit/{fdId}")
    public String edit(@PathVariable("fdId") Long fdId, ModelMap mmap)
    {
        FdManage fdManage = fdManageService.selectFdManageById(fdId);
        mmap.put("fdManage", fdManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据库字段管理
     */
    @RequiresPermissions("system:fdmanage:edit")
    @Log(title = "数据库字段管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FdManage fdManage)
    {
        return toAjax(fdManageService.updateFdManage(fdManage));
    }

    /**
     * 删除数据库字段管理
     */
    @RequiresPermissions("system:fdmanage:remove")
    @Log(title = "数据库字段管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fdManageService.deleteFdManageByIds(ids));
    }
}
