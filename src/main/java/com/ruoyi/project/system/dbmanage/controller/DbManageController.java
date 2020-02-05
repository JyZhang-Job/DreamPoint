package com.ruoyi.project.system.dbmanage.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.dbmanage.domain.DbManage;
import com.ruoyi.project.system.dbmanage.service.IDbManageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 数据库管理Controller
 *
 * @author 宗国建
 * @date 2020-01-25
 */
@Controller
@RequestMapping("/system/dbmanage")
public class DbManageController extends BaseController {
    private String prefix = "system/dbmanage";

    @Autowired
    private IDbManageService dbManageService;

    @RequiresPermissions("system:dbmanage:view")
    @GetMapping()
    public String dbmanage() {
        return prefix + "/dbmanage";
    }

    /**
     * 查询数据库管理列表
     */
    @RequiresPermissions("system:dbmanage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DbManage dbManage) {
        startPage();
        List<DbManage> list = dbManageService.selectDbManageList(dbManage);
        return getDataTable(list);
    }

    /**
     * 查询数据库表详细
     */
    @RequiresPermissions("system:dbmanage:list")
    @GetMapping("/dbmanage/{dbId}")
    public String tbList(@PathVariable("dbId") Long dbId, ModelMap mmap)
    {
        mmap.put("dbmanage", dbManageService.selectDbManageById(dbId));
        mmap.put("dbList", dbManageService.selectDbManageList(new DbManage()));
        return "system/tbmanage/tbmanage";
    }


    /**
     * 导出数据库管理列表
     */
    @RequiresPermissions("system:dbmanage:export")
    @Log(title = "数据库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DbManage dbManage) {
        List<DbManage> list = dbManageService.selectDbManageList(dbManage);
        ExcelUtil<DbManage> util = new ExcelUtil<DbManage>(DbManage.class);
        return util.exportExcel(list, "dbmanage");
    }

    /**
     * 新增数据库管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {

        mmap.put("user",ShiroUtils.getSysUser());
        return prefix + "/add";
    }

    /**
     * 新增保存数据库管理
     */
    @RequiresPermissions("system:dbmanage:add")
    @Log(title = "数据库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DbManage dbManage) {
        return toAjax(dbManageService.insertDbManage(dbManage));
    }

    /**
     * 修改数据库管理
     */
    @GetMapping("/edit/{dbId}")
    public String edit(@PathVariable("dbId") Long dbId, ModelMap mmap) {
        DbManage dbManage = dbManageService.selectDbManageById(dbId);
        dbManage.setUpdateBy(ShiroUtils.getSysUser().getUserName());
        mmap.put("dbManage", dbManage);
        System.out.println(ShiroUtils.getSysUser().getUserName());
        return prefix + "/edit";
    }

    /**
     * 修改保存数据库管理
     */
    @RequiresPermissions("system:dbmanage:edit")
    @Log(title = "数据库管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DbManage dbManage,ModelMap mmap) {
        return toAjax(dbManageService.updateDbManage(dbManage));
    }

    /**
     * 删除数据库管理
     */
    @RequiresPermissions("system:dbmanage:remove")
    @Log(title = "数据库管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dbManageService.deleteDbManageByIds(ids));
    }
}
