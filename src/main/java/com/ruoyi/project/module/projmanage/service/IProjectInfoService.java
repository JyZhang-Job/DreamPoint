package com.ruoyi.project.module.projmanage.service;

import com.ruoyi.project.module.projmanage.domain.ProjectInfo;
import java.util.List;

/**
 * 项目管理详情Service接口
 * 
 * @author 宗国建
 * @date 2020-01-31
 */
public interface IProjectInfoService 
{
    /**
     * 查询项目管理详情
     * 
     * @param projId 项目管理详情ID
     * @return 项目管理详情
     */
    public ProjectInfo selectProjectInfoById(Long projId);

    /**
     * 查询项目管理详情列表
     * 
     * @param projectInfo 项目管理详情
     * @return 项目管理详情集合
     */
    public List<ProjectInfo> selectProjectInfoList(ProjectInfo projectInfo);

    /**
     * 新增项目管理详情
     * 
     * @param projectInfo 项目管理详情
     * @return 结果
     */
    public int insertProjectInfo(ProjectInfo projectInfo);

    /**
     * 修改项目管理详情
     * 
     * @param projectInfo 项目管理详情
     * @return 结果
     */
    public int updateProjectInfo(ProjectInfo projectInfo);

    /**
     * 批量删除项目管理详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectInfoByIds(String ids);

    /**
     * 删除项目管理详情信息
     * 
     * @param projId 项目管理详情ID
     * @return 结果
     */
    public int deleteProjectInfoById(Long projId);
}
