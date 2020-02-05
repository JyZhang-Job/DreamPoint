package com.ruoyi.project.module.projmanage.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.module.projmanage.domain.ProjectInfo;
import com.ruoyi.project.module.projmanage.domain.ProjectList;
import com.ruoyi.project.module.projmanage.service.IProjectInfoService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目管理详情Controller
 *
 * @author 宗国建
 * @date 2020-01-31
 */
@Controller
@RequestMapping("/module/projmanage")
public class ProjectInfoController extends BaseController {
    private String prefix = "module/projmanage";

    @Autowired
    private IProjectInfoService projectInfoService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("module:projmanage:view")
    @GetMapping()
    public String projmanage() {
        return prefix + "/projmanage";
    }

    /**
     * 查询项目管理详情列表
     */
    @RequiresPermissions("module:projmanage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectInfo projectInfo) {
        startPage();
        List<ProjectInfo> list = projectInfoService.selectProjectInfoList(projectInfo);
        return getDataTable(list);
    }


    /**
     * 项目详情
     */
    @RequiresPermissions("module:projmanage:view")
    @GetMapping("/projmanage/{projId}")
    public String projInfo(@PathVariable("projId") Long projId, ModelMap mmap) {
        ProjectInfo projectInfo = projectInfoService.selectProjectInfoById(projId);
        mmap.put("projInfo", projectInfo);
        return "module/projmanage/project_detail";
    }


    @GetMapping("/projList")
    public String projList() {
        return prefix + "/project_list";
    }


    @PostMapping("/test5")
    @ResponseBody
    public AjaxResult test() {
        List<ProjectList> list1 = new ArrayList<>();
        List<ProjectList> list2 = new ArrayList<>();
        List<ProjectList> list3 = new ArrayList<>();
        List<List<ProjectList>> dataList = new ArrayList<>();
        List<ProjectInfo> projInfoList = projectInfoService.selectProjectInfoList(new ProjectInfo());

        for (int i = 0; i < projInfoList.size(); i++) {
            ProjectList projectList = new ProjectList();
            String userids = projInfoList.get(i).getProjUserids();
            List<User> users = userService.selectUserListByIds(userids);
            projectList.setProjInfo(projInfoList.get(i));
            projectList.setUser(users);
            if (i % 3 == 0) {
                list1.add(projectList);
            } else if (i % 3 == 1) {
                list2.add(projectList);
            } else {
                list3.add(projectList);
            }
        }
        dataList.add(list1);
        dataList.add(list2);
        dataList.add(list3);

        return AjaxResult.success("ok", dataList);
    }


    /**
     * 导出项目管理详情列表
     */
    @RequiresPermissions("module:projmanage:export")
    @Log(title = "项目管理详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectInfo projectInfo) {
        List<ProjectInfo> list = projectInfoService.selectProjectInfoList(projectInfo);
        ExcelUtil<ProjectInfo> util = new ExcelUtil<ProjectInfo>(ProjectInfo.class);
        return util.exportExcel(list, "projmanage");
    }

    /**
     * 新增项目管理详情
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {

        mmap.put("user", userService.selectUserList(new User()));
        return prefix + "/add";
    }

    /**
     * 新增保存项目管理详情
     */
    @RequiresPermissions("module:projmanage:add")
    @Log(title = "项目管理详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectInfo projectInfo) {
        return toAjax(projectInfoService.insertProjectInfo(projectInfo));
    }

    /**
     * 修改项目管理详情
     */
    @GetMapping("/edit/{projId}")
    public String edit(@PathVariable("projId") Long projId, ModelMap mmap) {
        ProjectInfo projectInfo = projectInfoService.selectProjectInfoById(projId);
        mmap.put("projectInfo", projectInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目管理详情
     */
    @RequiresPermissions("module:projmanage:edit")
    @Log(title = "项目管理详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectInfo projectInfo) {
        return toAjax(projectInfoService.updateProjectInfo(projectInfo));
    }

    /**
     * 删除项目管理详情
     */
    @RequiresPermissions("module:projmanage:remove")
    @Log(title = "项目管理详情", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(projectInfoService.deleteProjectInfoByIds(ids));
    }
}
