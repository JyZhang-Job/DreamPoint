package com.ruoyi.project.system.dbmanage.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.dbmanage.domain.DbManage;
import com.ruoyi.project.system.dbmanage.domain.FdManage;
import com.ruoyi.project.system.dbmanage.domain.TbManage;
import com.ruoyi.project.system.dbmanage.service.ITbManageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库表管理Controller
 *
 * @author 宗国建
 * @date 2020-01-26
 */
@Controller
@RequestMapping("/system/tbmanage")
public class TbManageController extends BaseController {
    private String prefix = "system/tbmanage";

    @Autowired
    private ITbManageService tbManageService;

    @RequiresPermissions("system:tbmanage:view")
    @GetMapping()
    public String tbmanage() {
        return prefix + "/tbmanage";
    }

    /**
     * 查询数据库表管理列表
     */
    @RequiresPermissions("system:tbmanage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbManage tbManage) {


        startPage();
        List<TbManage> list = tbManageService.selectTbManageList(tbManage);

        if (null != tbManage.getSearchValue() && tbManage.getSearchValue().length() > 0) {
            List<String> tbIdList = tbManageService.selectFdManageList(tbManage.getSearchValue());
            list = list.stream().filter(a -> tbIdList.contains(a.getTbId().toString())).collect(Collectors.toList());
        }

        return getDataTable(list);
    }


    /**
     * 查询数据库表详细
     */
    @RequiresPermissions("system:tbmanage:list")
    @GetMapping("/tbmanage/{tbId}/{searchValue}")
    public String tbList(@PathVariable("tbId") Long tbId, @PathVariable("searchValue") String searchValue, ModelMap mmap) {
        System.out.println("==================");
        mmap.put("tbmanage", tbManageService.selectTbManageById(tbId));
        mmap.put("searchValue",searchValue);
        mmap.put("tbList", tbManageService.selectTbManageList(new TbManage()));
        return "system/fdmanage/fdmanage";
    }


    /*
     * 导出数据库表管理列表
     */
    @RequiresPermissions("system:tbmanage:export")
    @Log(title = "数据库表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbManage tbManage) {
        List<TbManage> list = tbManageService.selectTbManageList(tbManage);
        ExcelUtil<TbManage> util = new ExcelUtil<TbManage>(TbManage.class);
        return util.exportExcel(list, "tbmanage");
    }

    /**
     * 新增数据库表管理
     */
    @GetMapping("/add")
    public String add(@RequestParam String tbByDbid, ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        mmap.put("dbId", tbByDbid);
        return prefix + "/add";
    }

    /**
     * 新增保存数据库表管理
     */
    @RequiresPermissions("system:tbmanage:add")
    @Log(title = "数据库表管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbManage tbManage) {

        return toAjax(tbManageService.insertTbManage(tbManage));
    }

    /**
     * 修改数据库表管理
     */
    @GetMapping("/edit/{tbId}")
    public String edit(@PathVariable("tbId") Long tbId, ModelMap mmap) {
        TbManage tbManage = tbManageService.selectTbManageById(tbId);
        mmap.put("tbManage", tbManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据库表管理
     */
    @RequiresPermissions("system:tbmanage:edit")
    @Log(title = "数据库表管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbManage tbManage) {
        return toAjax(tbManageService.updateTbManage(tbManage));
    }

    /**
     * 删除数据库表管理
     */
    @RequiresPermissions("system:tbmanage:remove")
    @Log(title = "数据库表管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {

        return toAjax(tbManageService.deleteTbManageByIds(ids));
    }
}
